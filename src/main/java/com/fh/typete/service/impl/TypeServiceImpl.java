package com.fh.typete.service.impl;

import com.fh.typete.dao.*;
import com.fh.typete.model.*;
import com.fh.typete.service.TypeService;
import com.fh.typete.vo.BrandVo;
import com.fh.typete.vo.GoodsVo;
import com.fh.typete.vo.ProVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TypeServiceImpl implements TypeService {
    @Resource
    private TypeDao td;
    @Resource
    private BrandDao bd;
    @Resource
    private ProDao pd;
    @Resource
    private ProValueDao pvd;
    @Resource
    private GoodsDao gd;
    @Override
    public List<Types> cha() {
        List<Types> li=td.cha();
        return li;
    }

    @Override
    public List<Types> chaByPid(Integer pid) {
        List<Types> li=td.chaByPid(pid);
        return li;
    }

    @Override
    public Integer addType(Types ty) {
        Integer ida=td.addType(ty);
        return ida;
    }

    @Override
    public void upType(Types ty) {
        td.upType(ty);
    }

    @Override
    public Map chaBrand(BrandVo bv) {
        bv.setStartIndex((bv.getPage()-1)*bv.getLimit());
        Map map=new HashMap();
        map.put("count",bd.chaCount(bv));
        map.put("data",bd.chaBrand(bv));
        return map;
    }

    @Override
    public void addBrand(Brand br) {
        bd.addBrand(br);
    }

    @Override
    public void upBrand(Brand br) {
        bd.upBrand(br);
    }

    @Override
    public Map chaPro(ProVo pv) {
        pv.setStartIndex((pv.getPage()-1)*pv.getLimit());
        Map map=new HashMap();
        map.put("count",pd.chaCount(pv));
        map.put("data",pd.chaPro(pv));
        return map;
    }

    @Override
    public void addPro(Propertys pro) {
        pd.addPro(pro);
    }

    @Override
    public void upPro(Propertys pro) {
        pd.upPro(pro);
    }

    @Override
    public List<ProValue> chaProValue(Integer id) {
        List<ProValue> li=pvd.chaProValue(id);
        return li;
    }

    @Override
    public void addProValue(ProValue pv) {
        pvd.addProValue(pv);
    }

    @Override
    public void upProValue(ProValue pv) {
        pvd.upProValue(pv);
    }

    @Override
    public void addGoods(Goods goods) {
        gd.addGoods(goods);
    }

    @Override
    public List<Propertys> chaProByTypeid(Integer typeid) {
        List<Propertys> li=pd.chaProByTypeid(typeid);
        return li;
    }

    @Override
    public Map chaGoods(GoodsVo gv) {
        gv.setStartIndex((gv.getPage()-1)*gv.getLimit());
        Map map = new HashMap();
        map.put("count",gd.chaCount(gv));
        map.put("data",gd.chaGoods(gv));
        return map;
    }

    @Override
    public void upGoods(Goods goods) {
        gd.upGoods(goods);
    }

    @Override
    public void delGoods(Goods goods) {
        gd.delGoods(goods);
    }
}
