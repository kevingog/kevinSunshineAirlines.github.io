package service;

import pojo.Result;

import java.util.HashMap;
import java.util.List;

public interface UserService {
    Result login(HashMap<String ,Object> map);
    Result addUsers(HashMap<String ,Object> map);
    Result userList(HashMap<String ,Object> map);
    Result updatePassword(HashMap<String ,Object> map);
}
