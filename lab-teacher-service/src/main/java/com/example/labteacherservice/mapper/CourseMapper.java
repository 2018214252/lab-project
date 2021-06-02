package com.example.labteacherservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.labteacherservice.entity.Course;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CourseMapper extends BaseMapper<Course> {
    @Update("update course set name = #{name}, class_hour = #{classHour},student_number = #{studentNumber} where id = #{id}")
    public void update(Course course);
    @Delete("delete from course where id = #{id}")
    public void remove(long id);
    @Select("select * from course where tid = #{tid}")
    List<Course> getCourses(long tid);
}
