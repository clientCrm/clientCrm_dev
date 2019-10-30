package zkz.bangong.service;

import zkz.bangong.layui.crmTaskLayui;
import zkz.bangong.pojo.PageResult;
import zkz.bangong.pojo.crmTask;


public interface crmTaskService {
    //*员工新增一个任务*//*
    void addCrmTask(crmTaskLayui crmTaskLayui);
    //*根据任务名模糊查找符合要求的任务表列表*//*
   PageResult<crmTask> selectByName(String selectType, Integer crmUserId, String value, Integer page, Integer rows);
        //*根据任务类型查找符合要求的任务表列表*/*
    PageResult<crmTask> selectByStatus(String selectType, Integer crmUserId, String value, Integer page, Integer rows);
//*根据任务表的优先级查找符合要求的任务表列表*//*
    PageResult<crmTask> selectByLevel(String selectType, Integer crmUserId, String value, Integer page, Integer rows);
//*根据截止时间类型*//*
    PageResult<crmTask> selectByTimeType(String selectType, Integer crmUserId, String value, Integer page, Integer rows);
//*根据任务负责人查找该负责人负责的全部任务*//*
    PageResult<crmTask> selectByUserName(String selectType, Integer crmUserId, String value, Integer page, Integer rows);
/*根据任务类型查找任务列表*/
    PageResult<crmTask> selectMyResTask(String selectType, Integer crmUserId, String value, Integer page, Integer rows);
        /*根据任务表Id查找任务详情*/
    crmTaskLayui selectTaskInfoById(Integer taskId);
}
