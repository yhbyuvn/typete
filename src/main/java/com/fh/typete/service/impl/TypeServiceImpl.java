package com.fh.typete.service.impl;

import com.fh.typete.dao.BrandDao;
import com.fh.typete.dao.ProDao;
import com.fh.typete.dao.TypeDao;
import com.fh.typete.model.Brand;
import com.fh.typete.model.Propertys;
import com.fh.typete.model.Types;
import com.fh.typete.service.TypeService;
import com.fh.typete.vo.BrandVo;
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
}
