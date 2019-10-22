package zkz.bangong.common;

import java.io.Serializable;

public class crmTaskMonAndDay implements Serializable {

    private Integer mongth;
    private Integer day;

    public crmTaskMonAndDay(Integer mongth, Integer day) {
        this.mongth = mongth;
        this.day = day;
    }

    public Integer getMongth() {
        return mongth;
    }

    public void setMongth(Integer mongth) {
        this.mongth = mongth;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }
}
