package zkz.item.mapper;


import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;
import zkz.item.pojo.Item;

import java.util.List;

public interface ItemMapper extends Mapper<Item> {
    @Select("select * from item where item_finish=#{itemFinish}")
    List<Item> getByItemFinish(@Param("itemFinish") Integer itemFinish);

    @Select("select * from item where sort=#{sort}")
    List<Item> getBySort(@Param("sort") Integer sort);

    @Select("select * from item where type=#{type} and sort=#{sort}")
    List<Item> queryItem(@Param("type") Integer type, @Param("sort") Integer sort);



    /*
     * 分页
     * 项目分页，未删除以及未归档
     * */
    @Select("select count(*) from item where sort=#{sort} and type=#{type}")
    Integer getTotalByExit(@Param("sort") Integer sort, @Param("type") Integer type);

    @Select("select * from item where sort=#{sort} and type=#{type} limit #{thisPage} ,#{limit}")
    List<Item> getPageByExit(@Param("sort") Integer sort, @Param("type") Integer type, @Param("thisPage") Integer thisPage, @Param("limit") Integer limit);

    /*
     * 分页
     * 归档分页
     * */
    @Select("select count(*) from item where sort=#{sort}")
    Integer getTotalBySort(@Param("sort") Integer sort);

    @Select("select * from item where sort=#{sort} limit #{thisPage} ,#{limit}")
    List<Item> getPageBySort(@Param("sort") Integer sort, @Param("thisPage") Integer thisPage, @Param("limit") Integer limit);

}
