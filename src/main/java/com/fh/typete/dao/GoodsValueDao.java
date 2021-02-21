package com.fh.typete.dao;

import com.fh.typete.model.GoodsValue;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GoodsValueDao {
    @Insert("<script>" +
            "insert into ts_goodvalue(goodid,goodvalue,storcks,price) values<foreach collection='list' item='b' separator=','>(#{b.goodid},#{b.goodvalue},#{b.storcks},#{b.price})</foreach>" +
            "</script>")
    void adds(List<GoodsValue> li);
    @Select("select * from ts_goodvalue where goodid=#{goodid}")
    List<GoodsValue> chaGoodsValue(Integer goodid);
    @Delete("delete from ts_goodvalue where goodid=#{goodid}")
    void delgv(Integer goodid);
}
