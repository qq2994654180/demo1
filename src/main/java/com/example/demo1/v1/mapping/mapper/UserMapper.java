package com.example.demo1.v1.mapping.mapper;
import com.example.demo1.v1.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {
    User selectUserById(String userId);
}
