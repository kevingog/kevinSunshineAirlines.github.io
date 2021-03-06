package service;

import pojo.Result;

import java.util.HashMap;

public interface ScheduleService {
    Result getSchedule(HashMap<String ,Object> map);
    Result updateSchedule(HashMap<String ,Object> map);
    Result getTicketStatistics(HashMap<String ,Object> map);
}
