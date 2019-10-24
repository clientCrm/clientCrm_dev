package zkz.bangong.layui;

import java.io.Serializable;

public class chaiLvEmanineLayui implements Serializable {

    private examineCommon examineCommon;
    private String startCity;//出发城市
    private String toCity;//到达城市
    private Double fare;//交通费用
    private Double liveMoney;//住宿费用
    private Double otherMoney;//其他费用
    private Double foodMoney;//餐饮费用
    private String otherContent;//其他费用描述
    private Double totalMoney;//总计金额


    @Override
    public String toString() {
        return "chaiLvEmanineLayui{" +
                "examineCommon=" + examineCommon +
                ", startCity='" + startCity + '\'' +
                ", toCity='" + toCity + '\'' +
                ", fare=" + fare +
                ", liveMoney=" + liveMoney +
                ", otherMoney=" + otherMoney +
                ", foodMoney=" + foodMoney +
                ", otherContent='" + otherContent + '\'' +
                ", totalMoney=" + totalMoney +
                '}';
    }

    public zkz.bangong.layui.examineCommon getExamineCommon() {
        return examineCommon;
    }

    public void setExamineCommon(zkz.bangong.layui.examineCommon examineCommon) {
        this.examineCommon = examineCommon;
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
