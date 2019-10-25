package zkz.bangong.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zkz.bangong.layui.examineAllLayui;
import zkz.bangong.service.examineService;

@RestController
@RequestMapping("examine")
public class examienController {
    @Autowired
    private zkz.bangong.service.examineService examineService;

    @GetMapping("addExamine")
    public ResponseEntity<Void> addExamine (@RequestBody examineAllLayui examineAllLayui){
        if(examineAllLayui==null){
            return ResponseEntity.badRequest().build();
        }
        examineService.addExamine(examineAllLayui);
        return ResponseEntity.ok().build();
    }






}
