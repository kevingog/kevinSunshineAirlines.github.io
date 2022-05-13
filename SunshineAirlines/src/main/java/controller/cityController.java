package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.Result;
import service.cityService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Controller
public class cityController {
    @Resource
    private cityService cityService;
    @RequestMapping("/getCityNames")
    @ResponseBody
    public Object getCityNames(){
        System.out.println("a");
        return new Result("success",null,cityService.cityList());
    }
}
