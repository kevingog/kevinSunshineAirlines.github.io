package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.ScheduleServiceImpl;

import javax.annotation.Resource;
import java.util.HashMap;

@Controller
public class ScheduleController {
    @Resource
    private ScheduleServiceImpl s;
    @RequestMapping("/getSchedule")
    @ResponseBody
    public Object getSchedule(String fromCity,String toCity,String startDate,String endDate){

        HashMap<String, Object> map = new HashMap<String,Object>();
        map.put("fromCity",fromCity);
        map.put("toCity",toCity);
        startDate=startDate+" 00:00:00";
        endDate=endDate+" 23:59:59";
        map.put("startDate",startDate);
        map.put("endDate",endDate);
        return s.getSchedule(map);
    }
    @RequestMapping("/updateSchedule")
    @ResponseBody
    public Object updateSchedule(int scheduleId,String status){
        HashMap<String, Object> map = new HashMap<>();
        try {

        }catch (Exception exception){
            scheduleId=0;
        }
        map.put("scheduleId",scheduleId);
        map.put("status",status);
        return s.updateSchedule(map);
    }
    @RequestMapping("/getTicketStatistics")
    @ResponseBody
    public Object getTicketStatistics(String startDate,String endDate){
        startDate=startDate+"-01 00:00:00";
        String[] arr=endDate.split("-");
        int year=Integer.parseInt(arr[0].toString());
        int month=Integer.parseInt(arr[1].toString());
        if(month<12){
            month++;
            endDate=month<10?year+"-0"+month+"-01 00:00:00":year+"-"+month+"-01 00:00:00";
        }else{
            year++;
            endDate=year+"-01-01 00:00:00";
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("startDate",startDate);
        map.put("endDate",endDate);
        return s.getTicketStatistics(map);
    }
}
