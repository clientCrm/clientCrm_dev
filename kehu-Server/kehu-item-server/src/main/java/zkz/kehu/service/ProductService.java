package zkz.kehu.service;

import com.github.pagehelper.PageInfo;
import zkz.kehu.vo.ProductVo;

public interface ProductService {
    PageInfo<ProductVo> queryProducts(Integer pageNum, Integer pageSize);

    PageInfo<ProductVo> queryUpProducts(Integer pageNum, Integer pageSize);
}
