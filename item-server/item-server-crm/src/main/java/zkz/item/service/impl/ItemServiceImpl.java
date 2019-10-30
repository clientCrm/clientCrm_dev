package zkz.item.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zkz.item.mapper.IMemberMapper;
import zkz.item.mapper.ItemMapper;
import zkz.item.pojo.IMember;
import zkz.item.pojo.Item;
import zkz.item.pojo.PageResult;
import zkz.item.service.ItemService;
import zkz.item.util.Base;
import zkz.item.vo.ItemVo;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private IMemberMapper iMemberMapper;

    @Override
    public Item queryItemById(Integer id) {
        System.out.println("ItemServiceImpl.queryItemById==="+id);
        return itemMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Item> getByItemFinish(Integer itemFinish) {
        return itemMapper.getByItemFinish(itemFinish);
    }

    @Override
    public List<Object> getByIng(Integer itemFinish1, Integer itemFinish2, Integer sort) {
        List<Item> itemIngs=new ArrayList<>();      //正在进行的项目
        List<Item> itemDones=new ArrayList<>();     //已完成的项目
        List<Item> itemFiles=new ArrayList<>();     //已归档的项目
        List<Object> lists=new ArrayList<>();
        itemIngs =itemMapper.getByItemFinish(itemFinish1);
        itemDones =itemMapper.getByItemFinish(itemFinish2);
        itemFiles =itemMapper.getBySort(sort);
        lists.add(itemIngs);
        lists.add(itemDones);
        lists.add(itemFiles);
        return lists;
    }

    /*
    * 项目列表的分页展示
    * */
    @Override
    public PageResult getPageByExit(Integer sort, Integer type, Integer thisPage, Integer limit) {
        PageResult pageResult=new PageResult();
        List<ItemVo> itemVos=new ArrayList<>();

        if (thisPage==null||thisPage==0){
            thisPage=1;
        }
        if (limit==null||limit==0){
            limit=10;
        }

        int total=itemMapper.getTotalByExit(sort,type);
        pageResult.setTotal(total);
        pageResult.setTotalPage(total%limit==0?(total/limit):(total/limit+1));

        List<Item> items=itemMapper.getPageByExit(sort,type,(thisPage-1)*limit,limit);
        for(Item item : items){
            ItemVo itemVo=new ItemVo();
            List<IMember> iMembers=new ArrayList<>();

            int itemId=item.getItemId();
            iMembers=iMemberMapper.getByItemId(itemId);

            itemVo.setItem(item);
            itemVo.setItemMembers(iMembers);
            itemVos.add(itemVo);
        }
        pageResult.setItemVos(itemVos);

        return pageResult;
    }

    /*
     * 归档项目的分页展示
     * */
    @Override
    public PageResult getPageBySort(Integer sort,Integer thisPage,Integer limit) {
        PageResult pageResult=new PageResult();
        List<ItemVo> itemVos=new ArrayList<>();
        if (thisPage==null||thisPage==0){
            thisPage=1;
        }
        if (limit==null||limit==0){
            limit=10;
        }
        int total=itemMapper.getTotalBySort(sort);
        pageResult.setTotal(total);
        pageResult.setTotalPage(total%limit==0?(total/limit):(total/limit+1));

        List<Item> items=itemMapper.getPageBySort(sort,(thisPage-1)*limit,limit);
        for(Item item : items){
            ItemVo itemVo=new ItemVo();
            List<IMember> iMembers=new ArrayList<>();

            int itemId=item.getItemId();
            iMembers=iMemberMapper.getByItemId(itemId);

            itemVo.setItem(item);
            itemVo.setItemMembers(iMembers);
            itemVos.add(itemVo);
        }
        pageResult.setItemVos(itemVos);
        return pageResult;
    }

    @Override
    public int updateBySort(Integer itemId,Integer sort) {
        return itemMapper.updateBySort(itemId,sort);
    }

    @Override
    public List<Item> queryItem() {
        return itemMapper.queryItem(1,0);
    }

    @Override
    public Base addItem(ItemVo itemVo) {
        int id;
        Base base=new Base();
        Item item=new Item();
        List<IMember> iMembers=new ArrayList<>();
        item=itemVo.getItem();
        iMembers=itemVo.getItemMembers();

        //insert  item
        if(itemMapper.insert(item)<0){
            base.setMessage("新增项目失败");
            base.setResule(0);
            return base;
        }
        //获取插入数据自增的 ID 主键
        id=item.getItemId();
        for(IMember iMember:iMembers){
            iMember.setItemId(id);
            if (iMemberMapper.insert(iMember)<0){
                base.setResule(0);
                base.setMessage("添加成员失败");
                return base;
            }
        }
        base.setResule(1);
        base.setMessage("新增项目成功");
        return base;
    }
}
