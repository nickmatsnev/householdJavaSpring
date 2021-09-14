package cz.cvut.fit.sp1.households.household.api.dto;

public class NewHouseholdDTO {

    private String name;
    private String address;

    public NewHouseholdDTO(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
