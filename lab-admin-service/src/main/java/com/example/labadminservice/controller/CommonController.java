package com.example.labadminservice.controller;

import com.example.labadminservice.entity.Lab;
import com.example.labadminservice.service.LabService;
import com.example.labadminservice.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(value = "处理用户通用操作请求", tags = {"Authorization"})
@RestController
@RequestMapping("/api/common/")
public class CommonController {
    @Autowired
    private LabService labService;

    @ApiOperation("加载所有实验室信息")
    @GetMapping("labs")
    private ResultVO getLabs() {
        List<Lab> labs = labService.listLabs();
        return ResultVO.success(Map.of("labs", labs));
    }
}
