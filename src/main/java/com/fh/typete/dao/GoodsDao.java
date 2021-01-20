package com.fh.typete.dao;

import com.fh.typete.model.Goods;
import com.fh.typete.vo.GoodsVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface GoodsDao {
    @Insert("insert into ts_goods(name,title,brandid,productdecs,price,stocks,sortnum,isdel,createdate,updatedate,author,imgpath,typeid) value(#{name},#{title},#{brandid},#{productdecs},#{price},#{stocks},#{sortnum},#{isdel},#{createdate},#{updatedate},#{author},#{imgpath},#{typeid})")
    void addGoods(Goods goods);
    @Select("<script>" +
            "select count(*) from ts_goods where 1=1 and isdel=0" +
            "</script>")
    Long chaCount(GoodsVo gv);
    @Select("<script>" +
            "select * from ts_goods where 1=1 and isdel=0" +
            " limit #{startIndex},#{limit}" +
            "</script>")
    List<Goods> chaGoods(GoodsVo gv);
    @Update("update ts_goods set name=#{name},title=#{title},brandid=#{brandid},productdecs=#{productdecs},price=#{price},stocks=#{stocks},sortnum=#{sortnum},isdel=#{isdel},updatedate=#{updatedate},author=#{author},imgpath=#{imgpath},typeid=#{typeid} where id=#{id}")
    void upGoods(Goods goods);
    @Update("update ts_goods set isdel=#{isdel},updatedate=#{updatedate},author=#{author} where id=#{id}")
    void delGoods(Goods goods);
}
