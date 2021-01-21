package com.fh.typete.dao;

import com.fh.typete.model.GoodsValue;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

public interface GoodsValueDao {
    @Insert("<script>" +
            "insert into ts_goodvalue(goodid,goodvalue,storcks,price) values<foreach collection='list' item='b' separator=','>(#{b.goodid},#{b.goodvalue},#{b.storcks},#{b.price})</foreach>" +
            "</script>")
    void adds(List<GoodsValue> li);
}
