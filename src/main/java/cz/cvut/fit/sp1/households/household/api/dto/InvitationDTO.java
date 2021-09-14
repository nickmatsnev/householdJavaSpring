package cz.cvut.fit.sp1.households.household.api.dto;

import cz.cvut.fit.sp1.households.household.business.services.HouseholdService;
import cz.cvut.fit.sp1.households.household.business.services.MemberService;
import cz.cvut.fit.sp1.households.household.business.services.UserService;
import cz.cvut.fit.sp1.households.household.data.entities.InvitationEntity;
import cz.cvut.fit.sp1.households.household.data.entities.MemberEntity;

public class InvitationDTO {

    private int id;
    private UserDTO fromUser;
    private UserDTO toUser;
    private HouseholdDTO toHousehold;

    public InvitationDTO(int id, UserDTO fromUser, HouseholdDTO toHousehold, UserDTO toUser) {
        this.id = id;
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.toHousehold = toHousehold;
    }

    public InvitationDTO(InvitationEntity invitationEntity, MemberService memberService, UserService userService, HouseholdService householdService) {
        this.id = invitationEntity.getInvitationId();
        this.fromUser = new UserDTO(userService.getById(invitationEntity.getUserId()));
        this.toUser = new UserDTO(userService.getById(invitationEntity.getReceiverId()));
        this.toHousehold = new HouseholdDTO(householdService.findByHouseholdId(invitationEntity.getHouseholdId()), memberService, userService);
    }

    public UserDTO getToUser() {
        return toUser;
    }

    public void setToUser(UserDTO toUser) {
        this.toUser = toUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserDTO getFromUser() {
        return fromUser;
    }

    public void setFromUser(UserDTO fromUser) {
        this.fromUser = fromUser;
    }

    public HouseholdDTO getToHousehold() {
        return toHousehold;
    }

    public void setToHousehold(HouseholdDTO toHousehold) {
        this.toHousehold = toHousehold;
    }
}
