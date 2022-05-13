package service;

import dao.cityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
@Service
public class cityServiceImpl implements cityService{
    @Resource
    private cityDao cityDao;
    @Override
    public List<HashMap<String, Object>> cityList() {
        System.out.println("aaa");
        return cityDao.cityList();
    }
}
