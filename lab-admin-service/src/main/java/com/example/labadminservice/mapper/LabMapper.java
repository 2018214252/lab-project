package com.example.labadminservice.mapper;

import com.example.labadminservice.entity.Lab;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface LabMapper {
    @Insert("insert into lab(id, machineNumber, details) values (#{id}, #{machineNumber}, #{details})")
    public void insert(Lab lab);

    @Select("select * from lab")
    List<Lab> list();

    @Update("update lab set machineNumber = #{machineNumber}, details = #{details} where id = #{id}")
    public void updateById(Lab lab);

    @Delete("delete from lab where id = #{id}")
    public void remove(long id);

    @Select("select * from lab where id = #{id}")
    Lab getLab(long id);
}
