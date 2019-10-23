package zkz.kehu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zkz.kehu.mapper.ContactsMapper;
import zkz.kehu.pojo.Contacts;
import zkz.kehu.service.ContactsService;
import zkz.kehu.vo.ContactsVo;

import java.util.List;

@Service
public class ContactsServiceImpl implements ContactsService {

    @Autowired
    private ContactsMapper contactsMapper;

    @Override
    public PageInfo<ContactsVo> queryAllContacts(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<ContactsVo> contacts = contactsMapper.queryAllContacts();
        for (ContactsVo list: contacts){
            System.out.println(list);
        }
        PageInfo<ContactsVo> customerVoPageInfo = new PageInfo<>(contacts);
        return customerVoPageInfo;
    }



    @Override
    public PageInfo<ContactsVo> queryContactsByNameOrNumb(String nameOrNumb, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<ContactsVo> contacts = contactsMapper.queryContactsByNameOrNumb(nameOrNumb);
        PageInfo<ContactsVo> customerVoPageInfo = new PageInfo<>(contacts);
        return customerVoPageInfo;
    }

    //添加联系人
    public int addContacts(Contacts contacts) {
        int result = contactsMapper.addContact(contacts);
        return result;
    }


}
