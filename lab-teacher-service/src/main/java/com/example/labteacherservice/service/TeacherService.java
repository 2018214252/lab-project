package com.example.labteacherservice.service;

import com.example.labteacherservice.dto.TeacherDTO;
import com.example.labteacherservice.entity.Teacher;
import com.example.labteacherservice.mapper.CourseMapper;
import com.example.labteacherservice.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private CourseMapper courseMapper;

    @Cacheable(value = "teachers")
    public List<Teacher> listTeachers() {
        return teacherMapper.listTeachers();
    }

    @CacheEvict(value = "teachers", allEntries = true)
    public List<Teacher> insertTeacher(Teacher teacher) {
        teacherMapper.insert(teacher);
        return teacherMapper.listTeachers();
    }

    @CacheEvict(value = "teachers", allEntries = true)
    public List<Teacher> deleteTeacher(long tid) {
        teacherMapper.remove(tid);
        return teacherMapper.listTeachers();
    }

    @CacheEvict(value = "teachers", allEntries = true)
    public List<Teacher> updateTeacher(Teacher teacher) {
        teacherMapper.update(teacher);
        return teacherMapper.listTeachers();
    }

    //@Cacheable(value = "teacher", key = "#tid")
    public TeacherDTO getTeacher(long tid) {
        if (courseMapper.getCourses(tid).size() == 0) {
            TeacherDTO teacherDTO = teacherMapper.getTea0(tid);
            teacherDTO.setCourses(new ArrayList<>());
            return teacherDTO;
        }
        return teacherMapper.getTea(tid);
    }

    public Teacher getTeacherById(long tid) {
        return teacherMapper.getTeacherById(tid);
    }

}
