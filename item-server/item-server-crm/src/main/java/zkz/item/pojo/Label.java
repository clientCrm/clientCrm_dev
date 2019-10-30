package zkz.item.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/*
* 标签表
* @Data  代替Getter/Setter方法
* */
@Table(name = "label")
@Getter
@Setter
@Data
public class Label implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer labelId;
    private String labelName;
    private Integer colour;


}
