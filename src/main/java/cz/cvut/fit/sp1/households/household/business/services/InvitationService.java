package cz.cvut.fit.sp1.households.household.business.services;

import cz.cvut.fit.sp1.households.household.data.entities.InvitationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface InvitationService extends CrudService<InvitationEntity, Integer>{

    List<InvitationEntity> getAllByHouseAndUser( int householdId, int userId);

    List<InvitationEntity> getAllByHouse(int householdId);

    List<InvitationEntity> getAllByUser(int userId);

    InvitationEntity getByInvitationId(int invitationId);

    InvitationEntity delete(int invitationId);
}
