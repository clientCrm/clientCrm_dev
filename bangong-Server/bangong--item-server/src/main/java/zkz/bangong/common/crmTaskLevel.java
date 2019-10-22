package zkz.bangong.common;

 /**
  * @author : zkz
  * @date : 2019/10/21 15:53
  * @descript :  任务表优先级枚举类
 */

public enum crmTaskLevel {
     ZERO(0, "无"), LOW(1, "低"), MEDIUM(2, "中"),HIGH(3,"高"),ALL(4,"全部");

     private int num;
     private String statusName;

     crmTaskLevel(int num, String statusName) {
         this.num = num;
         this.statusName = statusName;
     }

     public static crmTaskLevel getByNum(int num) {
         for(crmTaskLevel _enum : crmTaskLevel.class.getEnumConstants())
             if(_enum.getNum() == num)
                 return _enum;
         return null;
     }

     public static crmTaskLevel getByStatusName(String statusName) {
         for(crmTaskLevel _enum : crmTaskLevel.class.getEnumConstants())
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
