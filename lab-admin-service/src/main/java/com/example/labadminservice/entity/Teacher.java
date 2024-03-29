package com.example.labadminservice.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("teacher")
public class Teacher {
    @NotNull(message = "教师id不能为空")
    private Long id;
    @NotNull(message = "教师姓名不能为空")
    @Size(min = 1,message = "教师姓名不能为空")
    private String name;
    @NotNull(message = "教师专业不能为空")
    @Size(min = 1,message = "教师专业不能为空")
    private String profession;
}
