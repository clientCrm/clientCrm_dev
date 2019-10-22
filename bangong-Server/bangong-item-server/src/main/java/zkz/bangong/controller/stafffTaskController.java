package zkz.bangong.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import zkz.bangong.common.crmTaskMonAndDay;
import zkz.bangong.layui.crmTaskLayui;
import zkz.bangong.mapper.crmTaskMapper;
import zkz.bangong.pojo.Brand;
import zkz.bangong.pojo.PageResult;
import zkz.bangong.pojo.crmTask;
import zkz.bangong.service.crmTaskService;

@RestController
@RequestMapping("crmTask")
public class stafffTaskController {

    @Autowired
    private crmTaskService crmTaskServer;
@Autowired
private crmTaskMapper crmTaskMapper;

    @PostMapping("addTask")
    public ResponseEntity<Void> createTask( @RequestBody  crmTaskLayui crmTaskLayui){
        System.out.println("进来");
        System.out.println(crmTaskLayui.toString()+"...");
         //判断传递过来的是否为空
        if(crmTaskLayui==null){
            return ResponseEntity.badRequest().build();
        }
        crmTaskServer.addCrmTask(crmTaskLayui);
        return ResponseEntity.ok().build();
    }
@GetMapping("selectByName")
    public ResponseEntity<PageResult<crmTask>> selectByName(
            @RequestParam("crmUserId") Integer crmUserId,
            @RequestParam("value") String value,
            @RequestParam(value = "page", defaultValue = "1")Integer page,
            @RequestParam(value = "rows", defaultValue = "5")Integer rows
){

         /**
          * @author : zkz
            * @param crmUserId	:员工的id
         * @param value	        字段名的值
          * @return : org.springframework.http.ResponseEntity<java.util.List<zkz.bangong.pojo.crmTask>>
          * @date : 2019/10/21 11:56
          * @descript :根据任务表的 任务名称 模糊 查找符合要求的任务
         */
        PageResult<crmTask> result =crmTaskServer.selectByName(crmUserId, value,page,rows);

        if (CollectionUtils.isEmpty(result.getItems())) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("selectByStatus")
    public  ResponseEntity<PageResult<crmTask>>  selectByStatus(
            @RequestParam("crmUserId") Integer crmUserId,
            @RequestParam("value") String value,
            @RequestParam("page") Integer page,
          @RequestParam("rows") Integer rows
    ){


     /**
      * @author : zkz
        * @param crmUserId	:员工id
     * @param value	  字段名的值
     * @param page	 当前页数
     * @param rows	 每页显示数
      * @return : org.springframework.http.ResponseEntity<zkz.bangong.pojo.PageResult<zkz.bangong.pojo.crmTask>>
      * @date : 2019/10/21 16:42
      * @descript :根据任务表的状态属性查找所有符合条件的
     */

        PageResult<crmTask> result = crmTaskServer.selectByStatus(crmUserId, value,page,rows);

        if (CollectionUtils.isEmpty(result.getItems())) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("selectByLevel")
    public ResponseEntity<PageResult<crmTask>> selectByLevel(
            @RequestParam("crmUserId") Integer crmUserId,
            @RequestParam("value") String value,
            @RequestParam("page") Integer page,
            @RequestParam("rows") Integer rows

            ){

        /**
         * @author : zkz
         * @param crmUserId	:员工的id
         * @param value	        字段名的值
         * @return : org.springframework.http.ResponseEntity<java.util.List<zkz.bangong.pojo.crmTask>>
         * @date : 2019/10/21 11:56
         * @descript :根据任务表的 优先级 模糊 查找符合要求的任务
         */
        PageResult<crmTask>  result= crmTaskServer.selectByLevel(crmUserId, value,page,rows);

        if (CollectionUtils.isEmpty(result.getItems())) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("selectByTimeType")
    public ResponseEntity<PageResult<crmTask>> selectByTimeType(
            @RequestParam("crmUserId") Integer crmUserId,
            @RequestParam("value") String value,
            @RequestParam("page") Integer page,
            @RequestParam("rows") Integer rows

    ) {

     /**
      * @author : zkz
        * @param crmUserId
     * @param value
     * @param page
     * @param rows
      * @return : org.springframework.http.ResponseEntity<zkz.bangong.pojo.PageResult<zkz.bangong.pojo.crmTask>>
      * @date : 2019/10/22 8:36
      * @descript :根据截止时间的类型来查找员工任务
     */

        PageResult<crmTask>  result= crmTaskServer.selectByTimeType(crmUserId, value,page,rows);

        if (CollectionUtils.isEmpty(result.getItems())) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);


    }




    @GetMapping("selectByUserName")
    ResponseEntity<PageResult<crmTask>> selectByUserName(
            @RequestParam("crmUserId") Integer crmUserId,
            @RequestParam("value") String value,
            @RequestParam("page") Integer page,
            @RequestParam("rows") Integer rows

    ) {

     /**
      * @author : zkz
        * @param crmUserId
     * @param value
     * @param page
     * @param rows
      * @return : org.springframework.http.ResponseEntity<zkz.bangong.pojo.PageResult<zkz.bangong.pojo.crmTask>>
      * @date : 2019/10/21 22:32
      * @descript :根据任务负责人查找该负责人负责的全部任务
     */

       PageResult<crmTask>  result= crmTaskServer.selectByUserName(crmUserId, value,page,rows);

        if (CollectionUtils.isEmpty(result.getItems())) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);

    }



    @GetMapping("selectMyResTask")
    ResponseEntity<PageResult<crmTask>> selectMyResTask(
            @RequestParam("crmUserId") Integer crmUserId,
            @RequestParam("value") String value,
            @RequestParam("page") Integer page,
            @RequestParam("rows") Integer rows
    ) {

     /**
      * @author : zkz
        * @param crmUserId
     * @param value
     * @param page
     * @param rows
      * @return : org.springframework.http.ResponseEntity<zkz.bangong.pojo.PageResult<zkz.bangong.pojo.crmTask>>
      * @date : 2019/10/21 22:15
      * @descript : 根据任务类型查找我的任务
     */

        PageResult<crmTask>  result= crmTaskServer.selectMyResTask(crmUserId,value,page,rows);

        if (CollectionUtils.isEmpty(result.getItems())) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);

    }

    /*根据我的任务的Id查找任务的详情*/
    @GetMapping("getTaskByTaskId")
        public crmTaskLayui getTaskByTaskId(){

        return null;
    }












}
