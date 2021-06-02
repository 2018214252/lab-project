package com.example.labteacherservice.dto;

import com.example.labteacherservice.entity.Course;
import lombok.*;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TeacherDTO {
    private Long id;
    private String name;
    private String profession;
    private List<Course> courses;
}
