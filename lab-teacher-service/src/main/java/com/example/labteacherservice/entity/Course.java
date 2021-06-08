package com.example.labteacherservice.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("course")
public class Course {
    private Long id;
    private Long tid;
    @NotNull(message = "课程名称不能为空")
    @Size(min = 1,message = "课程名称不能为空")
    private String name;
    @NotNull(message = "学时不能为空")
    private int classHour;
    @NotNull(message = "学生人数不能为空")
    private int studentNumber;
}
