package zkz.kehu.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerVo implements Serializable {
    @NonNull
    private Integer customer_id;//主键
    @NonNull private String customer_name;//客户名称
    @NonNull private String mobile;//手机
    private String telephone;//电话
    private String detail_address;//客户地址
    private String industry;//客户行业
    private String source;//客户来源
    @NonNull private Integer cus_level;//客户级别1重点2普通3非优先
    private String remarks;//备注
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date create_time;//创建时间
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date update_time;//最后修改时间
    private Integer charge_user_id;//负责人id
    private Integer create_user_id;//创建人id
    private Integer follow_up;//跟进状态，0未跟进，1已跟进
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date next_time;//下次联系时间

    private String charge_man;
    private String create_man;
}
