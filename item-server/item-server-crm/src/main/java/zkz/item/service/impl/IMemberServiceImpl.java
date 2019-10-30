package zkz.item.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zkz.item.mapper.IMemberMapper;
import zkz.item.pojo.IMember;
import zkz.item.service.IMemberService;
import zkz.item.util.Base;

@Service
public class IMemberServiceImpl implements IMemberService {
    @Autowired
    private IMemberMapper iMemberMapper;

    @Override
    public Base addMember(IMember iMember) {
        Base base=new Base();
        base.setResule(iMemberMapper.insert(iMember));
        return base;
    }
}
