package zkz.item.common.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
* 项目讨论表
* @Data  代替Getter/Setter方法
* */
@Table(name = "i_discuss")
@Data
public class IDiscuss {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private Integer itemId;

    private String context;

}