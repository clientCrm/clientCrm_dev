package zkz.bangong.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import zkz.bangong.common.CustomBeanUtil;
import zkz.bangong.layui.crmTaskLayuiComment;
import zkz.bangong.mapper.crmTaskCommentMapper;
import zkz.bangong.mapper.crmTaskMapper;
import zkz.bangong.pojo.PageResult;
import zkz.bangong.pojo.crmTask;
import zkz.bangong.pojo.crmTaskComment;
import zkz.bangong.pojo.crmTaskCommentExample;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("taskComment")
public class staffTaskCommentController {
            @Autowired
    private crmTaskCommentMapper taskCommentMapper;
@Autowired
private crmTaskMapper crmTaskMapper;
    @PostMapping("addComment")
    public ResponseEntity<Void> addTaskComment(
            @RequestParam("commentType") String commentType,
           @RequestBody crmTaskComment crmTaskComent ){

         /**
          * @author : zkz
            * @param crmTaskComentLayui
          * 包括:
          *
          * @return : org.springframework.http.ResponseEntity<java.lang.Void>
          * @date : 2019/10/22 20:29
          * @descript :
          * 添加一条评论:(包括任务评论跟日志评论)
          * 前端传递的 参数：
          *
          * 评论人id
          * 评论内容
          * 评论任务ID 或评论其他模块ID
          * 回复评论ID,为空就是初始评论
          * 回复对象的id 为空就是初始评论
          *commentType:评论的类型
          *
          * 所有的参数:
          * :
          * 评论表id
          * 评论人id
          * 评论内容
          * 评论任务ID 或评论其他模块ID
          * 回复评论ID,为空就是初始评论
          * 回复对象的id 为空就是初始评论
          * 状态  1可见 2删除
          *评论时间
          *点赞数
          * 评论分类 1：任务评论  2：日志评论
         */
         if(crmTaskComent==null){
             return ResponseEntity.notFound().build();
         }
         if("任务评论".equals(commentType)){
             crmTaskComent.setCommentType(1);
         }
         else{
             crmTaskComent.setCommentType(2);
         }

         //渲染其余属性
         crmTaskComent.setCreateTime(new Date());
         crmTaskComent.setStatus(1);
         crmTaskComent.setFavour(0);
        taskCommentMapper.insert(crmTaskComent);

         return ResponseEntity.ok().build();
    }
/*ResponseEntity<PageResult<crmTask>>*/
    @GetMapping("getCommentsByTaskId")
    public ResponseEntity<PageResult<crmTaskLayuiComment>> getCommentsByTaskId(
            @RequestParam("taskId") Integer taskId,
            @RequestParam("page") Integer page,
            @RequestParam("rows") Integer rows
    ){

         /**
          * @author : zkz
            * @param taskId
         * @param page
         * @param rows
          * @return : org.springframework.http.ResponseEntity<zkz.bangong.pojo.PageResult<zkz.bangong.layui.crmTaskLayuiComment>>
          * @date : 2019/10/22 22:36
          * @descript :根据任务id查找任务评论
         */

        crmTaskCommentExample taskCommentExample=new crmTaskCommentExample();
        crmTaskCommentExample.Criteria criteria = taskCommentExample.createCriteria();
        criteria.andTypeIdEqualTo(taskId);
        taskCommentExample.setOrderByClause("create_time desc");
        //根据评论表的评论任务Id查找出所有的评论
        List<crmTaskComment> crmTaskComments = taskCommentMapper.selectByExample(taskCommentExample);
        if(CollectionUtils.isEmpty(crmTaskComments)){
            return ResponseEntity.notFound().build();
        }
        List<crmTaskLayuiComment> crmTaskLayuiComments=new ArrayList<>(crmTaskComments.size());
        //渲染
            for (crmTaskComment taskComment:crmTaskComments){
                crmTaskLayuiComments.add(renderLyuiCom(taskComment));
            }
    //测试
        for (crmTaskLayuiComment comment:crmTaskLayuiComments){
            System.out.println(comment.toString()+"layuiComment测试\n");
        }
        // 添加分页条件
        PageHelper.startPage(page, rows);
        // 包装成pageInfo
        PageInfo<crmTaskLayuiComment> pageInfo = new PageInfo<>(crmTaskLayuiComments);
        // 包装成分页结果集返回
        PageResult<crmTaskLayuiComment>  result=   new PageResult<>(pageInfo.getTotal(), pageInfo.getList());
        return ResponseEntity.ok(result);
    }

    private crmTaskLayuiComment renderLyuiCom(crmTaskComment taskComment) {
        crmTaskLayuiComment crmTaskLayuiComment=new crmTaskLayuiComment();
        CustomBeanUtil.copyProperties(taskComment,crmTaskLayuiComment,true);
        //渲染其他属性
        String userName=crmTaskMapper.selectCrmNameById (taskComment.getUserId());
        String pName =crmTaskMapper.selectCrmNameById(taskComment.getPid());
        crmTaskLayuiComment.setUserName(userName);
        crmTaskLayuiComment.setpName(pName);
        return crmTaskLayuiComment;
    }


}
