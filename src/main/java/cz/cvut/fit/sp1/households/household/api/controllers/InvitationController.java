package cz.cvut.fit.sp1.households.household.api.controllers;


import cz.cvut.fit.sp1.households.household.api.dto.InvitationDTO;
import cz.cvut.fit.sp1.households.household.business.services.HouseholdService;
import cz.cvut.fit.sp1.households.household.business.services.InvitationService;
import cz.cvut.fit.sp1.households.household.business.services.MemberService;
import cz.cvut.fit.sp1.households.household.business.services.UserService;
import cz.cvut.fit.sp1.households.household.data.entities.InvitationEntity;
import cz.cvut.fit.sp1.households.household.data.entities.MemberEntity;
import cz.cvut.fit.sp1.households.household.security.JwtProvider;
import io.jsonwebtoken.SignatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/invitations")
public class InvitationController {
    InvitationService invitationService;
    MemberService memberService;
    UserService userService;
    HouseholdService householdService;

    @Autowired
    public InvitationController(InvitationService invitationService, MemberService memberService, UserService userService, HouseholdService householdService) {
        this.invitationService = invitationService;
        this.memberService = memberService;
        this.userService = userService;
        this.householdService = householdService;
    }

    @GetMapping
    public ResponseEntity<List<InvitationDTO>> getUserInvitations(@RequestHeader("Authorization") String header) {
        int userId;
        try {
            userId = JwtProvider.getUserIdFromHeader(header);
        } catch (SignatureException e) {
            return new ResponseEntity("\"Invalid JWT token.\"", HttpStatus.UNAUTHORIZED);
        }
        List<InvitationDTO> result = new ArrayList<>();
        List<InvitationEntity> invitationEntityList = invitationService.getAllByUser( userId);
        for( InvitationEntity element : invitationEntityList){
            result.add( new InvitationDTO(element,memberService,userService,householdService));
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/{id}/reject")
    public ResponseEntity<String> reject(@PathVariable("id") int invitationId, @RequestHeader("Authorization") String header) {
        int userId;
        try {
            userId = JwtProvider.getUserIdFromHeader(header);
        } catch (SignatureException e) {
            return new ResponseEntity("\"Invalid JWT token.\"", HttpStatus.UNAUTHORIZED);
        }
        //TODO Check if user who sent the request is the one who was invited. If not, respond with Unauthorized
        if (invitationService.getByInvitationId(invitationId).getReceiverId() == userId) {
            invitationService.delete(invitationId);
            return new ResponseEntity<>("{}", HttpStatus.OK);
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/{id}/accept")
    public ResponseEntity<String> accept(@PathVariable("id") int invitationId, @RequestHeader("Authorization") String header) {
        int userId;
        try {
            userId = JwtProvider.getUserIdFromHeader(header);
        } catch (SignatureException e) {
            return new ResponseEntity("\"Invalid JWT token.\"", HttpStatus.UNAUTHORIZED);
        }
        //TODO Check if user who sent the request is the one who was invited. If not, respond with Unauthorized
        if(invitationService.getByInvitationId(invitationId).getReceiverId() != userId){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        //TODO Check and test this logic
        MemberEntity newMember = new MemberEntity();
        newMember.setHouseholdId(invitationService.getByInvitationId(invitationId).getHouseholdId());
        newMember.setUserId(invitationService.getByInvitationId(invitationId).getReceiverId());
        newMember.setMembershipType("member");
        memberService.create(newMember);
        invitationService.delete(invitationId);
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }
}
