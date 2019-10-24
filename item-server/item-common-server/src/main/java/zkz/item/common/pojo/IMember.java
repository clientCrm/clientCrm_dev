package zkz.item.common.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
* 项目成员表
* @Data  代替Getter/Setter方法
* */
@Table(name = "i_member")
@Data
public class IMember {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private Integer itemId;      //项目 ID

    private Integer userId;     //成员用户 ID

    private Integer taskId;     //成员参与任务 ID

    private Integer memberType; //成员类型，1、负责人  0、参与者

}