package cz.cvut.fit.sp1.households.household.business.impls;


import cz.cvut.fit.sp1.households.household.business.services.UserService;
import cz.cvut.fit.sp1.households.household.SecurityUtils;
import cz.cvut.fit.sp1.households.household.data.repositories.impls.UserRepository;
import cz.cvut.fit.sp1.households.household.data.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean loginUser(String email, String password) {
        UserEntity user = findOrThrow(email);
        return SecurityUtils.getPasswordHash(email, password).equals(user.getPassword());
    }

    @Override
    public UserEntity registerUser(String fullName, String email, String password, Integer age) {
        UserEntity newUser = new UserEntity(fullName, email, SecurityUtils.getPasswordHash(email, password), null, age);
        return create(newUser);
    }

    @Override
    public UserEntity create(UserEntity entity) {
        UserEntity ent = userRepository.findByEmail(entity.getEmail());
        if (ent != null) {
            throw new EntityExistsException();
        }
        return userRepository.save(entity);
    }

    @Override
    public Optional<UserEntity> readById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public Page<UserEntity> readAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public void update(UserEntity newEntity) {
        userRepository.save(newEntity);
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    public UserEntity getById(int userId) {
        return userRepository.getUserEntityByUserId(userId);
    }

    @Override
    public UserEntity findByEmail(String email) {
        return findOrThrow(email);
    }

    private UserEntity findOrThrow(String email) {
        UserEntity optionalUser = userRepository.findByEmail(email);
        if (optionalUser == null) {
            throw new IllegalArgumentException();
        }
        return optionalUser;
    }
}
