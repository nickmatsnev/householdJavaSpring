package cz.cvut.fit.sp1.households.household.business.impls;

import cz.cvut.fit.sp1.households.household.business.services.InvitationService;
import cz.cvut.fit.sp1.households.household.data.entities.InvitationEntity;
import cz.cvut.fit.sp1.households.household.data.repositories.impls.InvitationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvitationServiceImpl implements InvitationService {

    InvitationRepository invitationRepository;

    @Autowired
    public InvitationServiceImpl(InvitationRepository invitationRepository) {
        this.invitationRepository = invitationRepository;
    }

    public List<InvitationEntity> getAllByHouseAndUser(int householdId, int userId) {
        return invitationRepository.findAllByHouseholdIdAndUserId(householdId, userId);
    }

    public List<InvitationEntity> getAllByHouse(int householdId) {
        return invitationRepository.findAllByHouseholdId(householdId);
    }

    public List<InvitationEntity> getAllByUser(int userId) {
        return invitationRepository.findAllByUserId(userId);
    }

    public InvitationEntity getByInvitationId(int invitationId) {
        return invitationRepository.findByInvitationId(invitationId);
    }

    @Override
    public InvitationEntity create(InvitationEntity entity) {
        return invitationRepository.save(entity);
    }

    @Override
    public Optional<InvitationEntity> readById(Integer integer) {
        return invitationRepository.findById(integer);
    }

    @Override
    public Page<InvitationEntity> readAll(Pageable pageable) {
        return null;
    }

    @Override
    public void update(InvitationEntity newEntity) {
        invitationRepository.save(newEntity);
    }

    @Override
    public void delete(Integer integer) {
        invitationRepository.deleteById(integer);
    }

    @Override
    public InvitationEntity delete(int invitationId) {
        invitationRepository.deleteById(invitationId);
        return null;
    }

}
