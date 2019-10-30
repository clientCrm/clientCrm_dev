package zkz.item.service;

import zkz.item.pojo.Item;
import zkz.item.pojo.PageResult;
import zkz.item.util.Base;
import zkz.item.vo.ItemVo;

import java.util.List;

public interface ItemService {

    Item queryItemById(Integer id);

    List<Item> queryItem();

    Base addItem(ItemVo itemVo);

    List<Item> getByItemFinish(Integer itemFinish);

    List<Object> getByIng(Integer itemFinish1, Integer itemFinish2, Integer sort);

    PageResult getPageByExit(Integer sort, Integer type, Integer thisPage, Integer limit);

    PageResult getPageBySort(Integer sort,Integer thisPage,Integer limit);

    int updateBySort(Integer itemId, Integer sort);
}
