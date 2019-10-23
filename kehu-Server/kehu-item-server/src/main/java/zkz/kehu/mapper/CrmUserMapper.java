package zkz.kehu.mapper;

import zkz.kehu.pojo.CrmUser;

public interface CrmUserMapper {
    CrmUser checkLogin(String username, String password);
}
