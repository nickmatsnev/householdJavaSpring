package cz.cvut.fit.sp1.households.household.api.controllers;


import cz.cvut.fit.sp1.households.household.api.dto.EmailWrapperDTO;
import cz.cvut.fit.sp1.households.household.api.dto.HouseholdDTO;
import cz.cvut.fit.sp1.households.household.api.dto.NewHouseholdDTO;
import cz.cvut.fit.sp1.households.household.business.services.HouseholdService;
import cz.cvut.fit.sp1.households.household.business.services.InvitationService;
import cz.cvut.fit.sp1.households.household.business.services.MemberService;
import cz.cvut.fit.sp1.households.household.business.services.UserService;
import cz.cvut.fit.sp1.households.household.data.entities.HouseholdEntity;
import cz.cvut.fit.sp1.households.household.data.entities.InvitationEntity;
import cz.cvut.fit.sp1.households.household.data.entities.MemberEntity;
import cz.cvut.fit.sp1.households.household.data.entities.UserEntity;
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
@RequestMapping("/households")
public class HouseholdController {

    private final HouseholdService householdService;
    private UserService userService;
    private InvitationService invitationService;
    private MemberService memberService;

    @Autowired
    public HouseholdController(HouseholdService householdService, UserService userService, InvitationService invitationService, MemberService memberService) {
        this.householdService = householdService;
        this.userService = userService;
        this.invitationService = invitationService;
        this.memberService = memberService;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody NewHouseholdDTO household, @RequestHeader("Authorization") String header) {
        int creatorId;
        try {
            creatorId = JwtProvider.getUserIdFromHeader(header);
        } catch (SignatureException e) {
            return new ResponseEntity<>("\"Invalid JWT token.\"", HttpStatus.UNAUTHORIZED);
        }
        try {
            HouseholdEntity ent = householdService.createHousehold(household.getAddress(), household.getName());
            memberService.create(new MemberEntity("Owner", ent.getHouseholdId(), creatorId));

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(
                "{}",
                HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<HouseholdDTO>> getUserHouseholds(@RequestHeader("Authorization") String header) {
        int userId;
        try {
            userId = JwtProvider.getUserIdFromHeader(header);
        } catch (SignatureException e) {
            return new ResponseEntity("\"Invalid JWT token.\"", HttpStatus.UNAUTHORIZED);
        }

        List<HouseholdDTO> result = new ArrayList<>();
        List<MemberEntity> ls = memberService.getAllByUserId(userId);
        for (MemberEntity m : ls) {
            result.add(new HouseholdDTO(householdService.findByHouseholdId(m.getHouseholdId()),memberService,userService));
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/{id}/invite")
    public ResponseEntity<String> invite(@RequestBody EmailWrapperDTO userEmail, @PathVariable("id") int householdId, @RequestHeader("Authorization") String header) {
        int invitorId;
        try {
            invitorId = JwtProvider.getUserIdFromHeader(header);
        } catch (SignatureException e) {
            return new ResponseEntity<>("\"Invalid JWT token.\"", HttpStatus.UNAUTHORIZED);
        }
        try {
            UserEntity user = userService.findByEmail(userEmail.getEmail());
            invitationService.create(new InvitationEntity(invitorId, householdId, user.getUserId()));
            return new ResponseEntity<>(
                    "{}",
                    HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>("{}",HttpStatus.NOT_FOUND);
        }
    }
}
