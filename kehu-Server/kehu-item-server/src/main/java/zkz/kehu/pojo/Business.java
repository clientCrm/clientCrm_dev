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
public class Business implements Serializable {
    @NonNull private Integer business_id;//商机表主键
    @NonNull private String business_name;//商机名称
    private BigDecimal business_money;//商机金额
    private Date deal_date;//预计成交日期
    @NonNull private Integer customer_id;//客户id
    @NonNull private Integer create_user_id;//创建人id
    private Integer owner_user_id;//负责人id
    @NonNull private Date create_time;//创建时间
    private Date update_time;//最后修改时间
    private Integer is_end;//商机阶段，1赢单2输单3无效
    private String business_remark; //商机备注
}
