package cz.cvut.fit.sp1.households.household.business.services;

import cz.cvut.fit.sp1.households.household.data.entities.UserEntity;

public interface UserService extends CrudService<UserEntity, Integer> {

    boolean loginUser(String username, String password);

    UserEntity registerUser(String fullName, String email, String password,Integer age);

    UserEntity getById(int userId);

    UserEntity findByEmail(String email);

}
