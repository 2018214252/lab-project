package com.example.labteacherservice.controller;

import com.example.labteacherservice.entity.Course;
import com.example.labteacherservice.entity.ReservationRecord;
import com.example.labteacherservice.mapper.LabMapper;
import com.example.labteacherservice.service.CourseService;
import com.example.labteacherservice.service.ReservationRecordService;
import com.example.labteacherservice.service.TeacherService;
import com.example.labteacherservice.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@Api(value = "处理教师操作请求", tags = {"Authorization, Teacher"})
@RestController
@RequestMapping("/api/teacher")
@Slf4j

public class TeacherController {
    @Autowired
    private LabMapper labMapper;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private ReservationRecordService reservationRecordService;

    @ApiOperation("添加课程，并返回指定教师信息")
    @PostMapping("course")
    public ResultVO insertCourse(@RequestAttribute("uid") long tid,@Valid @RequestBody Course course) {
        course.setTid(tid);
        courseService.insertCourse(course, tid);
        return ResultVO.success(Map.of("teacher", teacherService.getTeacher(tid)));
    }

    @ApiOperation("删除课程，并返回指定教师信息")
    @DeleteMapping("course/{cid}")
    public ResultVO deleteCourse(@RequestAttribute("uid") long tid, @PathVariable long cid) {
        courseService.deleteCourse(cid, tid);
        return ResultVO.success(Map.of("teacher", teacherService.getTeacher(tid)));
    }

    @ApiOperation("修改课程信息，并返回教师信息")
    @PatchMapping("course")
    public ResultVO updateCourse(@RequestAttribute("uid") long tid,@Valid @RequestBody Course course) {
        courseService.updateCourse(course, tid);
        return ResultVO.success(Map.of("teacher", teacherService.getTeacher(tid)));
    }

    @ApiOperation("预约课程，返回自己的预约记录")
    @PostMapping("record")
    public ResultVO insertRecord(@RequestBody ReservationRecord reservationRecord, @RequestAttribute("uid") long tid) {
        reservationRecordService.insertRecord(reservationRecord, tid);
        return ResultVO.success(Map.of( "myRecords", reservationRecordService.getRecords(tid)));
    }

    @ApiOperation("查看个人预约记录，返回自己的预约记录")
    @GetMapping("records")
    public ResultVO getRecords(@RequestAttribute("uid") long tid) {
        return ResultVO.success(Map.of("myRecords", reservationRecordService.getRecords(tid)));
    }

    @ApiOperation("取消预约，返回自己的预约记录")
    @DeleteMapping("record/{id}")
    public ResultVO deleteRecord(@RequestAttribute("uid") long tid, @PathVariable long id) {
        reservationRecordService.deleteRecord(id, tid);
        return ResultVO.success(Map.of( "myRecords", reservationRecordService.getRecords(tid)));
    }

    @ApiOperation("查看指定实验室的所有预约记录")
    @GetMapping("records/{lid}")
    public ResultVO getRecordsByLid(@PathVariable long lid){
        return ResultVO.success(Map.of("records",reservationRecordService.getRecordsByLid(lid)));
    }
}
