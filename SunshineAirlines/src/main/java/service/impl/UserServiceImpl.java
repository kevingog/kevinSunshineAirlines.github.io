package service.impl;

import dao.UserDao;
import org.springframework.stereotype.Service;
import pojo.Page;
import pojo.Result;
import service.UserService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    private Result result;

    @Override
    public Result login(HashMap<String, Object> map){
        result=new Result("fail", null, null);
        List<HashMap<String, Object>> list = userDao.FindByEmailAndPassword(map);
        if(list!=null&&list.size()>0){
            result.setFlag("success");
            result.setData(list);
        }else{
            list=userDao.FindByEmail(map.get("email").toString());
            if(list!=null&&list.size()>0){
                result.setData("密码错误");
            }else{
                result.setData("邮箱不存在");
            }
        }
        return result;
    }
    @Override
    public Result addUsers(HashMap<String, Object> map){
        result=new Result("fail", null, null);
        List<HashMap<String, Object>> list =userDao.FindByEmail(map.get("email").toString());
        if(list!=null&&list.size()>0){
            result.setData("邮箱重复");
        }else{
            if(userDao.AddUser(map)>0){
                result.setFlag("success");
            }
        }
        return result;
    }
    @Override
    public Result userList(HashMap<String, Object> map){
        Page page = new Page(Integer.parseInt(map.get("startPage").toString()),Integer.parseInt(map.get("pageSize").toString()),userDao.countUser(map));
        result=new Result("success", page, userDao.UserList(map));
        return result;
    }

    @Override
    public Result updatePassword(HashMap<String, Object> map) {
        result=new Result("fail", null, null);
        List<HashMap<String, Object>> list = userDao.FindByUserId(Integer.parseInt(map.get("userId").toString()));
        if(list!=null&&list.size()>0){
            if(userDao.updatePassword(map)>0){
                result.setFlag("success");
            }
        }else{
            result.setData("用户信息不存在");
        }

        return result;
    }
}
