package zkz.bangong.common;

public enum crmTaskEndTime {
    TODAY(0,"今天到期"), TOMORROW(1,"明天到期"), WEEK( 7,"一周到期"),MONTH(31,"一个月到期");

    private int num;
    private String statusName;

    crmTaskEndTime(int num, String statusName) {
        this.num = num;
        this.statusName = statusName;
    }

    public static crmTaskEndTime getByNum(int num) {
        for(crmTaskEndTime _enum : crmTaskEndTime.class.getEnumConstants())
            if(_enum.getNum() == num)
                return _enum;
        return null;
    }

    public static crmTaskEndTime getByStatusName(String statusName) {
        for(crmTaskEndTime _enum : crmTaskEndTime.class.getEnumConstants())
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
