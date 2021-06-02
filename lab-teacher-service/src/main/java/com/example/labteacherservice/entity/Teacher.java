package com.example.labteacherservice.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("teacher")
public class Teacher {
    private Long id;
    private String name;
    private String profession;
}
