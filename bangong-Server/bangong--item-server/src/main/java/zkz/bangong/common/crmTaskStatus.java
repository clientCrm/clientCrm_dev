package zkz.bangong.common;

 /**
  * @author : zkz
  * @date : 2019/10/21 15:18
  * @descript :任务状态枚举类
 */

public enum crmTaskStatus {
/*完成状态 1正在进行2延期3完成 4结束*/
    ISON(1, "正在进行"), ADDTIME(2, "延期"), FINISH(3, "已完成"),END(4,"结束"),ALL(5,"全部");

    private int num;
    private String statusName;

    crmTaskStatus(int num, String statusName) {
        this.num = num;
        this.statusName = statusName;
    }

    public static crmTaskStatus getByNum(int num) {
        for(crmTaskStatus _enum : crmTaskStatus.class.getEnumConstants())
            if(_enum.getNum() == num)
                return _enum;
        return null;
    }

    public static crmTaskStatus getByStatusName(String statusName) {
        for(crmTaskStatus _enum : crmTaskStatus.class.getEnumConstants())
            if(_enum.getStatusName().equals(statusName))
                return _enum;
        return null;
    }

    public int getNum() {
        return num;
    }

    public String getStatusName() {
        return statusName;
    }


}
