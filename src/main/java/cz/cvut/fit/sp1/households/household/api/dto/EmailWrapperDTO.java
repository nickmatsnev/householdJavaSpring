package cz.cvut.fit.sp1.households.household.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmailWrapperDTO {

    private String email;

    public EmailWrapperDTO(@JsonProperty("email") String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
