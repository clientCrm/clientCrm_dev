package zkz.bangong.layui;

import java.io.Serializable;
import java.util.Date;

/*请假审批的前端显示类，里面包含了所有的请假表的公共字段*/
public class examineCommon implements Serializable {

    private Integer id;   //请假Id
    private String qingjiaType;//请假审批类型   病假 事假等
    private String examineType;//审批类型
    private String content ;//请假内容描述
    private Date startTime ;//开始时间
    private Date endTime ;//结束时间
    private Integer createrId;//创建者Id
    private Integer examinerId;//审核者ID
    private Date createTime;//创建时间
    private Date updateTime;//更新时间
    private String remarks;//备注
    private String imgAddr;//图片地址
    private Integer batchId;//附件 Id

    @Override
    public String toString() {
        return "examineCommon{" +
                "id=" + id +
                ", qingjiaType='" + qingjiaType + '\'' +
                ", examineType='" + examineType + '\'' +
                ", content='" + content + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", createrId=" + createrId +
                ", examinerId=" + examinerId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", remarks='" + remarks + '\'' +
                ", imgAddr='" + imgAddr + '\'' +
                ", batchId=" + batchId +
                '}';
    }

    public String getQingjiaType() {
        return qingjiaType;
    }

    public void setQingjiaType(String qingjiaType) {
        this.qingjiaType = qingjiaType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExamineType() {
        return examineType;
    }

    public void setExamineType(String examineType) {
        this.examineType = examineType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getCreaterId() {
        return createrId;
    }

    public void setCreaterId(Integer createrId) {
        this.createrId = createrId;
    }

    public Integer getExaminerId() {
        return examinerId;
    }

    public void setExaminerId(Integer examinerId) {
        this.examinerId = examinerId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getImgAddr() {
        return imgAddr;
    }

    public void setImgAddr(String imgAddr) {
        this.imgAddr = imgAddr;
    }

    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
    }
}
