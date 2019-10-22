package zkz.kehu.service;

import com.github.pagehelper.PageInfo;
import zkz.kehu.vo.ContactsVo;

public interface ContactsService {
    PageInfo<ContactsVo> queryAllContacts(Integer pageNum, Integer pageSize);

    PageInfo<ContactsVo> queryContactsByNameOrNumb(String nameOrNumb, Integer pageNum, Integer pageSize);
}
