package zkz.item.vo;

import lombok.Data;

import zkz.item.pojo.IMember;
import zkz.item.pojo.Item;
import java.io.Serializable;
import java.util.List;


/*
 * 项目
 * */

public class ItemVo implements Serializable{

    private Item item;
    private List<IMember> itemMembers;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public List<IMember> getItemMembers() {
        return itemMembers;
    }

    public void setItemMembers(List<IMember> itemMembers) {
        this.itemMembers = itemMembers;
    }
}
