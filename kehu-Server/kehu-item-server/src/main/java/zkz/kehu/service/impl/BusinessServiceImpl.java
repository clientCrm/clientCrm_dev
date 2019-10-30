package zkz.kehu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zkz.kehu.mapper.BusinessMapper;
import zkz.kehu.service.BusinessService;
import zkz.kehu.vo.BusinessVo;

import java.util.List;

@Service
public class BusinessServiceImpl implements BusinessService {
    @Autowired
    private BusinessMapper businessMapper;

    @Override
    public PageInfo<BusinessVo> queryBusiness(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<BusinessVo> list = businessMapper.queryBusiness();
        PageInfo<BusinessVo> businessVoPageInfo = new PageInfo<>(list);
        return businessVoPageInfo;
    }
}
