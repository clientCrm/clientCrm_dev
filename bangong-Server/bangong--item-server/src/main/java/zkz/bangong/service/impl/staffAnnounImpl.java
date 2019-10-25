package zkz.bangong.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zkz.bangong.common.CustomBeanUtil;
import zkz.bangong.layui.crmLayuiAnnoun;
import zkz.bangong.mapper.crmAnnounMapper;
import zkz.bangong.mapper.crmTaskMapper;
import zkz.bangong.pojo.PageResult;
import zkz.bangong.pojo.crmAnnoun;
import zkz.bangong.service.staffAnnounService;

import java.util.ArrayList;
import java.util.List;
@Service
public class staffAnnounImpl implements staffAnnounService {
    @Autowired
    private crmAnnounMapper crmAnnounMapper;
    @Autowired
    private crmTaskMapper crmTaskMapper;
/*根据公告状态查找公告列表*/
    @Override
    public PageResult<crmLayuiAnnoun> getAnnounByStatus(String value, Integer crmUserId, Integer page, Integer rows) {
        List<crmAnnoun> crmAnnounList=null;
        PageHelper.startPage(page,rows);

        //执行查看公示中的查询
        if("公示中".equals(value)){
            crmAnnounList= crmAnnounMapper.selectMyAnnoun(crmUserId);
        }
        else if("已结束".equals(value)){
            crmAnnounList=crmAnnounMapper.selectMyEndAnnoun(crmUserId);
        }
        PageInfo<crmAnnoun> pageInfo2 = new PageInfo<>(crmAnnounList);


        List<crmLayuiAnnoun> crmLayuiAnnounList=new ArrayList<>(crmAnnounList.size());
        for (int i=0;i<crmAnnounList.size();i++){
            crmAnnoun crmAnnoun=crmAnnounList.get(i);
            //单个渲染
            crmLayuiAnnoun crmLayuiAnnoun=new crmLayuiAnnoun();
            crmLayuiAnnoun.setAnnouncementIdId(crmAnnoun.getAnnouncementIdId());
            crmLayuiAnnoun.setCreateTime(crmAnnoun.getCreateTime());
            crmLayuiAnnoun.setContent(crmAnnoun.getContent());
            crmLayuiAnnoun.setTitle(crmAnnoun.getTitle());
            //渲染名字
            crmLayuiAnnoun.setUsername(crmTaskMapper.selectCrmNameById(crmAnnounList.get(i).getCreateUserId()));
            //添加进去返回列表
            crmLayuiAnnounList.add(crmLayuiAnnoun);
        }

              //渲染
            System.out.println(crmAnnounList.size()+"总的返回的长度");
            // 包装成pageInfo
            PageInfo<crmLayuiAnnoun> pageInfo = new PageInfo<>(crmLayuiAnnounList);
          System.out.println(pageInfo2.getPages()+"总页数");

        // 包装成分页结果集返回
            return new PageResult<>(pageInfo2.getTotal(),pageInfo2.getPages(),pageInfo.getList(),page,rows);


    }

    /*添加公告一条*/
    @Override
    public void addAnnoun(crmAnnoun crmAnnoun) {
        crmAnnounMapper.insert(crmAnnoun);
    }
}
