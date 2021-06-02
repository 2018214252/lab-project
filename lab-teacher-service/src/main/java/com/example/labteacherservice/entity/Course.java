package com.example.labteacherservice.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("course")
public class Course {
    private Long id;
    private Long tid;
    private String name;
    private int classHour;
    private int studentNumber;
}
