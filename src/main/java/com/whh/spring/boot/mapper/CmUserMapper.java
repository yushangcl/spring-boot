package com.whh.spring.boot.mapper;

import com.whh.spring.boot.dao.CmUser;
import org.apache.ibatis.annotations.*;

/**
 * @author huahui.wu.
 *         Created on 2018/1/10.
 */
@Mapper
public interface CmUserMapper {
    /**
     * 根据名字查找
     * @param name 名字
     * @return
     */
    @Select("SELECT * FROM CM_USER WHERE NAME = #{name}")
    CmUser findByName(@Param("name") String name);

    /**
     * 插入用户信息
     * @param name 名字
     * @param age 年龄
     * @return
     */
    @Insert("INSERT INTO CM_USER(NAME, AGE) VALUES(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);

    /**
     * 更新用户信息
     * @param cmUser User
     */
    @Update("UPDATE CM_USER SET age=#{age} WHERE name=#{name}")
    void update(CmUser cmUser);

    /**
     * 删除用户细腻
     * @param id id
     */
    @Delete("DELETE FROM CM_USER WHERE id =#{id}")
    void delete(Long id);
}
