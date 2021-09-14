package cz.cvut.fit.sp1.households.household.data.repositories.impls;

import cz.cvut.fit.sp1.households.household.data.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    UserEntity getUserEntityByUserId(int userId);
    UserEntity findByEmail(String email);
}
