package com.example.labteacherservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.labteacherservice.dto.TeacherDTO;
import com.example.labteacherservice.entity.Teacher;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TeacherMapper extends BaseMapper<Teacher> {
    @Select("select * from teacher")
    List<Teacher> listTeachers();
    @Delete("delete from teacher where id = #{id}")
    public void remove(long id);
    @Update("update teacher set name = #{name}, profession = #{profession} where id = #{id}")
    public void update(Teacher teacher);
    @Select("select * from teacher where id = #{tid}")
    TeacherDTO getTea0(long tid);
    @Select("select * from teacher where id = #{tid}")
    Teacher getTeacherById(long tid);


    TeacherDTO getTea(long tid);
}
