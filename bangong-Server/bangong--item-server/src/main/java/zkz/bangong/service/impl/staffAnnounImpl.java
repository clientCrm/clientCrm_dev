package zkz.bangong.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zkz.bangong.mapper.crmAnnounMapper;
import zkz.bangong.pojo.PageResult;
import zkz.bangong.pojo.crmAnnoun;
import zkz.bangong.pojo.crmTask;
import zkz.bangong.service.staffAnnounService;

import java.util.Date;
import java.util.List;
@Service
public class staffAnnounImpl implements staffAnnounService {
    @Autowired
    private crmAnnounMapper crmAnnounMapper;
/*根据公告状态查找公告列表*/
    @Override
    public PageResult<crmAnnoun> getAnnounByStatus(String value, Integer crmUserId, Integer page, Integer rows) {
            //先判断该用户有权限查看的公告
       List<crmAnnoun> crmAnnounList= crmAnnounMapper.selectMyAnnoun(crmUserId);
        System.out.println(crmAnnounList.size());
        Date current = new Date();
            //在根据公告状态过滤
        for (int i=0;i<crmAnnounList.size();i++) {
            crmAnnoun crmAnnoun = crmAnnounList.get(i);
            Date startTime = crmAnnoun.getStartTime();//开始时间
            Date endTime = crmAnnoun.getEndTime();//结束时间
            System.out.println((current.getTime()-current.getTime()) +"..." +(endTime.getTime()-current.getTime())+"\n") ;

            if ("公示中".equals(value)) {
                if (current.getTime() - startTime.getTime() < 0 || endTime.getTime() - current.getTime() <0) {
                    crmAnnounList.remove(i);
                    i--;
                }

            } else if ("已结束".equals(value)) {
                if (current.getTime() - endTime.getTime() < 0) {
                    crmAnnounList.remove(i);
                    i--;
                }
            }

        }
            PageHelper.startPage(page,rows);

            // 包装成pageInfo
            PageInfo<crmAnnoun> pageInfo = new PageInfo<>(crmAnnounList);
            // 包装成分页结果集返回
            return new PageResult<>(pageInfo.getTotal(), pageInfo.getList());



    }

    /*添加公告一条*/
    @Override
    public void addAnnoun(crmAnnoun crmAnnoun) {
        crmAnnounMapper.insert(crmAnnoun);
    }
}
