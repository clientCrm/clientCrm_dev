package zkz.bangong.common;

/**
 * 状态枚举类
 * @author zeroone
 * @since 2019/3/29
 */
public enum AdoptAnimalStatus {

    DISADPOT(0, "未被领养"), ISADOPT(1, "被领养"), DELETE(2, "删除");

    private int num;
    private String statusName;

    AdoptAnimalStatus(int num, String statusName) {
        this.num = num;
        this.statusName = statusName;
    }

    public static AdoptAnimalStatus getByNum(int num) {
        for(AdoptAnimalStatus _enum : AdoptAnimalStatus.class.getEnumConstants())
            if(_enum.getNum() == num)
                return _enum;
        return null;
    }

    public static AdoptAnimalStatus getByStatusName(String statusName) {
        for(AdoptAnimalStatus _enum : AdoptAnimalStatus.class.getEnumConstants())
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