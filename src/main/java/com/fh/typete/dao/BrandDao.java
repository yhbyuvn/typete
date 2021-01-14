package com.fh.typete.dao;

import com.fh.typete.model.Brand;
import com.fh.typete.vo.BrandVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BrandDao {
    @Select("<script>" +
            "select count(*) from ts_brand where 1=1 and isdel=0" +
            "<if test='name!=null and name!=&quot;&quot;'> and name like CONCAT('%',#{name},'%')</if>" +
            "</script>")
    Long chaCount(BrandVo bv);
    @Select("<script>" +
            "select * from ts_brand where 1=1 and isdel=0" +
            "<if test='name!=null and name!=&quot;&quot;'> and name like CONCAT('%',#{name},'%')</if>" +
            " order by ord limit #{startIndex},#{limit}" +
            "</script>")
    List<Brand> chaBrand(BrandVo bv);
    @Insert("insert into ts_brand(name,bande,imgpath,banddesc,ord,isdel,createdate,updatedate,author) value(#{name},#{bande},#{imgpath},#{banddesc},#{ord},#{isdel},#{createdate},#{updatedate},#{author})")
    void addBrand(Brand br);
    @Update("update ts_brand set name=#{name},bande=#{bande},imgpath=#{imgpath},banddesc=#{banddesc},ord=#{ord},isdel=#{isdel},updateDate=#{updatedate},author=#{author} where id=#{id}")
    void upBrand(Brand br);
}
