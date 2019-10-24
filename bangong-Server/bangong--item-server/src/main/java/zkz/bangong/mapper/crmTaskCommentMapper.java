package zkz.bangong.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zkz.bangong.layui.crmTaskLayuiComment;
import zkz.bangong.pojo.crmTaskComment;
import zkz.bangong.pojo.crmTaskCommentExample;

public interface crmTaskCommentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_task_comment
     *
     * @mbg.generated Tue Oct 22 16:55:02 CST 2019
     */
    long countByExample(crmTaskCommentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_task_comment
     *
     * @mbg.generated Tue Oct 22 16:55:02 CST 2019
     */
    int deleteByExample(crmTaskCommentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_task_comment
     *
     * @mbg.generated Tue Oct 22 16:55:02 CST 2019
     */
    int deleteByPrimaryKey(Integer cmmentId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_task_comment
     *
     * @mbg.generated Tue Oct 22 16:55:02 CST 2019
     */
    int insert(crmTaskComment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_task_comment
     *
     * @mbg.generated Tue Oct 22 16:55:02 CST 2019
     */
    int insertSelective(crmTaskComment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_task_comment
     *
     * @mbg.generated Tue Oct 22 16:55:02 CST 2019
     */
    List<crmTaskComment> selectByExample(crmTaskCommentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_task_comment
     *
     * @mbg.generated Tue Oct 22 16:55:02 CST 2019
     */
    crmTaskComment selectByPrimaryKey(Integer cmmentId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_task_comment
     *
     * @mbg.generated Tue Oct 22 16:55:02 CST 2019
     */
    int updateByExampleSelective(@Param("record") crmTaskComment record, @Param("example") crmTaskCommentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_task_comment
     *
     * @mbg.generated Tue Oct 22 16:55:02 CST 2019
     */
    int updateByExample(@Param("record") crmTaskComment record, @Param("example") crmTaskCommentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_task_comment
     *
     * @mbg.generated Tue Oct 22 16:55:02 CST 2019
     */
    int updateByPrimaryKeySelective(crmTaskComment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_task_comment
     *
     * @mbg.generated Tue Oct 22 16:55:02 CST 2019
     */
    int updateByPrimaryKey(crmTaskComment record);

    /*员工对任务或者日志新增一条评论*/
    void addComment(String commentType, crmTaskComment crmTaskComent);
}