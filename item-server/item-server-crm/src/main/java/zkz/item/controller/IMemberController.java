package zkz.item.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import zkz.item.pojo.IMember;
import zkz.item.service.IMemberService;
import zkz.item.util.Base;

@RestController
public class IMemberController {
    @Autowired
    private IMemberService iMenberService;

    @PostMapping("iMember")
    public Base addMember(@RequestBody IMember iMember) {
        System.out.println("IMemberController.addItem="+iMember);
        return iMenberService.addMember(iMember);
    }
}
