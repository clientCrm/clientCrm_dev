package zkz.bangong.pojo;

import java.util.Date;

public class examineCategory {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column crm_examine_category.category_id
     *
     * @mbg.generated Wed Oct 23 09:15:55 CST 2019
     */
    private Integer categoryId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column crm_examine_category.examine_type
     *
     * @mbg.generated Wed Oct 23 09:15:55 CST 2019
     */
    private Integer examineType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column crm_examine_category.creater
     *
     * @mbg.generated Wed Oct 23 09:15:55 CST 2019
     */
    private Integer creater;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column crm_examine_category.create_time
     *
     * @mbg.generated Wed Oct 23 09:15:55 CST 2019
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column crm_examine_category.update_time
     *
     * @mbg.generated Wed Oct 23 09:15:55 CST 2019
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_examine_category.category_id
     *
     * @return the value of crm_examine_category.category_id
     *
     * @mbg.generated Wed Oct 23 09:15:55 CST 2019
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_examine_category.category_id
     *
     * @param categoryId the value for crm_examine_category.category_id
     *
     * @mbg.generated Wed Oct 23 09:15:55 CST 2019
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_examine_category.examine_type
     *
     * @return the value of crm_examine_category.examine_type
     *
     * @mbg.generated Wed Oct 23 09:15:55 CST 2019
     */
    public Integer getExamineType() {
        return examineType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_examine_category.examine_type
     *
     * @param examineType the value for crm_examine_category.examine_type
     *
     * @mbg.generated Wed Oct 23 09:15:55 CST 2019
     */
    public void setExamineType(Integer examineType) {
        this.examineType = examineType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_examine_category.creater
     *
     * @return the value of crm_examine_category.creater
     *
     * @mbg.generated Wed Oct 23 09:15:55 CST 2019
     */
    public Integer getCreater() {
        return creater;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_examine_category.creater
     *
     * @param creater the value for crm_examine_category.creater
     *
     * @mbg.generated Wed Oct 23 09:15:55 CST 2019
     */
    public void setCreater(Integer creater) {
        this.creater = creater;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_examine_category.create_time
     *
     * @return the value of crm_examine_category.create_time
     *
     * @mbg.generated Wed Oct 23 09:15:55 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_examine_category.create_time
     *
     * @param createTime the value for crm_examine_category.create_time
     *
     * @mbg.generated Wed Oct 23 09:15:55 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_examine_category.update_time
     *
     * @return the value of crm_examine_category.update_time
     *
     * @mbg.generated Wed Oct 23 09:15:55 CST 2019
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_examine_category.update_time
     *
     * @param updateTime the value for crm_examine_category.update_time
     *
     * @mbg.generated Wed Oct 23 09:15:55 CST 2019
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}