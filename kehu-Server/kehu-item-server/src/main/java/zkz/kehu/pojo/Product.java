package zkz.kehu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {
    private Integer product_id;//主键
    private String product_name;//产品名称
    private String unit;//产品编码
    private BigDecimal price;//价格
    private Integer status;//状态1上架2下架
    private Integer category_id;//产品分类id
    private String description;//产品描述
    @NonNull private Integer create_user_id;//创建人id
    private Integer owner_user_id;//负责人id
    @NonNull private Date create_time;//创建时间
    private Date update_time;//最后时间
    private String product_remark;//备注
}
