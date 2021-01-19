package com.fh.typete.dao;

import com.fh.typete.model.Goods;
import org.apache.ibatis.annotations.Insert;

public interface GoodsDao {
    @Insert("insert into ts_goods(name,title,brandid,productdecs,price,stocks,sortnum,isdel,createdate,updatedate,author,imgpath,typeid) value(#{name},#{title},#{brandid},#{productdecs},#{price},#{stocks},#{sortnum},#{isdel},#{createdate},#{updatedate},#{author},#{imgpath},#{typeid})")
    void addGoods(Goods goods);
}
