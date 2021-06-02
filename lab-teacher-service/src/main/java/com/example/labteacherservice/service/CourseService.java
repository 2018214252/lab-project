package com.example.labteacherservice.service;

import com.example.labteacherservice.entity.Course;
import com.example.labteacherservice.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CourseService {
    @Autowired
    private CourseMapper courseMapper;

    @CacheEvict(value = "teacher", key = "#tid")
    public void insertCourse(Course course, long tid) {
        courseMapper.insert(course);
    }

    @CacheEvict(value = "teacher", key = "#tid")
    public void updateCourse(Course course, long tid) {
        courseMapper.update(course);
    }

    @CacheEvict(value = "teacher", key = "#tid")
    public void deleteCourse(long id, long tid) {
        courseMapper.remove(id);
    }
}
