package cz.cvut.fit.sp1.households.household.business.services;


import cz.cvut.fit.sp1.households.household.data.entities.MemberEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MemberService extends CrudService<MemberEntity, Integer> {

    List<MemberEntity> findByHouse( int householdId);

    MemberEntity findByUserId(int userId);

    List<MemberEntity> getAllByUserId(int userId);

    MemberEntity findByHouseholdIdAndMembershipType(int household, String membershipType);

    List<MemberEntity> findAllByHouseholdIdAndMembershipType(int householdId, String membershipType);
}
