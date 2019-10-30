package zkz.item.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;
import zkz.item.pojo.Label;

import java.util.List;


public interface LabelMapper extends Mapper<Label> {
//    @Select("select count(label_id) from label")
    int getTotal();
    List<Label> getByThisPage(@Param("thisPage") Integer thisPage, @Param("limit") Integer limit);
}
