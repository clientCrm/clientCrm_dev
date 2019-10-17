package zkz.item.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
* 标签表
* @Data  代替Getter/Setter方法
* */
@Table(name = "lable")
@Data
public class Lable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer lableId;
    private String lableName;
    private Integer colour;

    @Override
    public String toString() {
        return "Lable{" +
                "lableId=" + lableId +
                ", lableName='" + lableName + '\'' +
                ", colour=" + colour +
                '}';
    }
}
