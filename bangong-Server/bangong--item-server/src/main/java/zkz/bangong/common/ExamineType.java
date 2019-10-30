package zkz.bangong.common;

public enum ExamineType {
    /*审批类型*/

    PUTONG(1, "普通审批"), QINGJIA(2, "请假审批"), CHUCHAI(3, "出差审批"),JIABAN(4,"加班审批"),CHAILV(5,"差旅报销");

    private int num;
    private String statusName;

    ExamineType(int num, String statusName) {
        this.num = num;
        this.statusName = statusName;
    }

    public static ExamineType getByNum(int num) {
        for(ExamineType _enum : ExamineType.class.getEnumConstants())
            if(_enum.getNum() == num)
                return _enum;
        return null;
    }

    public static ExamineType getByStatusName(String statusName) {
        for(ExamineType _enum : ExamineType.class.getEnumConstants())
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
