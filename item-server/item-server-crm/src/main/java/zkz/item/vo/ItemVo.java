package zkz.item.vo;

import lombok.Data;

import zkz.item.pojo.IMember;
import zkz.item.pojo.Item;
import java.io.Serializable;
import java.util.List;


/*
 * 项目
 * */
@Data
public class ItemVo implements Serializable{

    private Item item;
    private List<IMember> iMembers;

    /*private Integer itemId;     //项目 ID

    private String itemName;    //项目名

    private String idescribe;   //项目描述

    private Integer scope;      //项目可见范围  0、私有 1、公开

    private Integer sort;       //项目是否归档   0、否   1、是

    private Integer type;       //项目存在状态   0、删除 1、存在

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createTime;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date endTime;*/



   /* private Integer userId;     //成员用户 ID

    private Integer taskId;     //成员参与任务 ID

    private Integer memberType; //成员类型，1、负责人  0、参与者*/
}
