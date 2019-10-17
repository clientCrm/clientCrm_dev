package zkz.item.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/*
* 项目子任务表
* @Data  代替Getter/Setter方法
* */
@Table(name = "i_task_subtask")
@Data
public class ITaskSubtask {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String context;

    private Integer itemId;

    private Integer userId;

    private Date createTime;

    private Date endTime;

    @Override
    public String toString() {
        return "ITaskSubtask{" +
                "id=" + id +
                ", context='" + context + '\'' +
                ", itemId=" + itemId +
                ", userId=" + userId +
                ", createTime=" + createTime +
                ", endTime=" + endTime +
                '}';
    }
}