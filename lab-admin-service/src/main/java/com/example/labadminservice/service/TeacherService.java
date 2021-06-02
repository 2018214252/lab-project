package com.example.labadminservice.service;

import com.example.labadminservice.entity.Teacher;
import com.example.labadminservice.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

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

    public Teacher getTeacherById(long tid) {
        return teacherMapper.getTeacherById(tid);
    }

}
