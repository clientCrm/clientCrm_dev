package zkz.item.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;
import zkz.item.pojo.IMember;

import java.util.List;

public interface IMemberMapper extends Mapper<IMember> {
    @Select("select * from i_member where item_id=#{itemId}")
    List<IMember> getByItemId(@Param("itemId") int itemId);
}
