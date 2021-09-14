package cz.cvut.fit.sp1.households.household.data.repositories.impls;

import cz.cvut.fit.sp1.households.household.data.entities.MemberEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Integer> {

    List<MemberEntity> findAllByHouseholdId(int householdId);

    MemberEntity findByUserId(int UserId);

    List<MemberEntity> findAllByUserId(int UserId);

    MemberEntity findByHouseholdIdAndMembershipType(int householdId, String membershipType);

    List<MemberEntity> findAllByHouseholdIdAndMembershipType(int householdId, String membershipType);
}
// Paging query needs to have a Pageable parameter! Offending method public abstract org.springframework.data.domain.
// Page cz.cvut.fit.sp1.households.household.data.repositories.impls.MemberRepository.findAllByHouseholdId(int)
//   at org.springframework.beans.factory.sup