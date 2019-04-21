package sq.demo.spring.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sq.demo.spring.boot.model.LifecycleTestBean;
import sq.demo.spring.boot.service.IPrimaryTest;
import sq.demo.spring.boot.service.IQualifierTest;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/test/life")
public class LifecycleTestController {


    @Autowired
    private LifecycleTestBean lifecycleTestBean;

    @RequestMapping("")
    @ResponseBody
    public String imp2(){
        return lifecycleTestBean.toString();
    }
}
