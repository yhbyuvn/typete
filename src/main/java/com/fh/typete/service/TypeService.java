package com.fh.typete.service;

import com.fh.typete.model.*;
import com.fh.typete.vo.BrandVo;
import com.fh.typete.vo.GoodsVo;
import com.fh.typete.vo.ProVo;

import java.util.List;
import java.util.Map;

public interface TypeService {
    List<Types> cha();

    List<Types> chaByPid(Integer pid);

    Integer addType(Types ty);

    void upType(Types ty);

    Map chaBrand(BrandVo bv);

    void addBrand(Brand br);

    void upBrand(Brand br);

    Map chaPro(ProVo pv);

    void addPro(Propertys pro);

    void upPro(Propertys pro);

    List<ProValue> chaProValue(Integer id);

    void addProValue(ProValue pv);

    void upProValue(ProValue pv);

    void addGoods(Goods goods,String pro,String sku);

    List<Propertys> chaProByTypeid(Integer typeid);

    Map chaGoods(GoodsVo gv);

    void upGoods(Goods goods);

    void delGoods(Goods goods);
}
