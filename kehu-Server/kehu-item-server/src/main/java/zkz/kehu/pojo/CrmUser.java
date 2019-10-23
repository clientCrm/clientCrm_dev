package zkz.kehu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrmUser implements Serializable {
    private Integer user_id;//操作员id
    @NonNull private String account;//操作员账号
    @NonNull private String password;
    @NonNull private String fullname;//真实姓名
    private String gender;//性别
    private Integer age;
    private String phone;
    private String email;
    private String user_address;
    private String department;

    //List<Customer> list = new ArrayList<>();
}
