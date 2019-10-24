package zkz.item.common.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/*
* 项目表
* @Data  代替Getter/Setter方法
* */
@Table(name = "item")
@Data
public class Item implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer itemId;  //主键ID

    private String itemName; //项目名

    private String idescribe; //项目描述

    private Integer scope;  //项目可见范围  0、私有 1、公开

    private Integer sort;  //项目是否归档   0、否   1、是

    private Integer type;  //项目存在状态   0、删除 1、存在

    private Date createTime;

    private Date endTime;

}