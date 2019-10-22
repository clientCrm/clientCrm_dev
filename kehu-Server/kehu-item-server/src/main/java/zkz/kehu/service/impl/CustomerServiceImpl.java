package zkz.kehu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zkz.kehu.pojo.Customer;
import zkz.kehu.mapper.CustomerMapper;
import zkz.kehu.service.CustomerService;
import zkz.kehu.vo.CustomerVo;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public PageInfo<CustomerVo> queryAllCustomers(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<CustomerVo> customers = customerMapper.queryAllCustomers();
        PageInfo<CustomerVo> customerVoPageInfo = new PageInfo<>(customers);
        return customerVoPageInfo;
    }

    @Override
    public PageInfo<CustomerVo> queryCustomerByNameOrNumb(String nameOrNumb, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<CustomerVo> customers = customerMapper.queryCustomerByNameOrNumb(nameOrNumb);
        PageInfo<CustomerVo> customerVoPageInfo = new PageInfo<>(customers);
        return customerVoPageInfo;
    }

    @Override
    public PageInfo<CustomerVo> queryInChargeOfCustomers(int charge_user_id, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<CustomerVo> customers = customerMapper.queryInChargeOfCustomers(charge_user_id);
        PageInfo<CustomerVo> customerVoPageInfo = new PageInfo<>(customers);
        return customerVoPageInfo;
    }

    @Override
    public PageInfo<CustomerVo> queryIParticipateCustomers(int charge_user_id, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<CustomerVo> customers = customerMapper.queryIParticipateCustomers(charge_user_id);
        PageInfo<CustomerVo> customerVoPageInfo = new PageInfo<>(customers);
        return customerVoPageInfo;
    }

    @Override
    public int insertCustomer(Customer customer) {
        return customerMapper.insertCustomer(customer);
    }
}
