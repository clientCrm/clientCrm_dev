package zkz.item.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/*
* 项目表
* */
@Table(name = "item" )
@Data
public class Item implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer itemId;

    private String itemName;

    private String idescribe;

    private Integer scope;

    private Integer sort;

    private Integer type;

    private Date createTime;

    private Date endTime;


    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", describe='" + idescribe + '\'' +
                ", scope=" + scope +
                ", sort=" + sort +
                ", type=" + type +
                ", createTime=" + createTime +
                ", endTime=" + endTime +
                '}';
    }
}