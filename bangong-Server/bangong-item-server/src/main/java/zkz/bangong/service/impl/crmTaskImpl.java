package zkz.bangong.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
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
    private crmTaskMapper crmTaskMapper;


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
        crmUser crmUser=crmTaskMapper.selectIdByName(crmTaskLayui.getMainUserId());
        crmTask.setMainUserId(crmUser.getUserId());

        //执行插入
        crmTaskMapper.insert(crmTask);

    }

    /*根据字段名查找符合要求的所有任务表列表*/
    @Override
    public PageResult<crmTask> selectByName(Integer crmUserId, String value, Integer page, Integer rows) {
        crmTaskExample crmTaskExample = new crmTaskExample();
        zkz.bangong.pojo.crmTaskExample.Criteria criteria = crmTaskExample.createCriteria();
        criteria.andCreateUserIdEqualTo(crmUserId).andTaskNameLike("%" + value + "%");
        crmTaskExample.setOrderByClause("task_id desc");
        // 添加分页条件
        PageHelper.startPage(page, rows);
        List<crmTask> crmTasks = crmTaskMapper.selectByExample(crmTaskExample);
        // 包装成pageInfo
        PageInfo<crmTask> pageInfo = new PageInfo<>(crmTasks);
        // 包装成分页结果集返回
        return new PageResult<>(pageInfo.getTotal(), pageInfo.getList());

    }

    /*根据任务状态查找符合要求的所有任务表列表*/
    @Override
    public PageResult<crmTask> selectByStatus(Integer crmUserId, String value, Integer page, Integer rows) {
        crmTaskExample crmTaskExample = new crmTaskExample();
        zkz.bangong.pojo.crmTaskExample.Criteria criteria = crmTaskExample.createCriteria();

        List<crmTask> crmTasks = new ArrayList<>();
        // 添加分页条件
        PageHelper.startPage(page, rows);

        if ("全部".equals(value)) {
            crmTasks = crmTaskMapper.selectByStatusAll(crmUserId);
        } else {
            crmTaskStatus crm = crmTaskStatus.getByStatusName(value);
            criteria.andCreateUserIdEqualTo(crmUserId).andStatusEqualTo(crm.getNum());
            //设置排序
            crmTaskExample.setOrderByClause("task_id desc");
            crmTasks = crmTaskMapper.selectByExample(crmTaskExample);
        }
        // 包装成pageInfo
        PageInfo<crmTask> pageInfo = new PageInfo<>(crmTasks);
        // 包装成分页结果集返回
        return new PageResult<>(pageInfo.getTotal(), pageInfo.getList());

    }

    /*根据任务表的优先级查找符合要求的任务表列表*/
    @Override
    public PageResult<crmTask> selectByLevel(Integer crmUserId, String value, Integer page, Integer rows) {
        crmTaskExample crmTaskExample = new crmTaskExample();
        zkz.bangong.pojo.crmTaskExample.Criteria criteria = crmTaskExample.createCriteria();
        List<crmTask> crmTasks = new ArrayList<>();
        // 添加分页条件
        PageHelper.startPage(page, rows);


        if ("全部".equals(value)) {
            crmTasks = crmTaskMapper.selectByLevelAll(crmUserId);
        } else {
            crmTaskLevel crm = crmTaskLevel.getByStatusName(value);
            criteria.andCreateUserIdEqualTo(crmUserId).andStatusEqualTo(crm.getNum());
            crmTaskExample.setOrderByClause("task_id desc");
            crmTasks = crmTaskMapper.selectByExample(crmTaskExample);
        }
        // 包装成pageInfo
        PageInfo<crmTask> pageInfo = new PageInfo<>(crmTasks);
        // 包装成分页结果集返回
        return new PageResult<>(pageInfo.getTotal(), pageInfo.getList());

    }

    /*根据截止时间类型查找*/
    @Override
    public PageResult<crmTask> selectByTimeType(Integer crmUserId, String value, Integer page, Integer rows) {
        crmTaskExample crmTaskExample = new crmTaskExample();
        zkz.bangong.pojo.crmTaskExample.Criteria criteria = crmTaskExample.createCriteria();
        List<crmTask> crmTasks = new ArrayList<>();
        // 添加分页条件
        PageHelper.startPage(page, rows);
        //先查询所有的日期的年月,第一个参数是日期，第二个参数是任务表Id
        List<Map<Object,Object>> selectMonAndDays = crmTaskMapper.selectMonAndDay(crmUserId);
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
        /*根据任务负责人查找该负责人负责的全部任务*/
    @Override
    public PageResult<crmTask> selectByUserName(Integer crmUserId, String value, Integer page, Integer rows) {

        /*根据员工姓名查找Id*/
        crmUser crmUser=crmTaskMapper.selectIdByName(value);
        crmTaskExample crmTaskExample = new crmTaskExample();
        zkz.bangong.pojo.crmTaskExample.Criteria criteria = crmTaskExample.createCriteria();
        criteria.andCreateUserIdEqualTo(crmUserId).andTaskNameLike("%" + value + "%");
        crmTaskExample.setOrderByClause("task_id desc");
        // 添加分页条件
        PageHelper.startPage(page, rows);
        List<crmTask> crmTasks = crmTaskMapper.selectByExample(crmTaskExample);
        // 包装成pageInfo
        PageInfo<crmTask> pageInfo = new PageInfo<>(crmTasks);
        // 包装成分页结果集返回
        return new PageResult<>(pageInfo.getTotal(), pageInfo.getList());

    }
/*根据任务类型查找任务列表*/
    @Override
    public PageResult<crmTask> selectMyResTask(Integer crmUserId, String value,Integer page, Integer rows) {

        crmTaskExample crmTaskExample = new crmTaskExample();
        zkz.bangong.pojo.crmTaskExample.Criteria criteria = crmTaskExample.createCriteria();
        if("全部".equals(value)){
            //查找全部
            List<crmTask> crmTasks = crmTaskMapper.selectAll(crmUserId);
        }
        else if("我负责的".equals(value)){
            criteria.andMainUserIdEqualTo(crmUserId);
        }
        else if("我创建的".equals(value)){
            criteria.andCreateUserIdEqualTo(crmUserId);
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
}





