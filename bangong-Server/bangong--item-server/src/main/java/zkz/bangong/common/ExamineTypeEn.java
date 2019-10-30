package zkz.bangong.common;

public enum  ExamineTypeEn {
    /*审批类型*/
    PUTONG("crm_putong_examine", "普通审批"),
    QINGJIA("crm_qingjia_examine", "请假审批"),
    CHUCHAI("crm_chuchai_examine", "出差审批"),
    JIABAN("crm_jiaban_examine","加班审批"),
    CHAILV("crm_chailv_examine","差旅报销");



    private String num;
    private String statusName;

    ExamineTypeEn(String num, String statusName) {
        this.num = num;
        this.statusName = statusName;
    }

    public static ExamineTypeEn getByNum(String num) {
        for(ExamineTypeEn _enum : ExamineTypeEn.class.getEnumConstants())
            if(_enum.getNum() == num)
                return _enum;
        return null;
    }

    public static ExamineTypeEn getByStatusName(String statusName) {
        for(ExamineTypeEn _enum : ExamineTypeEn.class.getEnumConstants())
            if(_enum.getStatusName().equals(statusName))
                return _enum;
        return null;
    }

    public String getNum() {
        return num;
    }

    public String getStatusName() {
        return statusName;
    }



}
