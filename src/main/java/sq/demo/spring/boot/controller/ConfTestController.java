package sq.demo.spring.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sq.demo.spring.boot.conf.models.ConfBean;
import sq.demo.spring.boot.conf.models.ConfProfile;
import sq.demo.spring.boot.conf.models.ConfProperties;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/conf")
public class ConfTestController {

    @Autowired
    ConfProperties confProperties;

    @Autowired
    @Qualifier("bean_1")
    ConfBean confBean;

    @Autowired
    ConfProfile confProfile;

    @RequestMapping("")
    @ResponseBody
    public Map<String, Object> conf(){
        Map<String, Object> map = new HashMap<>();
        map.put("confProperties", confProperties);
        map.put("confBean", confBean);
        map.put("confProfile", confProfile);
        return map;
    }
}
