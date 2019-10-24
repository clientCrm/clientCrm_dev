package zkz.item.common.api;

import org.springframework.web.bind.annotation.*;
import zkz.item.common.pojo.Item;

import java.util.List;

/*
 * GET:    select
 * POST:   insert
 * PUT:    update
 * DELETE: delete
 * */
public interface ItemApi {

    @GetMapping("item/{id}")
    Item queryItemById(@PathVariable Integer id);

    @GetMapping("item")
    List<Item> queryItem();

    @PostMapping("item")
    int addItem(Item item);

    @PutMapping("item")
    int update(Item item);

    @DeleteMapping("item/{id}")
    int delete(@PathVariable Integer id);

}
