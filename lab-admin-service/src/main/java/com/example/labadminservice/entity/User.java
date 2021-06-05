package com.example.labadminservice.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("user")
public class User {
    @NotNull(message = "教师id不能为空")
    private Long id;
    @NotNull(message = "角色信息不能为空")
    private Integer role;
    @NotNull(message = "用户名不能为空")
    @Size(min = 6,max = 15,message = "用户名长度应为6~15")
    private String userName;
    @NotNull(message = "密码不能为空")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
}
