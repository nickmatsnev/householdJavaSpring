package cz.cvut.fit.sp1.households.household.api.dto;

import cz.cvut.fit.sp1.households.household.business.services.HouseholdService;
import cz.cvut.fit.sp1.households.household.business.services.MemberService;
import cz.cvut.fit.sp1.households.household.business.services.UserService;
import cz.cvut.fit.sp1.households.household.data.entities.HouseholdEntity;
import cz.cvut.fit.sp1.households.household.data.entities.MemberEntity;
import org.apache.catalina.User;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class HouseholdDTO {
    private String address;
    private String name;
    private int id;
    private UserDTO owner;
    private List<UserDTO> members;

    public HouseholdDTO(String address, String name, int id, UserDTO owner, List<UserDTO> members) {
        this.address = address;
        this.name = name;
        this.id = id;
        this.owner = owner;
        this.members = members;
    }

    public HouseholdDTO( HouseholdEntity h, MemberService memberService, UserService userService){
        this.address = h.getAddress();
        this.name = h.getName();
        this.id = h.getHouseholdId();
        MemberEntity tmp = memberService.findByHouseholdIdAndMembershipType(h.getHouseholdId(), "Owner");
        this.owner = new UserDTO(userService.getById(memberService.findByHouseholdIdAndMembershipType(h.getHouseholdId(), "Owner").getUserId()));
        List<MemberEntity> page = memberService.findAllByHouseholdIdAndMembershipType(h.getHouseholdId(),"member");
        List<UserDTO> members = new ArrayList<>();
        for (MemberEntity m : page){
            members.add(new UserDTO(userService.getById(m.getUserId())));
        }
        this.members = members;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserDTO getOwner() {
        return owner;
    }

    public void setOwner(UserDTO owner) {
        this.owner = owner;
    }

    public List<UserDTO> getMembers() {
        return members;
    }

    public void setMembers(List<UserDTO> members) {
        this.members = members;
    }

}
