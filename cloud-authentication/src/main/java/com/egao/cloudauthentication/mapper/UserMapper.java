package com.egao.cloudauthentication.mapper;

import com.egao.cloudauthentication.entity.User;
import com.sun.istack.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * 用户DAO
 *
 * @author Jiuha
 */
@Repository
public interface UserMapper extends JpaRepository<User, String> {

    /**
     * 根据用户名和删除标志位查询用户
     *
     * @param username   用户名
     * @return 用户信息实体类
     */
    Optional<User> findByUsername(String username);

    /**
     * 新增用户
     *
     * @param s   实体类
     * @param <S> 类型
     * @return 实体类
     */
    @Override
    <S extends User> S save(@NotNull S s);
}
