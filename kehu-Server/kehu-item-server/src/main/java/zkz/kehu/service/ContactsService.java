package zkz.kehu.service;

import com.github.pagehelper.PageInfo;
import zkz.kehu.pojo.Contacts;
import zkz.kehu.vo.ContactsVo;
import zkz.kehu.vo.CustomerBindVo;

public interface ContactsService {
    PageInfo<ContactsVo> queryAllContacts(Integer pageNum, Integer pageSize);

    PageInfo<ContactsVo> queryContactsByNameOrNumb(String nameOrNumb, Integer pageNum, Integer pageSize);

    int addContacts(Contacts contacts);

    PageInfo<CustomerBindVo> bindCustomerList(Integer pageNum, Integer pageSize);
}
