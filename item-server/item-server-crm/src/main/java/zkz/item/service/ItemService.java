package zkz.item.service;

import zkz.item.pojo.Item;

import java.util.List;

public interface ItemService {
    Item queryItemById(Integer id);
    List<Item> queryItem();
}
