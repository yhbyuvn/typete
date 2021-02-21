package com.fh.typete.dao;

import com.fh.typete.model.Propertys;
import com.fh.typete.vo.ProVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ProDao {
    @Select("<script>" +
            "select count(*) from ts_pro where 1=1 and isdel=0" +
            "<if test='name!=null and name!=&quot;&quot;'> and name like CONCAT('%',#{name},'%')</if>" +
            "</script>")
    Long chaCount(ProVo pv);
    @Select("<script>" +
            "select * from ts_pro where 1=1 and isdel=0" +
            "<if test='name!=null and name!=&quot;&quot;'> and name like CONCAT('%',#{name},'%')</if>" +
            " limit #{startIndex},#{limit}" +
            "</script>")
    List<Propertys> chaPro(ProVo pv);
    @Insert("insert into ts_pro(name,namech,typeid,type,issku,isdel,createdate,updatedate,author) value(#{name},#{namech},#{typeid},#{type},#{issku},#{isdel},#{createdate},#{updatedate},#{author})")
    void addPro(Propertys pro);
    @Update("update ts_pro set name=#{name},namech=#{namech},typeid=#{typeid},type=#{type},issku=#{issku},isdel=#{isdel},updateDate=#{updatedate},author=#{author} where id=#{id}")
    void upPro(Propertys pro);
    @Select("select * from ts_pro where typeid=#{typeid} and isdel=0")
    List<Propertys> chaProByTypeid(Integer typeid);
    @Select("select * from ts_pro where type=#{type} and isdel=0")
    List<Propertys> chaProByType(Integer type);
}
