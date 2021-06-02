package com.example.labteacherservice.controller;

import com.example.labteacherservice.common.Role;
import com.example.labteacherservice.entity.Lab;
import com.example.labteacherservice.service.LabService;
import com.example.labteacherservice.service.ReservationRecordService;
import com.example.labteacherservice.service.TeacherService;
import com.example.labteacherservice.service.UserService;
import com.example.labteacherservice.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(value = "处理用户通用操作请求", tags = {"Authorization"})
@RestController
@RequestMapping("/api/common/")
public class CommonController {
    @Autowired
    private LabService labService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private UserService userService;
    @Autowired
    private ReservationRecordService reservationRecordService;
    @Autowired
    private PasswordEncoder encoder;

    @ApiOperation("加载所有实验室信息")
    @GetMapping("labs")
    private ResultVO getLabs() {
        List<Lab> labs = labService.listLabs();
        return ResultVO.success(Map.of("labs", labs));
    }

    @ApiOperation("登录后首页信息，加载教师信息")
    @GetMapping("teacher")
    public ResultVO getTeacher(@RequestAttribute("uid") long uid, @RequestAttribute("role") int role) {
        if (role == Role.TEACHER) {
            return ResultVO.success(Map.of("teacher", teacherService.getTeacher(uid)));
        }
        return ResultVO.success(Map.of());
    }

    @ApiOperation("修改密码")
    @PatchMapping("password")
    public ResultVO updatePassword(@RequestAttribute("uid") long uid, @RequestBody Map<String, String> map) {
        String oldPassword = map.get("oldPassword");
        String newPassword = map.get("newPassword");
        String userName = map.get("userName");
        if (oldPassword == null || !encoder.matches(oldPassword, userService.getUser(userName).getPassword())) {
            return ResultVO.error(401, "原密码错误");
        }
        userService.updatePassword(uid, newPassword);
        return ResultVO.success(Map.of());
    }


}
