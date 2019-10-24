package zkz.item.common.api;

import org.springframework.web.bind.annotation.*;
import zkz.item.common.pojo.Label;
import zkz.item.common.pojo.PageResult;

import java.util.List;

public interface LabelApi {

    /*
    * 分页
    * @return 标签总数
    * */
        @GetMapping("label/getTotal")
    int getTotal();

    /*
    * 分页
    * 根据当前页 page 和每页显示数 limit 查询当页面的标签
    * */
    @GetMapping("label/{thisPage}/{limit}")
    List<Label> getByThisPage(@PathVariable Integer thisPage,@PathVariable Integer limit);

    /*
    * 分页，返回结果集
    * */
    @GetMapping("label/getByPaging/{thisPage}/{limit}")
    PageResult getByPaging(@PathVariable Integer thisPage,@PathVariable Integer limit);

    @GetMapping("label/{id}")
    Label queryById(@PathVariable Integer id);

    @GetMapping("label")
    List<Label> query();

    @PostMapping("label")
    int addItem(Label label);

    @PutMapping("label")
    int update(Label label);

    @DeleteMapping("label/{id}")
    int delete(@PathVariable Integer id);


}
