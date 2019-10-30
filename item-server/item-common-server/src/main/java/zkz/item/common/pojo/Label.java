package zkz.item.common.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
* 标签表
* @Data  代替Getter/Setter方法
* */
@Table(name = "label")
@Data
public class Label {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer lableId;
    private String lableName;
    private Integer colour;
}
