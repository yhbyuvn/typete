package com.fh.typete.service;

import com.fh.typete.model.Brand;
import com.fh.typete.model.Types;
import com.fh.typete.vo.BrandVo;

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
}
