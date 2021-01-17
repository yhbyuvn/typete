package com.fh.typete.dao;

import com.fh.typete.model.ProValue;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProValueDao {
    @Select("select * from ts_provalue where isdel=0")
    List<ProValue> chaProValue();
}
