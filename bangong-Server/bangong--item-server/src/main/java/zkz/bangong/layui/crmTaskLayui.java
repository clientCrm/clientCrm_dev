package zkz.bangong.layui;

import java.io.Serializable;
import java.util.Date;

public class crmTaskLayui implements Serializable {


    private Integer taskId;

    private String taskName;

    private Integer createUserId;


    private String mainUserId;


    private String ownerUserId;


    private Date createTime;

    private Date updateTime;

    private Integer status;

    private String labelId;

    private Integer pid;

    private Date startTime;

    private Date stopTime;

    private String priority;


    private Integer workId;


    private Integer isTop;


    private Integer isOpen;

    private Date archiveTime;

    private Integer ishidden;


    private Date hiddenTime;


    private String batchId;


    private Integer isArchive;

    private String description;

    @Override
    public String toString() {
        return "crmTaskLayui{" +
                "taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                ", createUserId='" + createUserId + '\'' +
                ", mainUserId='" + mainUserId + '\'' +
                ", ownerUserId='" + ownerUserId + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", status=" + status +
                ", labelId='" + labelId + '\'' +
                ", pid=" + pid +
                ", startTime=" + startTime +
                ", stopTime=" + stopTime +
                ", priority='" + priority + '\'' +
                ", workId=" + workId +
                ", isTop=" + isTop +
                ", isOpen=" + isOpen +
                ", archiveTime=" + archiveTime +
                ", ishidden=" + ishidden +
                ", hiddenTime=" + hiddenTime +
                ", batchId='" + batchId + '\'' +
                ", isArchive=" + isArchive +
                ", description='" + description + '\'' +
                '}';
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public String getMainUserId() {
        return mainUserId;
    }

    public void setMainUserId(String mainUserId) {
        this.mainUserId = mainUserId;
    }

    public String getOwnerUserId() {
        return ownerUserId;
    }

    public void setOwnerUserId(String ownerUserId) {
        this.ownerUserId = ownerUserId;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getLabelId() {
        return labelId;
    }

    public void setLabelId(String labelId) {
        this.labelId = labelId;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getStopTime() {
        return stopTime;
    }

    public void setStopTime(Date stopTime) {
        this.stopTime = stopTime;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Integer getWorkId() {
        return workId;
    }

    public void setWorkId(Integer workId) {
        this.workId = workId;
    }

    public Integer getIsTop() {
        return isTop;
    }

    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }

    public Integer getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Integer isOpen) {
        this.isOpen = isOpen;
    }

    public Date getArchiveTime() {
        return archiveTime;
    }

    public void setArchiveTime(Date archiveTime) {
        this.archiveTime = archiveTime;
    }

    public Integer getIshidden() {
        return ishidden;
    }

    public void setIshidden(Integer ishidden) {
        this.ishidden = ishidden;
    }

    public Date getHiddenTime() {
        return hiddenTime;
    }

    public void setHiddenTime(Date hiddenTime) {
        this.hiddenTime = hiddenTime;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public Integer getIsArchive() {
        return isArchive;
    }

    public void setIsArchive(Integer isArchive) {
        this.isArchive = isArchive;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
