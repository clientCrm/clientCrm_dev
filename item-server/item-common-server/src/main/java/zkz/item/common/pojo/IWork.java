package zkz.item.common.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
*关联业务表
* @Data  代替Getter/Setter方法
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

}