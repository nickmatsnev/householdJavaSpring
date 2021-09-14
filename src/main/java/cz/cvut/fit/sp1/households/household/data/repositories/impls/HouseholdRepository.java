package cz.cvut.fit.sp1.households.household.data.repositories.impls;

import cz.cvut.fit.sp1.households.household.data.entities.HouseholdEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseholdRepository extends JpaRepository<HouseholdEntity, Integer>{

    HouseholdEntity findByName(String name);

    HouseholdEntity findByHouseholdId(int householdId);
}
