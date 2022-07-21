package service.impl;

import dao.ScheduleDao;
import org.springframework.stereotype.Service;
import pojo.Result;
import service.ScheduleService;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.SimpleTimeZone;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Resource
    private ScheduleDao scheduleDao;
    @Override
    public Result getSchedule(HashMap<String, Object> map) {
        List<HashMap<String, Object>> list = scheduleDao.getSchedule(map);
        for (HashMap<String ,Object> map1:list) {
            Date date = (Date) map1.get("Date");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String s = simpleDateFormat.format(date);
            map1.put("Date",s);
        }
        return new Result("success",null,list);
    }

    @Override
    public Result updateSchedule(HashMap<String, Object> map) {
        Result result = new Result("fail", null, null);
        List<HashMap<String, Object>> list = scheduleDao.findByScheduleId(Integer.parseInt(map.get("scheduleId").toString()));
        if(list!=null&&list.size()>0){
            if(scheduleDao.updateSchedule(map)>0){
                result.setFlag("success");
            }
        }else{
            result.setData("航班计划不存在");
        }
        return result;
    }

    @Override
    public Result getTicketStatistics(HashMap<String, Object> map) {
        List<HashMap<String, Object>> list = scheduleDao.getTicket(map);
        for (HashMap<String,Object> map1:list) {
            int year = Integer.parseInt(map1.get("Year").toString());
            int month = Integer.parseInt(map1.get("Month").toString());
            String monthStr=month<10?year+"-0"+month:year+"-"+month;
            map1.remove("Year");
            map1.put("Month",monthStr);
        }
        return new Result("success",null,list);
    }
}
