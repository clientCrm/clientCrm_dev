package zkz.kehu.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductVo implements Serializable {
    private int product_id;
    private String product_name;
    private String product_code;//产品编码
    private BigDecimal price;//价格
    private String pd_unit;//产品单位
    private int pd_numb;//产品数量
    private Integer status;//状态1上架2下架
    private Integer category_id;//产品分类id
    private String name;//产品类别名
    private String description;//产品描述
    private int create_user_id;
    private int charge_user_id;
    private String create_man;
    private String charge_man;
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date create_time;//创建时间
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date update_time;//最后时间
    private String product_remark;//备注
}
