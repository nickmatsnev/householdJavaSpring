package cz.cvut.fit.sp1.households.household.business.services;

import cz.cvut.fit.sp1.households.household.data.entities.HouseholdEntity;

public interface HouseholdService  extends CrudService<HouseholdEntity, String>{

    HouseholdEntity createHousehold(String address, String name );

    HouseholdEntity getByName(String name);

    HouseholdEntity findByHouseholdId(int householdId);
}
