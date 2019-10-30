package zkz.kehu.controller;

import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import zkz.kehu.service.BusinessService;
import zkz.kehu.vo.BusinessVo;

@RestController
public class BusinessController {
    @Autowired
    private BusinessService businessService;

    @GetMapping("/business")
    public PageInfo<BusinessVo> queryBusiness(Integer pageNum, Integer pageSize){
        System.out.println(pageNum+":"+pageSize);
        PageInfo<BusinessVo> businessVoPageInfo = businessService.queryBusiness(pageNum, pageSize);
        return businessVoPageInfo;
    }
}
