package com.example.labteacherservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.labteacherservice.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from user where user_name = #{userName}")
    User getUser(String userName);
}
