package zkz.item.pojo;

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

    private Integer itemId;

    private Integer userId;

    private Integer taskId;

    private Integer type;


    @Override
    public String toString() {
        return "IMember{" +
                "id=" + id +
                ", itemId=" + itemId +
                ", userId=" + userId +
                ", taskId=" + taskId +
                ", type=" + type +
                '}';
    }
}