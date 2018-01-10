package com.whh.spring.boot.controller;

import com.whh.spring.boot.dao.CmUser;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author huahui.wu.
 *         Created on 2018/1/10.
 */
@RestController
@RequestMapping("/users")
public class UserController {


    /**
     * 创建线程安全的Map
     */
    static Map<Long, CmUser> users = Collections.synchronizedMap(new HashMap<Long, CmUser>());

    @ApiOperation(value="获取用户列表", notes="")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<CmUser> getUserList() {
        // 处理"/users/"的GET请求，用来获取用户列表
        // 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递
        List<CmUser> cmUsers = new ArrayList<>();
        CmUser cmUser = new CmUser();
        cmUser.setId(10001L);
        cmUser.setName("张三");
        cmUser.setAge(20);
        cmUsers.add(cmUser);
        return cmUsers;
    }

    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value="/", method=RequestMethod.POST)
    public String postUser(@ModelAttribute CmUser cmUser) {
        // 处理"/users/"的POST请求，用来创建User
        // 除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数
        //绑定的是  Param参数
        users.put(cmUser.getId(), cmUser);
        return "success";
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public CmUser getUser(@PathVariable Long id) {
        // 处理"/users/{id}"的GET请求，用来获取url中id值的User信息
        // url中的id可通过@PathVariable绑定到函数的参数中
        return users.get(id);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public String putUser(@PathVariable Long id, @ModelAttribute CmUser cmUser) {
        // 处理"/users/{id}"的PUT请求，用来更新User信息
        CmUser u = users.get(id);
        u.setName(cmUser.getName());
        u.setAge(cmUser.getAge());
        users.put(id, u);
        return "success";
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        // 处理"/users/{id}"的DELETE请求，用来删除User
        users.remove(id);
        return "success";
    }



}
