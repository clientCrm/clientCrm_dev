package zkz.kehu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer implements Serializable {
    private Integer customer_id;//主键--------------
    @NonNull private String customer_name;//客户名称
    @NonNull private String mobile;//手机
    private String telephone;//电话
    private String detail_address;//客户地址
    private String industry;//客户行业
    private String source;//客户来源
    @NonNull private int cus_level;//客户级别1重点2普通3非优先
    private String remarks;//备注
    @NonNull private Date create_time;//创建时间
    private Date update_time;//最后修改时间
    private int charge_user_id;//负责人id
    private int create_user_id;//创建人id（当前创建人id）
    private int follow_up;//跟进状态，0未跟进，1已跟进
    private Date next_time;//下次联系时间

    //private CRMUser crmUser;
}
