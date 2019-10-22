package zkz.kehu.common.api;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import zkz.kehu.common.pojo.Customer;
import zkz.kehu.common.vo.CustomerVo;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequestMapping("customerController")
public interface CustomerApi {

    @GetMapping("/customer")
    PageInfo<CustomerVo> queryAllCustomers(Integer pageNum, Integer pageSize);

    @GetMapping("/customer/vagueQuery/{nameOrNumb}")
    PageInfo<CustomerVo> queryCustomerByCase(@PathVariable("nameOrNumb") String nameOrNumb, Integer pageNum, Integer pageSize);

    @GetMapping("/customer/myCharge/{charge_user_id}")
    PageInfo<CustomerVo> inChargeOfCustomers(@PathVariable("charge_user_id") int charge_user_id, Integer pageNum, Integer pageSize);

    //点击全部客户
    @GetMapping("/customer/all")
    String clickAllCustomer();

    //点击我参与的客户
    @GetMapping("/customer/participate/{charge_user_id}")
    PageInfo<CustomerVo> iParticipate(@PathVariable("charge_user_id") int charge_user_id, Integer pageNum, Integer pageSize);

    //新建客户点击保存
    @PostMapping("/customer")
    int insertCustomer(Customer customer);

    //新建用户点击保存并新建联系人,插入并跳转到新建联系人页面
    @PostMapping("/customer/toAddContactPage")
    int insertCustomerAndToAddContactPage(Customer customer, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
