package zkz.kehu.mapper;

import zkz.kehu.vo.ProductVo;

import java.util.List;

public interface ProductMapper {
    List<ProductVo> queryProducts(Integer pageNum, Integer pageSize);

    List<ProductVo> queryUpProducts(Integer pageNum, Integer pageSize);
}
