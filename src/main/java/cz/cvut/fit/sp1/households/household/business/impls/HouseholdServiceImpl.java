package cz.cvut.fit.sp1.households.household.business.impls;


import cz.cvut.fit.sp1.households.household.business.services.HouseholdService;
import cz.cvut.fit.sp1.households.household.data.entities.HouseholdEntity;
import cz.cvut.fit.sp1.households.household.data.entities.MemberEntity;
import cz.cvut.fit.sp1.households.household.data.repositories.impls.HouseholdRepository;
import cz.cvut.fit.sp1.households.household.SecurityUtils;
import cz.cvut.fit.sp1.households.household.business.services.UserService;
import cz.cvut.fit.sp1.households.household.data.repositories.impls.UserRepository;
import cz.cvut.fit.sp1.households.household.data.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class HouseholdServiceImpl implements HouseholdService {
    private final HouseholdRepository householdRepository;
    @Autowired
    public HouseholdServiceImpl(HouseholdRepository householdRepository) {
        this.householdRepository = householdRepository;
    }


    @Override
    public HouseholdEntity createHousehold(String address, String name) {
        HouseholdEntity newHousehold = new HouseholdEntity(address, name, 0);
        return create(newHousehold);
    }

    @Override
    public HouseholdEntity getByName(String name) {
        return householdRepository.findByName(name);
    }

    @Override
    public HouseholdEntity findByHouseholdId(int householdId) {
        return householdRepository.findByHouseholdId(householdId);
    }


    @Override
    public HouseholdEntity create(HouseholdEntity entity) {
        if (householdRepository.existsById(entity.getHouseholdId())) {
            throw new EntityExistsException();
        }
        return householdRepository.save(entity);
    }
    @Override
    public Optional<HouseholdEntity> readById(String id) {
        return householdRepository.findById(Integer.parseInt(id));
    }

    @Override
    public Page<HouseholdEntity> readAll(Pageable pageable) {
        return householdRepository.findAll(pageable);
    }

    @Override
    public void update(HouseholdEntity newEntity) {
        householdRepository.save(newEntity);
    }

    @Override
    public void delete(String id) {
        householdRepository.deleteById(Integer.parseInt(id));
    }

    private HouseholdEntity findOrThrow(int householdId) {
        Optional<HouseholdEntity> optionalUser = readById(Integer.toString(householdId));
        if (optionalUser.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return optionalUser.get();
    }
}
