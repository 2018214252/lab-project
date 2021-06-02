package com.example.labteacherservice.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("lab")
public class Lab {
    private Long id;
    private int machineNumber;
    private String details;
}
