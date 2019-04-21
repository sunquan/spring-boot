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
@RequestMapping("/test/autowired")
public class AutowiredTestController {

    @Autowired
    IPrimaryTest primaryTest;

    IQualifierTest qualifierTest1;

    IQualifierTest qualifierTest2;


    AutowiredTestController(@Autowired @Qualifier("impl1") IQualifierTest qualifierTest1){
        this.qualifierTest1 = qualifierTest1;
    }

    public IQualifierTest getQualifierTest2() {
        return qualifierTest2;
    }

    @Autowired @Qualifier("impl2")
    public void setQualifierTest2(IQualifierTest qualifierTest2) {
        this.qualifierTest2 = qualifierTest2;
    }


    @RequestMapping("")
    @ResponseBody
    public List<String> imp2(){
        List<String> list = new ArrayList<>();
        list.add(primaryTest.get());
        list.add(qualifierTest1.get());
        list.add(qualifierTest2.get());
        return list;
    }
}
