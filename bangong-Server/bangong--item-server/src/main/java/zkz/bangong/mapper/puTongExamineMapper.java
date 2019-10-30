package zkz.bangong.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zkz.bangong.pojo.puTongExamine;
import zkz.bangong.pojo.puTongExamineExample;

public interface puTongExamineMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_putong_examine
     *
     * @mbg.generated Wed Oct 23 12:33:04 CST 2019
     */
    long countByExample(puTongExamineExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_putong_examine
     *
     * @mbg.generated Wed Oct 23 12:33:04 CST 2019
     */
    int deleteByExample(puTongExamineExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_putong_examine
     *
     * @mbg.generated Wed Oct 23 12:33:04 CST 2019
     */
    int deleteByPrimaryKey(Integer putongExamineId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_putong_examine
     *
     * @mbg.generated Wed Oct 23 12:33:04 CST 2019
     */
    int insert(puTongExamine record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_putong_examine
     *
     * @mbg.generated Wed Oct 23 12:33:04 CST 2019
     */
    int insertSelective(puTongExamine record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_putong_examine
     *
     * @mbg.generated Wed Oct 23 12:33:04 CST 2019
     */
    List<puTongExamine> selectByExample(puTongExamineExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_putong_examine
     *
     * @mbg.generated Wed Oct 23 12:33:04 CST 2019
     */
    puTongExamine selectByPrimaryKey(Integer putongExamineId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_putong_examine
     *
     * @mbg.generated Wed Oct 23 12:33:04 CST 2019
     */
    int updateByExampleSelective(@Param("record") puTongExamine record, @Param("example") puTongExamineExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_putong_examine
     *
     * @mbg.generated Wed Oct 23 12:33:04 CST 2019
     */
    int updateByExample(@Param("record") puTongExamine record, @Param("example") puTongExamineExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_putong_examine
     *
     * @mbg.generated Wed Oct 23 12:33:04 CST 2019
     */
    int updateByPrimaryKeySelective(puTongExamine record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_putong_examine
     *
     * @mbg.generated Wed Oct 23 12:33:04 CST 2019
     */
    int updateByPrimaryKey(puTongExamine record);
}