package zkz.bangong.layui;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.Date;

/*所有请假表需要的字段都有*/
public class examineAllLayui implements Serializable {


    private Integer examineId;   //请假Id
    private String qingjiaType;//请假审批类型   病假 事假等
    private String examineType;//审批类型
    private String content ;//请假内容描述
    private Date startTime ;//开始时间
    private Date endTime ;//结束时间
    private Integer creater;//创建者Id
    private String examinerName;//审核者名字
    private Date createTime;//创建时间
    private Date updateTime;//更新时间
    private String remarks;//备注
    private MultipartFile img;//图片
    private MultipartFile batch;//附件

    private  String vehicle;//交通工具类型
    private String oneRound;//单程往返
    private String startCity;//出发城市
    private String toCity;//目的城市
    private String tripRemarks ;//行程备注
    private Integer totalDay;//出差总天数

    private Double fare;//交通费用
    private Double liveMoney;//住宿费用
    private Double otherMoney;//其他费用
    private Double foodMoney;//餐饮费用
    private String otherContent;//其他费用描述
    private Double totalMoney;//总计金额

    @Override
    public String toString() {
        return "examineAllLayui{" +
                "examineId=" + examineId +
                ", qingjiaType='" + qingjiaType + '\'' +
                ", examineType='" + examineType + '\'' +
                ", content='" + content + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", creater=" + creater +
                ", examinerName='" + examinerName + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", remarks='" + remarks + '\'' +
                ", img=" + img +
                ", batch=" + batch +
                ", vehicle='" + vehicle + '\'' +
                ", oneRound='" + oneRound + '\'' +
                ", startCity='" + startCity + '\'' +
                ", toCity='" + toCity + '\'' +
                ", tripRemarks='" + tripRemarks + '\'' +
                ", totalDay=" + totalDay +
                ", fare=" + fare +
                ", liveMoney=" + liveMoney +
                ", otherMoney=" + otherMoney +
                ", foodMoney=" + foodMoney +
                ", otherContent='" + otherContent + '\'' +
                ", totalMoney=" + totalMoney +
                '}';
    }


    public Integer getExamineId() {
        return examineId;
    }

    public void setExamineId(Integer examineId) {
        this.examineId = examineId;
    }

    public String getQingjiaType() {
        return qingjiaType;
    }

    public void setQingjiaType(String qingjiaType) {
        this.qingjiaType = qingjiaType;
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

    public Integer getCreater() {
        return creater;
    }

    public void setCreater(Integer creater) {
        this.creater = creater;
    }

    public String getExaminerName() {
        return examinerName;
    }

    public void setExaminerName(String examinerName) {
        this.examinerName = examinerName;
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

    public MultipartFile getImg() {
        return img;
    }

    public void setImg(MultipartFile img) {
        this.img = img;
    }

    public MultipartFile getBatch() {
        return batch;
    }

    public void setBatch(MultipartFile batch) {
        this.batch = batch;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getOneRound() {
        return oneRound;
    }

    public void setOneRound(String oneRound) {
        this.oneRound = oneRound;
    }

    public String getStartCity() {
        return startCity;
    }

    public void setStartCity(String startCity) {
        this.startCity = startCity;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public String getTripRemarks() {
        return tripRemarks;
    }

    public void setTripRemarks(String tripRemarks) {
        this.tripRemarks = tripRemarks;
    }

    public Integer getTotalDay() {
        return totalDay;
    }

    public void setTotalDay(Integer totalDay) {
        this.totalDay = totalDay;
    }

    public Double getFare() {
        return fare;
    }

    public void setFare(Double fare) {
        this.fare = fare;
    }

    public Double getLiveMoney() {
        return liveMoney;
    }

    public void setLiveMoney(Double liveMoney) {
        this.liveMoney = liveMoney;
    }

    public Double getOtherMoney() {
        return otherMoney;
    }

    public void setOtherMoney(Double otherMoney) {
        this.otherMoney = otherMoney;
    }

    public Double getFoodMoney() {
        return foodMoney;
    }

    public void setFoodMoney(Double foodMoney) {
        this.foodMoney = foodMoney;
    }

    public String getOtherContent() {
        return otherContent;
    }

    public void setOtherContent(String otherContent) {
        this.otherContent = otherContent;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }
}
