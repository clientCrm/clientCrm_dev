package zkz.bangong.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import zkz.bangong.common.CustomBeanUtil;
import zkz.bangong.common.ExamineType;
import zkz.bangong.layui.examineAllLayui;
import zkz.bangong.mapper.*;
import zkz.bangong.pojo.*;
import zkz.bangong.service.examineService;


import java.util.Date;

@Service
public class examineImpl implements examineService {
//    @Autowired
//    private puTongExamineMapper puTongMapper;
//    @Autowired
//    private crmTaskMapper crmTaskMapper;
//    @Autowired
//    private qingJiaExamineMapper qingJiaMapper;
//    @Autowired
//    private chuChaiExamineMapper chuChaiMapper;
//    @Autowired
//    private chaiLvExamineMapper chaiLvMapper;
//    @Autowired
//    private jiaBanExamineMapper jiaBanMapper;
//    /*新增一条审批*/
//    @Override
//    public void addExamine(examineAllLayui examineAllLayui) {
//        //判断审批类型，选择要插入的表
//            ExamineType examineType=ExamineType.getByStatusName(examineAllLayui.getExamineType());
//            Integer type=examineType.getNum();
//        //插入的数据封装
//        if("普通审批".equals(examineAllLayui.getExamineType())){
//            addPutong(examineAllLayui,type);
//        }
//       else if("请假审批".equals(examineAllLayui.getExamineType())){
//            addQingJia(examineAllLayui,type);
//        }
//        else if("出差审批".equals(examineAllLayui.getExamineType())){
//            addChuChaiExamine(examineAllLayui,type);
//        }
//        else if("差旅审批".equals(examineAllLayui.getExamineType())){
//            addChaiLvExamine(examineAllLayui,type);
//        }
//        else if("加班审批".equals(examineAllLayui.getExamineType())){
//            addJiaBanExamine(examineAllLayui,type);
//        }
//
//
//
//
//    }
///*插入加班审批*/
//    private void addJiaBanExamine(examineAllLayui examineAllLayui, Integer type) {
//        jiaBanExamine jiaBanExamine=new jiaBanExamine();
//        CustomBeanUtil.copyProperties(examineAllLayui, jiaBanExamine,true);
//        //渲染其他属性
//        jiaBanExamine.setExamineType(type);
//        jiaBanExamine.setExamineUserId(crmTaskMapper.selectIdByName(examineAllLayui.getExaminerName()));
//        jiaBanExamine.setImgAddr(null);
//        jiaBanExamine.setBatchId(null);
//        jiaBanExamine.setUpdateTime(null);
//        jiaBanExamine.setCreateTime(new Date());
//
//        //执行插入
//        jiaBanMapper.insert(jiaBanExamine);
//    }
//
//    /*插入差旅审批*/
//    private void addChaiLvExamine(examineAllLayui examineAllLayui, Integer type) {
//        chaiLvExamine chaiLvexamine=new chaiLvExamine();
//        //渲染相同的属性
//        CustomBeanUtil.copyProperties(examineAllLayui,chaiLvexamine,true);
//        //渲染其余属性
//        chaiLvexamine.setBatchId(null);
//        chaiLvexamine.setCreateTime(new Date());
//        chaiLvexamine.setExamineType(type);
//        chaiLvexamine.setExamineUserId(crmTaskMapper.selectIdByName(examineAllLayui.getExaminerName()));
//        chaiLvexamine.setImgAddr(null);
//        chaiLvexamine.setUpdateTime(null);
//        //执行插入
//        chaiLvMapper.insert(chaiLvexamine);
//
//    }
//
//    /*插入出差审批*/
//    private void addChuChaiExamine(examineAllLayui examineAllLayui, Integer type) {
//        chuChaiExamine chuchaiExamine=new chuChaiExamine();
//        //渲染同名同类型属性
//        CustomBeanUtil.copyProperties(examineAllLayui,chuchaiExamine,true);
//        //渲染其余属性
//        chuchaiExamine.setBatchId(null);
//        chuchaiExamine.setCreateTime(new Date());
//        chuchaiExamine.setImgAddr(null);
//        chuchaiExamine.setUpdateTime(null);
//        chuchaiExamine.setVehicle(examineAllLayui.getVehicle());
//        chuchaiExamine.setExamineType(type);
//        chuchaiExamine.setExaminerUserId(crmTaskMapper.selectIdByName(examineAllLayui.getExaminerName()));
//        //执行插入
//        chuChaiMapper.insert(chuchaiExamine);
//
//    }
//
//
//    /*插入请假审批*/
//    private void addQingJia(examineAllLayui examineAllLayui, Integer type) {
//        qingJiaExamine examine=new qingJiaExamine();
//        CustomBeanUtil.copyProperties(examineAllLayui,examine,true);
//        //文件,图片上传暂无
//        //渲染其余属性
//        examine.setCreateTime(new Date());
//        examine.setBatchId(null);
//        examine.setExaminerUserId(crmTaskMapper.selectIdByName(examineAllLayui.getExaminerName()));
//        examine.setImgsAddr(null);
//        ExamineType examineType=ExamineType.getByStatusName(examineAllLayui.getExamineType());
//        examine.setQingjiaType(examineType.getNum());
//        examine.setUpdateTime(null);
//        examine.setQingjiaType(type);
//        //执行插入
//        qingJiaMapper.insert(examine);
//
//    }
//
//    /*插入普通审批*/
//    public void addPutong(examineAllLayui examineAllLayui,Integer type){
//        puTongExamine puTongExamine=new puTongExamine();
//        MultipartFile batch = examineAllLayui.getBatch();
//        //文件,图片上传暂无
//        puTongExamine.setImgAddr("C:\\images\\pfbn0u7hoq5.jpg");
//        puTongExamine.setBatchId(null);
//        //其余属性封装
//        puTongExamine.setContext(examineAllLayui.getContent());
//        puTongExamine.setExamineUserId(crmTaskMapper.selectIdByName(examineAllLayui.getExaminerName()));
//        puTongExamine.setCreateTime(new Date());
//        puTongExamine.setExamineType(type);
//        puTongExamine.setRemarks(examineAllLayui.getRemarks());
//        puTongExamine.setUpdateTime(null);
//        ExamineType examineType=ExamineType.getByStatusName(examineAllLayui.getExamineType());
//        puTongExamine.setExamineType(examineType.getNum());
//
//        puTongMapper.insert(puTongExamine);
//    }
}
