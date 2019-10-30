package zkz.kehu.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusinessVo {
    private String business_id;
    private String business_name;
    private String customer_name;
    private BigDecimal business_money;//商机金额
    private Integer is_end;//商机阶段，1赢单2输单3跟进中
    private String business_remark; //商机备注
    private String create_man;
    private String charge_man;
    @NonNull
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date b_create_time;//创建时间
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date b_update_time;//最后修改时间
}
