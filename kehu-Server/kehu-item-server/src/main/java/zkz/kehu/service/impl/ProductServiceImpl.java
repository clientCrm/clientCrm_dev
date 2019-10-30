package zkz.kehu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zkz.kehu.mapper.ProductMapper;
import zkz.kehu.service.ProductService;
import zkz.kehu.vo.ProductVo;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public PageInfo<ProductVo> queryProducts(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<ProductVo> list = productMapper.queryProducts(pageNum, pageSize);
        PageInfo<ProductVo> productVoPageInfo = new PageInfo<>(list);
        return productVoPageInfo;
    }

    @Override
    public PageInfo<ProductVo> queryUpProducts(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<ProductVo> list = productMapper.queryUpProducts(pageNum, pageSize);
        PageInfo<ProductVo> productVoPageInfo = new PageInfo<>(list);
        return productVoPageInfo;
    }
}
