package sq.demo.spring.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sq.demo.spring.boot.service.IPrimaryTest;
import sq.demo.spring.boot.service.IQualifierTest;

@Controller
@RequestMapping("/test/qualifier")
public class QualifierTestController {

    @Autowired
    @Qualifier("impl1")
    IQualifierTest qualifierTest1;


    @Autowired
    @Qualifier("impl2")
    IQualifierTest qualifierTest2;

    @RequestMapping("/imp1")
    @ResponseBody
    public String imp1(){
        return qualifierTest1.get();
    }

    @RequestMapping("/imp2")
    @ResponseBody
    public String imp2(){
        return qualifierTest2.get();
    }
}
