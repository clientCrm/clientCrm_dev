package zkz.item.service;

import zkz.item.pojo.Label;
import zkz.item.pojo.PageResult;

import java.util.List;

public interface LabelService {
    PageResult getByPaging(Integer thisPage, Integer limit);
    List<Label> getByThisPage(Integer thisPage, Integer limit);
    int getTotal();
}
