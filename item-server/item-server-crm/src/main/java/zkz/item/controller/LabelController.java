package zkz.item.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import zkz.item.pojo.Label;
import zkz.item.pojo.PageResult;
import zkz.item.pojo.Test;
import zkz.item.service.LabelService;

import java.util.ArrayList;
import java.util.List;

@RestController
//@Controller
public class LabelController {
    @Autowired
    private LabelService labelService;

    @GetMapping("label/test")
    String test(@RequestParam("thisPage") String thisPage, @RequestParam("limit") String limit){
        return thisPage;
    }

    @GetMapping("label/getTotal")
    int getTotal(){
        System.out.println("lll");
        return labelService.getTotal();
    }

    @GetMapping("label/{thisPage}/{limit}")
    List<Label> getByThisPage(@PathVariable Integer thisPage,@PathVariable Integer limit){
           //        System.out.println(page instanceof Integer+"  "+page instanceof String);
        return labelService.getByThisPage(thisPage, limit);
    }

    @GetMapping("label/getByPaging/{thisPage}/{limit}")
    PageResult getByPaging(@PathVariable Integer thisPage, @PathVariable Integer limit){
        return labelService.getByPaging(thisPage,limit);
    }

    @GetMapping("label/getByPaging")
    PageResult getByPagingCopy(@RequestParam("thisPage") String thisPage, @RequestParam("limit") String limit){
        System.out.println(thisPage+"   0   "+limit);
        return labelService.getByPaging(Integer.parseInt(thisPage),Integer.parseInt(limit));
    }

}
