package zkz.item.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zkz.item.mapper.ItemMapper;
import zkz.item.pojo.Item;
import zkz.item.pojo.PageResult;
import zkz.item.pojo.Test;
import zkz.item.service.ItemService;
import zkz.item.util.Base;
import zkz.item.vo.ItemVo;

import java.util.List;

/*
* GET:    select
* POST:   insert
* PUT:    update
* DELETE: delete
* */
@RestController
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("item/getById")
    public Item queryItemById(@PathVariable Integer id) {
        return itemService.queryItemById(id);
    }

    /*
     *   分页,项目分页，未删除以及未归档
     *   @Param sort type
     *   return list
     * */
    @GetMapping("item/getPageByExit")
    public PageResult getPageByExit(@RequestParam Integer sort,@RequestParam Integer type,@RequestParam Integer thisPage,@RequestParam Integer limit) {
        System.out.println("kkk");
        return itemService.getPageByExit(sort,type,thisPage,limit);
    }

    /*
    *   分页
    *   @Param sort 归档
    *   return list
    * */
    @GetMapping("item/getPageBySort")
    public PageResult getPageBySort(@RequestParam Integer sort,@RequestParam Integer thisPage, @RequestParam Integer limit) {
        return itemService.getPageBySort(sort,thisPage,limit);
    }

    @GetMapping("item/getByItemFinish")
    public List<Item> getByItemFinish(@RequestParam Integer itemFinish) {
        return itemService.getByItemFinish(itemFinish);
    }

    @GetMapping("item/getByIng")
    public List<Object> getByIng(@RequestParam Integer itemFinish1,@RequestParam Integer itemFinish2,@RequestParam Integer sort) {
        return itemService.getByIng(itemFinish1,itemFinish2,sort);
    }


    @PostMapping("item")
    public Base addItem(@RequestBody ItemVo itemVo) {
        System.out.println(itemVo);
        return itemService.addItem(itemVo);
    }

    @PutMapping("item")
    int update( Item item) {
        return 0;
    }

    @DeleteMapping("item/{id}")
    int delete(@PathVariable Integer id) {
        return 0;
    }
}
