package com.example.labadminservice.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeacherUser {
    @NotNull(message = "教师id不能为空")
    private Long id;
    @NotNull(message = "教师姓名不能为空")
    @Size(min = 1,message = "教师姓名不能为空")
    private String name;
    @NotNull(message = "教师专业不能为空")
    @Size(min = 1,message = "教师专业不能为空")
    private String profession;
    @NotNull(message = "用户名长度应在6~15之间")
    @Size(min = 6, max = 15, message = "用户名长度应在6~15之间")
    private String userName;
    @NotNull(message = "密码长度应在6~15之间")
    @Size(min = 6, max = 15, message = "密码长度应在6~15之间")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
}
