package com.fh.typete.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fh.typete.dao.*;
import com.fh.typete.model.*;
import com.fh.typete.service.TypeService;
import com.fh.typete.vo.BrandVo;
import com.fh.typete.vo.GoodsVo;
import com.fh.typete.vo.ProVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
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
    @Resource
    private GoodsValueDao gvd;
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
    @Transactional
    public void addGoods(Goods goods,String pro,String sku) {
        gd.addGoods(goods);
        Integer id=goods.getId();
        List<GoodsValue> li=new ArrayList<>();
        JSONArray objects = JSONObject.parseArray(pro);
        for (int i = 0; i <objects.size() ; i++) {
            GoodsValue gv=new GoodsValue();
            gv.setGoodid(id);
            gv.setGoodvalue(objects.get(i).toString());
            li.add(gv);
        }
        JSONArray objects1 = JSONObject.parseArray(sku);
        for (int i = 0; i <objects1.size() ; i++) {
            JSONObject data = (JSONObject) objects1.get(i);
            GoodsValue gv=new GoodsValue();
            gv.setGoodid(id);
            gv.setPrice(data.getDouble("price"));
            gv.setStorcks(data.getInteger("storcks"));
            data.remove("price");
            data.remove("storcks");
            gv.setGoodvalue(objects1.get(i).toString());
            li.add(gv);

        }
        gvd.adds(li);
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

    @Override
    public List<GoodsValue> chaGoodsValue(Integer goodid) {
        List<GoodsValue> li=gvd.chaGoodsValue(goodid);
        return li;
    }

    @Override
    public void upGoodsValue(Integer goodid, String pros, String sku) {
        gvd.delgv(goodid);
        List<GoodsValue> li=new ArrayList<>();
        JSONArray objects = JSONObject.parseArray(pros);
        for (int i = 0; i <objects.size() ; i++) {
            GoodsValue gv=new GoodsValue();
            gv.setGoodid(goodid);
            gv.setGoodvalue(objects.get(i).toString());
            li.add(gv);
        }
        JSONArray objects1 = JSONObject.parseArray(sku);
        for (int i = 0; i <objects1.size() ; i++) {
            JSONObject data = (JSONObject) objects1.get(i);
            GoodsValue gv=new GoodsValue();
            gv.setGoodid(goodid);
            gv.setPrice(data.getDouble("price"));
            gv.setStorcks(data.getInteger("storcks"));
            data.remove("price");
            data.remove("storcks");
            gv.setGoodvalue(objects1.get(i).toString());
            li.add(gv);

        }
        gvd.adds(li);
    }

    @Override
    public List<Propertys> chaProByType(Integer type) {
        List<Propertys> li=pd.chaProByType(type);
        return li;
    }

    @Override
    public Map chaProValueByTypeid(Integer typeid) {
        Map map=new HashMap();
        List<Propertys> li=pd.chaProByTypeid(typeid);
        List<Propertys> skuData=new ArrayList<>();
        List<Propertys> proData=new ArrayList<>();
        for (int i = 0; i <li.size() ; i++) {
            Propertys pp=li.get(i);
            if (pp.getIssku()==0){
                if (pp.getType()!=0){
                    List<ProValue> proli=pvd.chaProValue(pp.getId());
                    pp.setValues(proli);
                }
                proData.add(pp);
            }else {
                if (pp.getType()!=0){
                    List<ProValue> skuli=pvd.chaProValue(pp.getId());
                    pp.setValues(skuli);
                }
                skuData.add(pp);
            }
        }
        map.put("proData",proData);
        map.put("skuData",skuData);
        return map;
    }
}
