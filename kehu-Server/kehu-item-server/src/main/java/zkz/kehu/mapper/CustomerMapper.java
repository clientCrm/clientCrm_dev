package zkz.kehu.mapper;

import org.apache.ibatis.annotations.Mapper;
import zkz.kehu.pojo.Customer;
import zkz.kehu.vo.CustomerVo;

import java.util.List;
@Mapper
public interface CustomerMapper {

    List<CustomerVo> queryAllCustomers();

    List<CustomerVo> queryInChargeOfCustomers(int charge_user_id);

    List<CustomerVo> queryIParticipateCustomers(int charge_user_id);

    List<CustomerVo> queryCustomerByNameOrNumb(String nameOrNumb);

    int insertCustomer(Customer customer);

}
