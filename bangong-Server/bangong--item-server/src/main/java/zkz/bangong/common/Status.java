package zkz.bangong.common;

/**
 * 状态枚举类
 * @author mmmgdzl
 * @since 2019/3/28
 */
public enum Status {

    DISABLE(0, "不可用"), ACTIVE(1, "可用"), DELETE(2, "删除");

    private int num;
    private String statusName;

    Status(int num, String statusName) {
        this.num = num;
        this.statusName = statusName;
    }

    public static Status getByNum(int num) {
        for(Status _enum : Status.class.getEnumConstants())
            if(_enum.getNum() == num)
                return _enum;
        return null;
    }

    public static Status getByStatusName(String statusName) {
        for(Status _enum : Status.class.getEnumConstants())
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