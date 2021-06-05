package com.example.labteacherservice.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("lab")
public class Lab {
    @NotNull(message = "实验室编号不能为空")
    private Long id;
    private int machineNumber;
    private String details;
}
