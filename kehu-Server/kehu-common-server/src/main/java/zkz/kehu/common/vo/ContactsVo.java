package zkz.kehu.common.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class ContactsVo implements Serializable {

    private String customer_name;//客户名称
    private String name;//客户联系人姓名
    private String mobile;//手机
    private String telephone;//电话
    private String email;//电子邮箱
    private String sex;//性别
    private String address;//地址
    private String post;//职位
    private String policy_decision;//是否是决策人
    private String contacts_remarks;//备注
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date create_time;//创建时间
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date update_time;//最后修改时间
}
