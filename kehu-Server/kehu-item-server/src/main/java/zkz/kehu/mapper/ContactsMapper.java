package zkz.kehu.mapper;

import org.apache.ibatis.annotations.Mapper;
import zkz.kehu.pojo.Contacts;
import zkz.kehu.vo.ContactsVo;

import java.util.List;

@Mapper
public interface ContactsMapper{
    List<ContactsVo> queryAllContacts();

    List<ContactsVo> queryContactsByNameOrNumb(String nameOrNumb);

    int addContact(Contacts contacts);
}
