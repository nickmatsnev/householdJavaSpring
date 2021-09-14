package cz.cvut.fit.sp1.households.household.data.repositories.impls;

import cz.cvut.fit.sp1.households.household.data.entities.InvitationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InvitationRepository extends JpaRepository<InvitationEntity, Integer> {

    public List<InvitationEntity> findAllByHouseholdIdAndUserId(int householdId, int userId);

    public List<InvitationEntity> findAllByHouseholdId( int householdId);

    @Query("SELECT u FROM InvitationEntity u WHERE u.receiverId = ?1")
    public List<InvitationEntity> findAllByUserId(int receiverId);

    public InvitationEntity findByInvitationId( int invitationId);


}
