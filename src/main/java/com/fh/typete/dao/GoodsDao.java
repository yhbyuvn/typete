package com.fh.typete.dao;

import com.fh.typete.model.Goods;
import org.apache.ibatis.annotations.Insert;

public interface GoodsDao {
    @Insert("insert into ts_goods(name,title,brandid,productdecs,price,stocks,sortnum,isdel,createdate,updatedate,author) value(#{name},#{title},#{brandid},#{productdecs},#{price},#{stocks},#{sortnum},#{isdel},#{createdate},#{updatedate},#{author})")
    void addGoods(Goods goods);
}
