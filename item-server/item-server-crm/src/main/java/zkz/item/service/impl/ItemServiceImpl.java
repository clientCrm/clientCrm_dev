package zkz.item.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zkz.item.mapper.ItemMapper;
import zkz.item.pojo.Item;
import zkz.item.service.ItemService;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public Item queryItemById(Integer id) {
//        itemMapper.s
        System.out.println(id);
        return itemMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Item> queryItem() {
        return itemMapper.selectAll();
    }
}
