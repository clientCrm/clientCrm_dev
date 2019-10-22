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
public class Contract implements Serializable {
    @NonNull private Integer contract_id;//主键
    @NonNull private String name;//合同名称
    private Integer coustomer_id;//客户id
    private Integer business_id;//商机id
    private Integer check_status;//审核状态，1是待审2审核通过3审核未通过4已撤回
    private Date order_date;//下单日期
    @NonNull private Integer create_user_id;//创建人id
    private Integer owner_user_id;//负责人id(负责跟进，签约）
    @NonNull private Date create_time;//创建时间
    private Date update_time;//最后修改时间
    private String num;//合同编号
    private Date start_time;//开始时间
    private Date end_time;//结束时间
    private BigDecimal contract_money;//合同金额
    private Integer contacts_id;//客户签约人（联系人）
    private String contract_remark;//备注
}
