package zkz.kehu.service;

import com.github.pagehelper.PageInfo;
import zkz.kehu.vo.BusinessVo;

public interface BusinessService {
    PageInfo<BusinessVo> queryBusiness(Integer pageNumb, Integer pageSize);
}
