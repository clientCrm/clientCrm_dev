package zkz.kehu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zkz.kehu.comment.ConstantTip;
import zkz.kehu.pojo.CrmUser;
import zkz.kehu.service.LoginService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RequestMapping("/loginCtrl")
public class LoginController{

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request, HttpServletResponse response){
        /*System.out.println(username+":"+password);
        if ((username == null || "".equals(username))||(password == null || "".equals(password))){
            return ConstantTip.DEFEAT_CODE_RETURN;
        }else{
            CrmUser crmUser = loginService.checkLogin(username, password);
            System.out.println(crmUser);
            if (crmUser != null){
                Cookie cookie = new Cookie("ACCOUNT_IN_COOKIE", crmUser.getUsername());
                cookie.setMaxAge(60*60*30);
                response.addCookie(cookie);
                HttpSession session = request.getSession();
                session.setAttribute("ACCOUNT_IN_SESSION", crmUser);
                return ConstantTip.SUCCESS_CODE_RETURN;
            }
            return ConstantTip.Login_ERROR_CODE_RETURN;
            }*/
        return "http://www.crmtest.com/toIndex";

    }
}
