package zkz.kehu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;
import java.util.Date;

@Data   //@Data注解在类上，会为类的所有属性自动生成setter/getter、equals、canEqual、hashCode、toString方法，如为final属性，则不会为该属性生成setter方法。
@AllArgsConstructor
@NoArgsConstructor
public class Contacts implements Serializable {
    @NonNull private Integer contacts_id;//主键
    private String name;//姓名
    private String mobile;//手机
    private String telephone;//电话
    private String email;//电子邮箱
    private String sex;//性别
    private String address;//地址
    private String post;//职位
    private String policy_decision;//是否是决策人
    private String contacts_remarks;//备注
    private Date create_time;//创建时间
    private Date update_time;//最后修改时间
    private Date contacts_next_time;//下次联系时间
    private Integer customer_id;//所在公司id
}
