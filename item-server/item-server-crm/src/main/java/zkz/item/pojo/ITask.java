package zkz.item.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/*
* 项目任务表
* @Data  代替Getter/Setter方法
* */
@Table(name = "i_task")
@Data
public class ITask {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer iTaskId;

    private Integer itemId;

    private String taskName;

    private Integer userId;

    private Integer joinId;

    private Date createTime;

    private Date endTime;

    private Integer level;

    private String describe;

    private Integer work;

    private Integer labelId;


    @Override
    public String toString() {
        return "ITask{" +
                "iTaskId=" + iTaskId +
                ", itemId=" + itemId +
                ", taskName='" + taskName + '\'' +
                ", userId=" + userId +
                ", joinId=" + joinId +
                ", createTime=" + createTime +
                ", endTime=" + endTime +
                ", level=" + level +
                ", describe='" + describe + '\'' +
                ", work=" + work +
                ", labelId=" + labelId +
                '}';
    }
}