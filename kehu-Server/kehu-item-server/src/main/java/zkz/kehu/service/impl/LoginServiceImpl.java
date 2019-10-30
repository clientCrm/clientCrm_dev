package zkz.kehu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zkz.kehu.mapper.CrmUserMapper;
import zkz.kehu.pojo.CrmUser;
import zkz.kehu.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private CrmUserMapper crmUserMapper;

    @Override
    public CrmUser checkLogin(String username, String password) {
        CrmUser crmUser = crmUserMapper.checkLogin(username, password);
        return crmUser;
    }
}
