package zkz.item.util;

public class Paging {
    public void init(Integer thisPage,Integer limit){
        if (thisPage==null||thisPage==0){
        thisPage=1;
    }
        if (limit==null||limit==0){
        limit=10;
    }
}
}
