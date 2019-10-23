package zkz.kehu.service;

import org.springframework.stereotype.Service;
import zkz.kehu.pojo.CrmUser;

public interface LoginService {
    CrmUser checkLogin(String username, String password);
}
