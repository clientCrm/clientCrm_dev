package zkz.kehu.service;

import com.github.pagehelper.PageInfo;
import zkz.kehu.pojo.Customer;
import zkz.kehu.vo.CustomerVo;

public interface CustomerService {
    PageInfo<CustomerVo> queryAllCustomers(Integer pageNum, Integer pageSize);

    PageInfo<CustomerVo> queryCustomerByNameOrNumb(String nameOrNumb, Integer pageNum, Integer pageSize);

    PageInfo<CustomerVo> queryInChargeOfCustomers(int charge_user_id, Integer pageNum, Integer pageSize);

    PageInfo<CustomerVo> queryIParticipateCustomers(int charge_user_id, Integer pageNum, Integer pageSize);

    int insertCustomer(Customer customer);
}
