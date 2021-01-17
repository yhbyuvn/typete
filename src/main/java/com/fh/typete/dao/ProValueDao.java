package com.fh.typete.dao;

import com.fh.typete.model.ProValue;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ProValueDao {
    @Select("select * from ts_provalue where isdel=0 and proid=#{proid}")
    List<ProValue> chaProValue(Integer proid);
    @Insert("insert into ts_provalue(value,valuech,proid,isdel) value(#{value},#{valuech},#{proid},#{isdel})")
    void addProValue(ProValue pv);
    @Update("update ts_provalue set value=#{value},valuech=#{valuech},proid=#{proid},isdel=#{isdel} where id=#{id}")
    void upProValue(ProValue pv);
}
