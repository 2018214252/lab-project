package com.example.labadminservice.controller;

import com.example.labadminservice.entity.Lab;
import com.example.labadminservice.entity.Teacher;
import com.example.labadminservice.entity.User;
import com.example.labadminservice.service.LabService;
import com.example.labadminservice.service.TeacherService;
import com.example.labadminservice.service.UserService;
import com.example.labadminservice.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@Api(value = "处理管理员操作请求", tags = {"Authorization, Admin"})
@RestController
@RequestMapping("/api/admin/")
@Slf4j
public class AdminController {
    @Autowired
    private LabService labService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private UserService userService;

    @ApiOperation("添加实验室，并返回当前所有实验室")
    @PostMapping("lab")
    public ResultVO insertLab(@Valid @RequestBody Lab lab) {
        if (labService.getLabById(lab.getId()) == null) {
            return ResultVO.success(Map.of("labs", labService.insertLab(lab)));
        }
        return ResultVO.error(500, "实验室已存在");
    }

    @ApiOperation("更新实验室，并返回当前所有实验室")
    @PatchMapping("lab")
    public ResultVO updateLab(@Valid @RequestBody Lab lab) {
        return ResultVO.success(Map.of("labs", labService.updateLab(lab)));
    }

    @ApiOperation("删除实验室，并返回当前所有实验室")
    @DeleteMapping("lab/{id}")
    public ResultVO deleteLab(@PathVariable long id) {
        return ResultVO.success(Map.of("labs", labService.deleteLab(id)));
    }

    @ApiOperation("查看所有教师信息")
    @GetMapping("teachers")
    public ResultVO listTeachers() {
        return ResultVO.success(Map.of("teachers", teacherService.listTeachers()));
    }

    @ApiOperation("添加新教师信息，并返回当前所有教师信息")
    @PostMapping("teacher")
    public ResultVO insertTeacher(@Valid @RequestBody Teacher teacher) {
        if (teacherService.getTeacherById(teacher.getId()) == null) {
            return ResultVO.success(Map.of("teachers", teacherService.insertTeacher(teacher)));
        }
        return ResultVO.error(500, "教师已存在");
    }

    @ApiOperation("删除教师，并返回当前所有教师信息")
    @DeleteMapping("teacher/{tid}")
    public ResultVO deleteTeacher(@PathVariable long tid) {
        return ResultVO.success(Map.of("teachers", teacherService.deleteTeacher(tid)));
    }

    @ApiOperation("更新教师信息，并返回当前所有教师信息")
    @PatchMapping("teacher")
    public ResultVO updateTeacher(@Valid @RequestBody Teacher teacher) {
        return ResultVO.success(Map.of("teachers", teacherService.updateTeacher(teacher)));
    }

    @ApiOperation("添加教师账号")
    @PostMapping("user")
    public ResultVO addUser(@Valid @RequestBody User user) {
        if(userService.getUser(user.getUserName())==null){
            userService.insertUser(user);
            return ResultVO.success(Map.of());
        }
        return ResultVO.error(500,"用户名已存在");
    }


}
