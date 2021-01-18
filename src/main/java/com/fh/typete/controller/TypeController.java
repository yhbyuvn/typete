package com.fh.typete.controller;

import com.fh.typete.model.*;
import com.fh.typete.service.TypeService;
import com.fh.typete.utils.Ud;
import com.fh.typete.vo.BrandVo;
import com.fh.typete.vo.ProVo;
import com.fh.typete.vo.RespData;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;

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
    /*
    * 接口文档
    *请求路径：http://localhost:8080/api/type/chaBrand
    * 方式：post
    * 参数：page(数据类型：Integer 当前页 必填项) limit（数据类型：Integer 每页条数 必填项） name（数据类型：String 名称）
    *返回值：code 200 正常 400 数据错误 info：提示信息
    *data :数据
        取条数：dd.data.data.count
        取全部数据：dd.data.data
    * */
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
    /*
     * 请求路径：http://localhost:8080/api/type/addBrand
     * 参数：name（数据类型：String 名称 必填）
     * 返回值 null
     * */
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
    /*
     * 请求路径：http://localhost:8080/api/type/upBrand
     * 参数：无
     * 返回值 null
     *      * 逻辑删除使用此接口
     * 注意传值，全部都要传，isdel为0
     * */
    @PostMapping("upBrand")
    public RespData upBrand(Brand br){
        br.setAuthor("齐静春");
        br.setUpdatedate(new Date());
        ts.upBrand(br);
        return RespData.success(null);
    }
    /*
         * 请求路径：http://localhost:8080/api/type/upload
         * 参数：imgpath(数据类型：String 图片名称 必填)
         * 返回值  dd.data.filePath
         * fileName: "-d4d92f16d3885cc.jpg",
           filePath: "images/b1d2de62-261c-4a7c-b264-090cafa15666.jpg"
         * */
    @PostMapping("upload")
    public RespData upload(MultipartFile imgpath) throws IOException {
        String ofname = imgpath.getOriginalFilename();
        String newName= UUID.randomUUID().toString()+ofname.substring(ofname.lastIndexOf("."));
        newName="image/"+newName;
        String uplfile = Ud.uplfile(imgpath.getInputStream(), newName);
        return RespData.success(uplfile);
    }
    /*
   * 接口文档
   *请求路径：http://localhost:8080/api/type/chaPro
   * 方式：post
   * 参数：page(数据类型：Integer 当前页 必填项) limit（数据类型：Integer 每页条数 必填项） name（数据类型：String 名称）
   *返回值：code 200 正常 400 数据错误 info：提示信息
   *data :数据
       取条数：dd.data.data.count
       取全部数据：dd.data.data
   * */
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
    /*
     * 请求路径：http://localhost:8080/api/type/addPro
     * 参数：name（数据类型：String 名称 必填）
     * 返回值 null
     * */
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
    /*
     * 请求路径：http://localhost:8080/api/type/upPro
     * 参数：无
     * 返回值 null
     *      * 逻辑删除使用此接口
     * 注意传值，全部都要传，isdel为0
     * */
    @PostMapping("upPro")
    public RespData upPro(Propertys pro){
        pro.setAuthor("齐静春");
        pro.setUpdatedate(new Date());
        ts.upPro(pro);
        return RespData.success(null);
    }
    /*
  * 接口文档
  * 查属性值
  *请求路径：http://localhost:8080/api/type/chaProValue
  * 方式：post
  * 参数：proid(数据类型：Integer  必填项)
  *返回值：code 200 正常  info：提示信息
  *data :数据
      取全部数据：dd.data.data
  * */
    @PostMapping("chaProValue")
    public RespData chaProValue(Integer proid){
        List<ProValue> li=ts.chaProValue(proid);
        return RespData.success(li);
    }
    /*新增属性值
     * 请求路径：http://localhost:8080/api/type/addProValue
     * 参数：无
     * 返回值 null
     * */
    @PostMapping("addProValue")
    public RespData addProValue(ProValue pv){
        ts.addProValue(pv);
        return RespData.success(null);
    }
    /*修改属性值
     * 请求路径：http://localhost:8080/api/type/upProValue
     * 参数：无
     * 返回值 null
     * 逻辑删除使用此接口
     * 注意传值，全部都要传，isdel为0
     * */
    @PostMapping("upProValue")
    public RespData upProValue(ProValue pv){
        ts.upProValue(pv);
        return RespData.success(null);
    }
    /*新增商品
     * 请求路径：http://localhost:8080/api/type/addGoods
     * 参数：无
     * 返回值 null
     * */
    @PostMapping("addGoods")
    public RespData addGoods(Goods goods){
        goods.setAuthor("齐静春");
        goods.setCreatedate(new Date());
        goods.setIsdel(0);
        ts.addGoods(goods);
        return RespData.success(null);
    }
}
