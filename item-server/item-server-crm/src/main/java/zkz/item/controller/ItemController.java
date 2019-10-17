package zkz.item.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zkz.item.mapper.ItemMapper;
import zkz.item.pojo.Item;
import zkz.item.service.ItemService;

import java.util.List;

/*
* GET:    select
* POST:   insert
* PUT:    update
* DELETE: delete
* */
@RestController
//@RequestMapping("item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("item/{id}")
    public Item queryItemById(@PathVariable Integer id) {
        System.out.println("进入");
        return itemService.queryItemById(id);
    }

    @GetMapping("item")
    @ResponseBody
    public List<Item> queryItem() {
        System.out.println("进入item");
        return itemService.queryItem();
    }

    @PostMapping("item")
    int addItem(Item item) {
        return 0;
    }

    @PutMapping("item")
    int update(Item item) {
        return 0;
    }

    @DeleteMapping("item/{id}")
    int delete(@PathVariable Integer id) {
        return 0;
    }
}
