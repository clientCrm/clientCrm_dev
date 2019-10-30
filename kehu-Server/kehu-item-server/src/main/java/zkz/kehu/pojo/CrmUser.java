package zkz.kehu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrmUser implements Serializable {
    private Integer user_id;//操作员id
    @NonNull private String username;//操作员账号
    @NonNull private String password;
    private String img; // 头像
    @NonNull private String realname;//真实姓名
    private Date user_create_time;
    private String num;//员工编号
    private String mobile;
    private String email;
    private String sex;//性别
    private int user_dept_id;//部门id
    private String post;//职位
    private int status;//状态：0禁用、1正常，2未激活
    private int parent_id;  //直属上级id
    private Date last_login_time;//上次登录时间

}
