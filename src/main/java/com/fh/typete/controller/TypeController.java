package com.fh.typete.controller;

import com.fh.typete.model.Brand;
import com.fh.typete.model.Propertys;
import com.fh.typete.model.Types;
import com.fh.typete.service.TypeService;
import com.fh.typete.utils.Ud;
import com.fh.typete.vo.BrandVo;
import com.fh.typete.vo.ProVo;
import com.fh.typete.vo.RespData;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("api/type")
public class TypeController {
    @Resource
    private TypeService ts;
    @GetMapping("getData")
    public RespData cha(){
        List<Types> li=ts.cha();
        return RespData.success(li);
    }
    @GetMapping("getDataByPid")
    public RespData chaByPid(Integer pid){
        List<Types> li=ts.chaByPid(pid);
        return RespData.success(li);
    }
    @PostMapping("add")
    public RespData addType(Types ty){
        ty.setCreatedate(new Date());
        ty.setIsdel(0);
        ty.setWhodid("齐静春");
        Integer ida=ts.addType(ty);
        return RespData.success(ida);
    }
    @PostMapping("update")
    public RespData upType(Types ty){
        ty.setWhodid("齐静春");
        ty.setUpdatedate(new Date());
        ts.upType(ty);
        return RespData.success(null);
    }
    @PostMapping("chaBrand")
    public RespData chaBrand(BrandVo bv){
        if (bv.getPage()==null){
            return RespData.error(400,"关键数据缺失");
        }
        if (bv.getLimit()==null){
            return RespData.error(400,"关键数据缺失");
        }
        Map map=ts.chaBrand(bv);
        return RespData.success(map);
    }
    @PostMapping("addBrand")
    public RespData addBrand(Brand br){
        if (br.getName()==null){
                return RespData.error(400,"关键数据缺失");
        }
        br.setAuthor("齐静春");
        br.setIsdel(0);
        br.setCreatedate(new Date());
        ts.addBrand(br);
        return RespData.success(null);
    }
    @PostMapping("upBrand")
    public RespData upBrand(Brand br){
        br.setAuthor("齐静春");
        br.setUpdatedate(new Date());
        ts.upBrand(br);
        return RespData.success(null);
    }
    @PostMapping("upload")
    public RespData upload(MultipartFile imgpath, HttpServletRequest request){
        Map<String, String> images = Ud.ul(imgpath, request, "images");
        return RespData.success(images);
    }
    @PostMapping("chaPro")
    public RespData chaPro(ProVo pv){
        if (pv.getPage()==null){
            return RespData.error(400,"关键数据缺失");
        }
        if (pv.getLimit()==null){
            return RespData.error(400,"关键数据缺失");
        }
        Map map=ts.chaPro(pv);
        return RespData.success(map);
    }
    @PostMapping("addPro")
    public RespData addPro(Propertys pro){
        if (pro.getName()==null){
            return RespData.error(400,"关键数据缺失");
        }
        pro.setAuthor("齐静春");
        pro.setIsdel(0);
        pro.setCreatedate(new Date());
        ts.addPro(pro);
        return RespData.success(null);
    }
}
