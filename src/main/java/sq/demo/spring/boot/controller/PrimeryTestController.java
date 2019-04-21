package sq.demo.spring.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sq.demo.spring.boot.conf.models.ConfBean;
import sq.demo.spring.boot.conf.models.ConfProfile;
import sq.demo.spring.boot.conf.models.ConfProperties;
import sq.demo.spring.boot.service.IPrimaryTest;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/test/primery")
public class PrimeryTestController {

    @Autowired
    IPrimaryTest primaryTest;

    @RequestMapping("")
    @ResponseBody
    public String conf(){
        return primaryTest.get();
    }
}
