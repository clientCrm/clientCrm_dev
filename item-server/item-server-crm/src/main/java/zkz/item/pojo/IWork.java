package zkz.item.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/*
* 关联业务表
* */
@Table(name = "i_work")
@Data
public class IWork {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private Integer itemId;

    private Integer taskId;

    private Integer customerId;

    private Integer contractId;


    @Override
    public String toString() {
        return "IWork{" +
                "id=" + id +
                ", itemId=" + itemId +
                ", taskId=" + taskId +
                ", customerId=" + customerId +
                ", contractId=" + contractId +
                '}';
    }
}