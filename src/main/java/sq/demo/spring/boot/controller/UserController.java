package sq.demo.spring.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sq.demo.spring.boot.model.User;
import sq.demo.spring.boot.repository.entity.UserEntity;
import sq.demo.spring.boot.service.JdbcUserService;
import sq.demo.spring.boot.service.MybatisUserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user/")
public class UserController {
    @Autowired
    private JdbcUserService jdbcUserService;

    @Autowired
    private MybatisUserService mybatisUserService;

    @ResponseBody
    @RequestMapping("get")
    public User get(int id){
        return jdbcUserService.getUserById(id);
    }

    @ResponseBody
    @RequestMapping("all")
    public List<User> getAll(){
        return jdbcUserService.getUserAll();
    }

    @ResponseBody
    @RequestMapping("add")
    public Map<String, Object> add(User user){
        jdbcUserService.add(user);
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        return map;
    }

    @ResponseBody
    @RequestMapping("mybatis/get")
    public UserEntity getByMybatis(int id){
        return mybatisUserService.getUserById(id);
    }

    @ResponseBody
    @RequestMapping("mybatis/add")
    public UserEntity mybatisAdd(UserEntity user){
        mybatisUserService.add(user);
        return null;
    }

    @ResponseBody
    @RequestMapping("mybatis/add1")
    public void mybatisAdd1(String name, String name1){
        List<UserEntity> list = new ArrayList<>();
        UserEntity u1 = new UserEntity();
        u1.setName(name);
        UserEntity u2 = new UserEntity();
        u2.setName(name1);
        list.add(u1);
        list.add(u2);
        mybatisUserService.addUsersWithoutTransaction(list);
    }


    @ResponseBody
    @RequestMapping("mybatis/add2")
    public void mybatisAdd2(String name, String name1){
        List<UserEntity> list = new ArrayList<>();
        UserEntity u1 = new UserEntity();
        u1.setName(name);
        UserEntity u2 = new UserEntity();
        u2.setName(name1);
        list.add(u1);
        list.add(u2);
        mybatisUserService.addUsersWithTransaction(list);
    }
}
