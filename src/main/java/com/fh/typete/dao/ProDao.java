package com.fh.typete.dao;

import com.fh.typete.model.Propertys;
import com.fh.typete.vo.ProVo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProDao {
    @Select("<script>" +
            "select count(*) from ts_pro where 1=1 and isdel=0" +
            "</script>")
    Long chaCount(ProVo pv);
    @Select("<script>" +
            "select * from ts_pro where 1=1 and isdel=0" +
            " limit #{startIndex},#{limit}" +
            "</script>")
    List<Propertys> chaPro(ProVo pv);
}
