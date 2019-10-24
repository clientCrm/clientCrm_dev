package zkz.bangong.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import zkz.bangong.pojo.PageResult;
import zkz.bangong.pojo.crmAnnoun;
import zkz.bangong.service.staffAnnounService;

/*员工公告的后台请求*/
@RequestMapping("Announ")
@RestController
public class staffAnnounController {
    @Autowired
    private staffAnnounService announService;

    @PostMapping("addAnnoun")
    public ResponseEntity<Void> addAnnoun(@RequestBody crmAnnoun crmAnnoun){

        if(crmAnnoun==null){
            return ResponseEntity.badRequest().build();
        }
        announService.addAnnoun(crmAnnoun);
        return ResponseEntity.ok().build();
    }

    @GetMapping("getAnnounByStatus")
    /*根据公告状态查找公告*/
    public ResponseEntity<PageResult<crmAnnoun>> getAnnounByStatus(
            @RequestParam("value") String value,
            @RequestParam("crmUserId") Integer crmUserId,
            @RequestParam("page") Integer page,
            @RequestParam("rows") Integer rows
    ){
     PageResult<crmAnnoun> result=announService.getAnnounByStatus(value,crmUserId,page,rows);

        if (CollectionUtils.isEmpty(result.getItems())) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);

    }








}