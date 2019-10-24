package zkz.bangong.service;

import org.springframework.stereotype.Service;
import zkz.bangong.layui.crmLayuiAnnoun;
import zkz.bangong.pojo.PageResult;
import zkz.bangong.pojo.crmAnnoun;

public interface staffAnnounService {

     PageResult<crmLayuiAnnoun> getAnnounByStatus(String value, Integer crmUserId, Integer page, Integer rows) ;

    /*添加一条公告*/
    void addAnnoun(crmAnnoun crmAnnoun);
}
