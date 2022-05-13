package dao;

import java.util.HashMap;
import java.util.List;

public interface UserDao {
    List<HashMap<String,Object>> FindByEmail(String email);
    List<HashMap<String,Object>> FindByEmailAndPassword(HashMap<String ,Object> map);
    int AddUser(HashMap<String ,Object> map);
    List<HashMap<String,Object>> FindByUserId(int UserId);
    List<HashMap<String,Object>> UserList(HashMap<String ,Object> map);
    int countUser(HashMap<String ,Object> map);
    int updatePassword(HashMap<String ,Object> map);
}
