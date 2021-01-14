package com.fh.typete.dao;

import com.fh.typete.model.Types;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface TypeDao {
    @Select("select * from ts_type where isdel=0")
    List<Types> cha();
    @Select("select * from ts_type where pid=#{pid}")
    List<Types> chaByPid(Integer pid);
    @Insert("insert into ts_type(name,pid,updatedate,createdate,isdel,whodid) value(#{name},#{pid},#{updatedate},#{createdate},#{isdel},#{whodid})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    Integer addType(Types ty);
    @Update("update ts_type set name=#{name},updatedate=#{updatedate},isdel=#{isdel},whodid=#{whodid} where id=#{id}")
    void upType(Types ty);
}
