package zkz.kehu.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import zkz.kehu.service.ProductService;
import zkz.kehu.vo.ProductVo;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public PageInfo<ProductVo> queryProducts(Integer pageNum, Integer pageSize){
        PageInfo<ProductVo> productVoPageInfo = productService.queryProducts(pageNum, pageSize);
        return productVoPageInfo;
    }

    //查询所有已经上架的商品
    @GetMapping("/product/up")
    public PageInfo<ProductVo> queryUpProducts(Integer pageNum, Integer pageSize){
        PageInfo<ProductVo> productVoPageInfo = productService.queryUpProducts(pageNum, pageSize);
        return productVoPageInfo;
    }
}
