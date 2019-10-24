package zkz.item.pojo;

import lombok.Data;

import java.util.List;

@Data
public class PageResult<T> {
    private Long total2;// Int 总条数
    private Integer total;// Long 总条数
    private Integer totalPage;// 总页数
    private List<T> items;// 当前页数据,项目
    private List<Label> labels;// 当前页数据,标签

    public PageResult() {
    }

    public PageResult(Integer total, List<T> items) {
        this.total = total;
        this.items = items;
    }

    public PageResult(Integer total, Integer totalPage, List<T> items) {
        this.total = total;
        this.totalPage = totalPage;
        this.items = items;
    }



}
