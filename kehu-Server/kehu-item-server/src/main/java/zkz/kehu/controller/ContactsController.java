package zkz.kehu.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zkz.kehu.comment.ConstantTip;
import zkz.kehu.pojo.Contacts;
import zkz.kehu.mapper.ContactsMapper;
import zkz.kehu.service.ContactsService;
import zkz.kehu.vo.ContactsVo;
import zkz.kehu.vo.CustomerBindVo;
import zkz.kehu.vo.CustomerVo;

import java.util.Date;


@RestController
public class ContactsController {

    @Autowired
    private ContactsService contactsService;

    @GetMapping("/contacts")
    public PageInfo<ContactsVo> queryAllContacts(Integer pageNum, Integer pageSize){
        PageInfo<ContactsVo> contactsPageInfo = contactsService.queryAllContacts(pageNum, pageSize);
        return contactsPageInfo;
    }

    //输入联系人信息并点击添加
    @PostMapping("/contacts")
    public String addContact(@RequestBody Contacts contacts){
        contacts.setCreate_time(new Date());
         int result = contactsService.addContacts(contacts);
         if (result > 0){
             return ConstantTip.SUCCESS_CODE_RETURN;
         }
         return ConstantTip.DEFEAT_CODE_RETURN;
    }

    //模糊查询（输入联系人名称、手机或电话号码进行模糊查询）
    @GetMapping("/contacts/vagueQuery/{nameOrNumb}")
    public PageInfo<ContactsVo> queryCustomerByCase(@PathVariable("nameOrNumb") String nameOrNumb, Integer pageNum, Integer pageSize) {
        PageInfo<ContactsVo> customerVoPageInfo = contactsService.queryContactsByNameOrNumb(nameOrNumb, pageNum, pageSize);
        return customerVoPageInfo;
    }

    //查出客户 id、客户名、创建时间、更新时间、下次联系时间显示到添加联系人的绑定客户列表
    @GetMapping("/contacts/cusBind")
    public PageInfo<CustomerBindVo> bindCustomerList(Integer pageNum, Integer pageSize){
        System.out.println(pageNum+":"+pageSize);
        PageInfo<CustomerBindVo> customerBindVoPageInfo = contactsService.bindCustomerList(pageNum, pageSize);
        return customerBindVoPageInfo;
    }
}
