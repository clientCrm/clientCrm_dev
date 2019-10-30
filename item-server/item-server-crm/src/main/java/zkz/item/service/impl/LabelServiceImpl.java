package zkz.item.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import zkz.item.mapper.LabelMapper;
import zkz.item.pojo.Label;
import zkz.item.pojo.PageResult;
import zkz.item.service.LabelService;

import java.util.List;

@Service
public class LabelServiceImpl implements LabelService {
    @Autowired
    private LabelMapper labelMapper;

    @Override
    public int getTotal() {
        return labelMapper.getTotal();
    }

    @Override
    public PageResult getByPaging(Integer thisPage, Integer limit) {

        PageResult pageResult=new PageResult();
        if (thisPage==null||thisPage==0){
            thisPage=1;
        }
        if (limit==null||limit==0){
            limit=10;
        }

        int total=labelMapper.getTotal();
        pageResult.setTotal(total);
        pageResult.setTotalPage(total%limit==0?(total/limit):(total/limit+1));
        pageResult.setItems(labelMapper.getByThisPage((thisPage-1)*limit,limit));
        return pageResult;

    }

    @Override
    public List<Label> getByThisPage(Integer thisPage, Integer limit) {
        if (thisPage==null||thisPage==0){
            thisPage=1;
        }
        if (limit==null||limit==0){
            limit=10;
        }
        System.out.println(thisPage+"         "+limit);
        return labelMapper.getByThisPage((thisPage-1)*limit,limit);
    }

}
