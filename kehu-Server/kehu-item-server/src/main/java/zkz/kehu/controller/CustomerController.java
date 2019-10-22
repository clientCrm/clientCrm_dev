package zkz.kehu.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import zkz.kehu.comment.ConstantTip;
import zkz.kehu.pojo.Customer;
import zkz.kehu.vo.CustomerVo;
import zkz.kehu.dto.PageResult;
import zkz.kehu.dto.Result;

import zkz.kehu.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("customerController")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    //点击客户，查询所有客户
    @GetMapping("/customer")
    public PageInfo<CustomerVo> queryAllCustomers(Integer pageNum, Integer pageSize) {
        PageInfo<CustomerVo> customerVoPageInfo = customerService.queryAllCustomers(pageNum, pageSize);
        return customerVoPageInfo;
    }

    //模糊查询（输入客户名称、手机或电话号码进行模糊查询）
    @GetMapping("/customer/vagueQuery/{nameOrNumb}")
    public PageInfo<CustomerVo> queryCustomerByCase(@PathVariable("nameOrNumb") String nameOrNumb, Integer pageNum, Integer pageSize) {
        System.out.println(nameOrNumb);
        PageInfo<CustomerVo> customerVoPageInfo = customerService.queryCustomerByNameOrNumb(nameOrNumb, pageNum, pageSize);
        return customerVoPageInfo;
    }

    /**
     * 场景：（1）我负责的客户， （2）全部客户， （3）我参与的客户
     */
    //点击我负责的客户
    @GetMapping("/customer/myCharge/{charge_user_id}")
    public PageInfo<CustomerVo> inChargeOfCustomers(@PathVariable("charge_user_id") int charge_user_id, Integer pageNum, Integer pageSize) {
        PageInfo<CustomerVo> customerVoPageInfo = customerService.queryInChargeOfCustomers(charge_user_id, pageNum, pageSize);
        return customerVoPageInfo;
    }

    //点击全部客户
    @GetMapping("/customer/all")
    public String clickAllCustomer() {
        return "redirect:/customer";
    }

    //点击我参与的客户
    @GetMapping("/customer/participate/{charge_user_id}")
    public PageInfo<CustomerVo> iParticipate(@PathVariable("charge_user_id") int charge_user_id, Integer pageNum, Integer pageSize) {
        PageInfo<CustomerVo> customerVoPageInfo = customerService.queryIParticipateCustomers(charge_user_id, pageNum, pageSize);
        return customerVoPageInfo;
    }

    //新建客户点击保存
    @PostMapping("/customer")
    public int insertCustomer(@RequestBody Customer customer){
        System.out.println(customer);
        System.out.println("下次联系时间："+customer.getNext_time());
        customer.setCreate_time(new Date());
        int result = customerService.insertCustomer(customer);

        if (result > 0) {
            return ConstantTip.SUCCESS_CODE_RETURN;
        } else {
            return ConstantTip.DEFEAT_CODE_RETURN;
        }
    }



    @GetMapping("/test")
    public Result<PageResult<String>> tests(){
      PageResult<String> pageResult = new PageResult<>();
        List<String> list =new ArrayList<>();
        list.add("aa");
        list.add("bbb");
        pageResult.setData(list).setPage(1).setSize(5).setTotal(20);
        Result<PageResult<String>> result = new Result<>();
        result.setData(pageResult).setCode(HttpStatus.OK).setMessage("test");
        return result;

    }

    //新建用户点击保存并新建联系人,插入并跳转到新建联系人页面
    @PostMapping("/customer/toAddContactPage")
    public Result<Integer> insertCustomerAndToAddContactPage(Customer customer, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int count = customerService.insertCustomer(customer);
        Result<Integer> result= new Result<>();

        if (count > 0) {
            request.setAttribute("customer", customer);
            request.getRequestDispatcher("/contactController/addContact").forward(request, response);    //转发至添加联系人页面
            result.setCode(HttpStatus.OK).setData(200).setMessage("test");
        } else {

            result.setCode(HttpStatus.OK).setData(100).setMessage("test");
            return result;
        }
        return result;
    }
}
