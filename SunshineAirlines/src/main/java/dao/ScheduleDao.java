package dao;

import java.util.HashMap;
import java.util.List;

public interface ScheduleDao {
    List<HashMap<String,Object>> getSchedule(HashMap<String,Object> map);
    int updateSchedule(HashMap<String,Object> map);
    List<HashMap<String,Object>> getTicket(HashMap<String,Object> map);
    List<HashMap<String,Object>> findByScheduleId(int scheduleId);
}
