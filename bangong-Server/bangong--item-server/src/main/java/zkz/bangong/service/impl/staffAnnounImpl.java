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
import zkz.bangong.pojo.crmTask;
import zkz.bangong.service.staffAnnounService;

import java.util.Date;
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
        List<crmLayuiAnnoun> crmLayuiAnnounList=null;
        //执行查看公示中的查询
        if("公示中".equals(value)){
            PageHelper.startPage(page,rows);
            crmAnnounList= crmAnnounMapper.selectMyAnnoun(crmUserId);
        }
        else if("已结束".equals(value)){
            PageHelper.startPage(page,rows);
            crmAnnounList=crmAnnounMapper.selectMyEndAnnoun(crmUserId);
        }
        for (int i=0;i<crmAnnounList.size();i++){
            //单个渲染
            crmLayuiAnnoun crmLayuiAnnoun=render(crmAnnounList.get(i));
            //渲染名字
            crmLayuiAnnoun.setUsername(crmTaskMapper.selectCrmNameById(crmAnnounList.get(i).getCreateUserId()));
            //添加进去返回列表
            crmLayuiAnnounList.add(crmLayuiAnnoun);
        }

         //渲染


        System.out.println(crmLayuiAnnounList.size());
            // 包装成pageInfo
            PageInfo<crmLayuiAnnoun> pageInfo = new PageInfo<>(crmLayuiAnnounList);
            // 包装成分页结果集返回
            return new PageResult<>(pageInfo.getTotal(),pageInfo.getPages(),pageInfo.getList(),page,rows);



    }
/*渲染公告列表*/
    private crmLayuiAnnoun render(crmAnnoun crmAnnoun) {
        crmLayuiAnnoun crmLayuiAnnoun=new crmLayuiAnnoun();
        CustomBeanUtil.copyProperties(crmAnnoun,crmLayuiAnnoun,true);
        return crmLayuiAnnoun;
    }

    /*添加公告一条*/
    @Override
    public void addAnnoun(crmAnnoun crmAnnoun) {
        crmAnnounMapper.insert(crmAnnoun);
    }
}
