package zkz.bangong.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zkz.bangong.common.*;
import zkz.bangong.layui.crmTaskLayui;
import zkz.bangong.mapper.crmTaskMapper;
import zkz.bangong.pojo.PageResult;
import zkz.bangong.pojo.crmTask;
import zkz.bangong.pojo.crmTaskExample;
import zkz.bangong.pojo.crmUser;
import zkz.bangong.service.crmTaskService;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class crmTaskImpl implements crmTaskService{

    @Autowired
    private zkz.bangong.mapper.crmTaskMapper crmTaskMapper;


    //员工新增一个任务
    @Override
    public void addCrmTask(crmTaskLayui crmTaskLayui) {
        crmTask crmTask=new crmTask();
      //渲染属性
        CustomBeanUtil.copyProperties(crmTaskLayui,crmTask,true);
        //渲染不一致的属性
        System.out.println(crmTask.toString());

        crmTask.setCreateTime(new Date());
        crmTask.setStatus(1);
        crmTask.setIshidden(0);
        crmTask.setIsOpen(1);
        crmTask.setIsTop(1);
        crmTask.setIsArchive(0);
        crmTaskLevel c= crmTaskLevel.getByStatusName(crmTaskLayui.getPriority());
        crmTask.setPriority(c.getNum());
        //根据员工Id查找他的上级Id
       int pid= crmTaskMapper.selectParentIdByUserId(crmTaskLayui.getCreateUserId());
        crmTask.setPid(pid);
        //根据负责人的名字获取负责人的Id
        crmTask.setMainUserId( crmTaskMapper.selectIdByName(crmTaskLayui.getMainUserId()));

        //执行插入
        crmTaskMapper.insert(crmTask);

    }

    //*根据字段名查找符合要求的所有任务表列表*//*
    @Override
    public PageResult<crmTask> selectByName(String selectType,Integer crmUserId, String value, Integer page, Integer rows) {
        int UserId = -1;
        if("我的任务".equals(selectType)){
            UserId=crmUserId;
        }
        else if("我下属的任务".equals(selectType)){
            UserId=crmTaskMapper.selectLowerIdByPid(crmUserId);
        }
        crmTaskExample crmTaskExample = new crmTaskExample();
        zkz.bangong.pojo.crmTaskExample.Criteria criteria = crmTaskExample.createCriteria();
        criteria.andCreateUserIdEqualTo(UserId).andTaskNameLike("%" + value + "%");
        crmTaskExample.setOrderByClause("task_id desc");
        // 添加分页条件
        PageHelper.startPage(page, rows);
        List<crmTask> crmTasks = crmTaskMapper.selectByExample(crmTaskExample);
        // 包装成pageInfo
        PageInfo<crmTask> pageInfo = new PageInfo<>(crmTasks);
        // 包装成分页结果集返回
        return new PageResult<>(pageInfo.getTotal(), pageInfo.getList());

    }

    //*根据任务状态查找符合要求的所有任务表列表*//*
    @Override
    public PageResult<crmTask> selectByStatus(String selectType,Integer crmUserId, String value, Integer page, Integer rows) {
        int UserId = -1;
        if("我的任务".equals(selectType)){
            UserId=crmUserId;
        }
        else if("我下属的任务".equals(selectType)){
            UserId=crmTaskMapper.selectLowerIdByPid(crmUserId);
        }
        System.out.println(UserId);

        crmTaskExample crmTaskExample = new crmTaskExample();
        zkz.bangong.pojo.crmTaskExample.Criteria criteria = crmTaskExample.createCriteria();

        List<crmTask> crmTasks = new ArrayList<>();
        // 添加分页条件
        PageHelper.startPage(page, rows);

        if ("全部".equals(value)) {
            crmTasks = crmTaskMapper.selectByStatusAll(UserId);
            System.out.println(crmTasks.size());
        } else {
            crmTaskStatus crm = crmTaskStatus.getByStatusName(value);
            criteria.andCreateUserIdEqualTo(UserId).andStatusEqualTo(crm.getNum());
            //设置排序
            crmTaskExample.setOrderByClause("task_id desc");
            crmTasks = crmTaskMapper.selectByExample(crmTaskExample);
        }
        // 包装成pageInfo
        PageInfo<crmTask> pageInfo = new PageInfo<>(crmTasks);
        // 包装成分页结果集返回
        return new PageResult<>(pageInfo.getTotal(), pageInfo.getList());

    }

    //*根据任务表的优先级查找符合要求的任务表列表*//*
    @Override
    public PageResult<crmTask> selectByLevel(String selectType,Integer crmUserId, String value, Integer page, Integer rows) {
        int UserId = -1;
        if("我的任务".equals(selectType)){
            UserId=crmUserId;
        }
        else if("我下属的任务".equals(selectType)){
            UserId=crmTaskMapper.selectLowerIdByPid(crmUserId);
        }
        crmTaskExample crmTaskExample = new crmTaskExample();
        zkz.bangong.pojo.crmTaskExample.Criteria criteria = crmTaskExample.createCriteria();
        List<crmTask> crmTasks = new ArrayList<>();
        // 添加分页条件
        PageHelper.startPage(page, rows);


        if ("全部".equals(value)) {
            crmTasks = crmTaskMapper.selectByLevelAll(UserId);
        } else {
            crmTaskLevel crm = crmTaskLevel.getByStatusName(value);
            criteria.andCreateUserIdEqualTo(UserId).andStatusEqualTo(crm.getNum());
            crmTaskExample.setOrderByClause("task_id desc");
            crmTasks = crmTaskMapper.selectByExample(crmTaskExample);
        }
        // 包装成pageInfo
        PageInfo<crmTask> pageInfo = new PageInfo<>(crmTasks);
        // 包装成分页结果集返回
        return new PageResult<>(pageInfo.getTotal(), pageInfo.getList());

    }

    //*根据截止时间类型查找*//*
    @Override
    public PageResult<crmTask> selectByTimeType(String selectType,Integer crmUserId, String value, Integer page, Integer rows) {
        int UserId = -1;
        if("我的任务".equals(selectType)){
            UserId=crmUserId;
        }
        else if("我下属的任务".equals(selectType)){
            UserId=crmTaskMapper.selectLowerIdByPid(crmUserId);
        }

        crmTaskExample crmTaskExample = new crmTaskExample();
        zkz.bangong.pojo.crmTaskExample.Criteria criteria = crmTaskExample.createCriteria();
        List<crmTask> crmTasks = new ArrayList<>();
        // 添加分页条件
        PageHelper.startPage(page, rows);
        //先查询所有的日期的年月,第一个参数是日期，第二个参数是任务表Id
        List<Map<Object,Object>> selectMonAndDays = crmTaskMapper.selectMonAndDay(UserId);
        //获取当前时间的月份和日期
        Date date = new Date();

        //先获取表中的结束时间字段

            for (Map s : selectMonAndDays) {
                //根据分别key获取value（日期跟Id值）
                String stop_time = s.get("stopTime").toString();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                ParsePosition pos = new ParsePosition(0);
                Date date1 = formatter.parse(stop_time, pos);

                Integer task_id = Integer.parseInt(s.get("taskId").toString());

                //遍历所有截止日期大于当前日期的任务

                System.out.println(date1.getTime()-date.getTime());
                if ("全部".equals(value)) {
                if(date1.getTime()-date.getTime()>0){
                   crmTask crmTask=crmTaskMapper.selectByPrimaryKey(task_id);
                            crmTasks.add(crmTask);
                }

            }
            //截止时间为其他的时候
            else{
                    crmTaskEndTime crm= crmTaskEndTime.getByStatusName(value);
                    System.out.println("离截止的天数..:"+(date1.getTime()-date.getTime()+1000000)/(60*60*24*1000)+"\n");
                  if((date1.getTime()-date.getTime()+1000000)/(60*60*24*1000)>=crm.getNum()){
                      crmTask crmTask=crmTaskMapper.selectByPrimaryKey(task_id);
                      crmTasks.add(crmTask);
                        }
                }
        }


        // 包装成pageInfo
        PageInfo<crmTask> pageInfo = new PageInfo<>(crmTasks);
        // 包装成分页结果集返回
        return new PageResult<>(pageInfo.getTotal(), pageInfo.getList());
    }
        //*根据任务负责人查找该负责人负责的全部任务*//*
    @Override
    public PageResult<crmTask> selectByUserName(String selectType, Integer crmUserId, String value, Integer page, Integer rows) {
        int UserId = -1;
        if("我的任务".equals(selectType)){
            UserId=crmUserId;
        }
        else if("我下属的任务".equals(selectType)){
            UserId=crmTaskMapper.selectLowerIdByPid(crmUserId);
        }

        //*根据员工姓名查找Id*//*
        crmTaskExample crmTaskExample = new crmTaskExample();
        zkz.bangong.pojo.crmTaskExample.Criteria criteria = crmTaskExample.createCriteria();
        criteria.andCreateUserIdEqualTo(UserId).andTaskNameLike("%" + value + "%");
        crmTaskExample.setOrderByClause("task_id desc");
        // 添加分页条件
        PageHelper.startPage(page, rows);
        List<crmTask> crmTasks = crmTaskMapper.selectByExample(crmTaskExample);
        // 包装成pageInfo
        PageInfo<crmTask> pageInfo = new PageInfo<>(crmTasks);
        // 包装成分页结果集返回
        return new PageResult<>(pageInfo.getTotal(), pageInfo.getList());

    }
//*根据任务类型查找任务列表*//*
    @Override
    public PageResult<crmTask> selectMyResTask(String selectType,Integer crmUserId, String value,Integer page, Integer rows) {
        int UserId = -1;
        if("我的任务".equals(selectType)){
            UserId=crmUserId;
        }
        else if("我下属的任务".equals(selectType)){
            UserId=crmTaskMapper.selectLowerIdByPid(crmUserId);
        }

        crmTaskExample crmTaskExample = new crmTaskExample();
        zkz.bangong.pojo.crmTaskExample.Criteria criteria = crmTaskExample.createCriteria();
        if("全部".equals(value)){
            //查找全部
            List<crmTask> crmTasks = crmTaskMapper.selectAll(UserId);
        }
        else if("我负责的".equals(value)){
            criteria.andMainUserIdEqualTo(UserId);
        }
        else if("我创建的".equals(value)){
            criteria.andCreateUserIdEqualTo(UserId);
        }
        crmTaskExample.setOrderByClause("task_id desc");
        // 添加分页条件
        PageHelper.startPage(page, rows);
        List<crmTask> crmTasks = crmTaskMapper.selectByExample(crmTaskExample);
        // 包装成pageInfo
        PageInfo<crmTask> pageInfo = new PageInfo<>(crmTasks);
        // 包装成分页结果集返回
        return new PageResult<>(pageInfo.getTotal(), pageInfo.getList());

    }
/*根据任务ID查找任务详情*/
    @Override
    public crmTaskLayui selectTaskInfoById(Integer taskId) {

        crmTask crmTask=crmTaskMapper.selectByPrimaryKey(taskId);
       // System.out.println(crmTask.toString()+"...");
        crmTaskLayui crmTaskLayui=new crmTaskLayui();
        CustomBeanUtil.copyProperties(crmTask,crmTaskLayui,true);
       // System.out.println(crmTaskLayui.toString());
          //渲染其他属性
        String mainUserName=crmTaskMapper.selectCrmNameById(crmTask.getMainUserId());
        String ownerUserName=crmTaskMapper.selectCrmNameById(crmTask.getOwnerUserId());
        crmTaskLevel TaskLevel= crmTaskLevel.getByNum(crmTask.getPriority());
        String priority=TaskLevel.getStatusName();

            crmTaskLayui.setMainUserId(mainUserName);
            crmTaskLayui.setOwnerUserId(ownerUserName);
            crmTaskLayui.setPriority(priority);
            //返回
        return crmTaskLayui;

    }




}





