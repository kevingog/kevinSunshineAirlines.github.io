package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.impl.UserServiceImpl;

import javax.annotation.Resource;
import java.util.HashMap;

@Controller
public class UserController {
    @Resource
    private UserServiceImpl impl;
    @RequestMapping("/login")
    @ResponseBody
    public Object login(String email,String password){
        HashMap<String, Object> map = new HashMap<>();
        map.put("email",email);
        map.put("password",password);
        return impl.login(map);
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public Object addUsers(String email,String firstName,String lastName,String gender,
                           String dateOfBirth,String phone,String photo,String address,int roleId){
        HashMap<String, Object> map = new HashMap<>();
        map.put("email",email);
        String password=email.split("@")[0];
        password=password.length()>6?password.substring(0,6):password;
        map.put("password",password);
        map.put("firstName",firstName);
        map.put("lastName",lastName);
        map.put("gender",gender);
        map.put("dateOfBirth",dateOfBirth);
        map.put("phone",phone);
        map.put("photo",photo);
        map.put("address",address);
        try {
        }catch (Exception ex){
            roleId=0;
        }
        map.put("roleId",roleId);
        return impl.addUsers(map);
    }
    @RequestMapping("/userList")
    @ResponseBody
    public Object userList(int roleId,String name,int startPage,int pageSize){
        HashMap<String, Object> map = new HashMap<>();
        try {
        }catch (Exception ex){
            roleId=0;
        }
        try {
        }catch (Exception ex){
            startPage=1;
        }
        try {
        }catch (Exception ex){
            pageSize=10;
        }
        map.put("roleId",roleId);
        map.put("name",name);
        map.put("startPage",startPage);
        map.put("pageSize",pageSize);
        return impl.userList(map);
    }
    @RequestMapping("/updatePassword")
    @ResponseBody
    public Object updatePassword(int userId,String password){
        HashMap<String, Object> map = new HashMap<>();
        try {

        }catch (Exception exception){
            userId=0;
        }
        map.put("userId",userId);
        map.put("password",password);
        return  impl.updatePassword(map);
    }
}
