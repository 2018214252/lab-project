package com.example.labloginservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.labloginservice.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from user where user_name = #{userName}")
    User getUser(String userName);
}
