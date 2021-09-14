package cz.cvut.fit.sp1.households.household.business.impls;


import cz.cvut.fit.sp1.households.household.business.services.MemberService;
import cz.cvut.fit.sp1.households.household.data.entities.MemberEntity;
import cz.cvut.fit.sp1.households.household.data.repositories.impls.MemberRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //Page<MemberDTO> allMembersFromHousehold = memberService.findAllByHouseholdId(householdId);
    @Override
    public MemberEntity create(MemberEntity entity) {
        int longnum = entity.getMemberId();
        if (memberRepository.existsById(longnum)) {
            throw new EntityExistsException();
        }
        return memberRepository.save(entity);
    }

    @Override
    public Optional<MemberEntity> readById(Integer id) {
        return memberRepository.findById(id);
    }

    @Override
    public List<MemberEntity> findByHouse(int householdId){
        return memberRepository.findAllByHouseholdId( householdId);
    }

    @Override
    public MemberEntity findByUserId(int userId) {
        return memberRepository.findByUserId(userId);
    }

    public List<MemberEntity> getAllByUserId(int userId) {
        return memberRepository.findAllByUserId(userId);
    }

    @Override
    public MemberEntity findByHouseholdIdAndMembershipType(int household, String membershipType) {
        return memberRepository.findByHouseholdIdAndMembershipType(household, membershipType);
    }

    @Override
    public List<MemberEntity> findAllByHouseholdIdAndMembershipType(int householdId, String membershipType) {
        return memberRepository.findAllByHouseholdIdAndMembershipType(householdId, membershipType);
    }

    @Override
    public Page<MemberEntity> readAll(Pageable pageable) {
        return memberRepository.findAll(pageable);
    }

    @Override
    public void update(MemberEntity newEntity) {
        memberRepository.save(newEntity);
    }

    @Override
    public void delete(Integer id) {
        memberRepository.deleteById(id);
    }

    private MemberEntity findOrThrow(Integer id) {
        Optional<MemberEntity> optionalMember = readById(id);
        if (optionalMember.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return optionalMember.get();
    }
}
