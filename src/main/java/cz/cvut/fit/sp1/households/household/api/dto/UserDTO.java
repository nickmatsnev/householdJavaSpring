package cz.cvut.fit.sp1.households.household.api.dto;

import cz.cvut.fit.sp1.households.household.data.entities.UserEntity;

public class UserDTO {

    private int id;
    private int age;
    private String name;
    private String email;

    public UserDTO(int id, int age, String name, String email) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.email = email;
    }
    public UserDTO(UserEntity userEntity){
        this.id = userEntity.getUserId();
        this.age = userEntity.getDob();
        this.name = userEntity.getFullName();
        this.email = userEntity.getEmail();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

