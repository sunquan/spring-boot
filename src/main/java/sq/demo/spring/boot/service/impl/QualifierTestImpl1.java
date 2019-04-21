package sq.demo.spring.boot.service.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import sq.demo.spring.boot.service.IPrimaryTest;
import sq.demo.spring.boot.service.IQualifierTest;

@Service("impl1")
public class QualifierTestImpl1 implements IQualifierTest {
    @Override
    public String get() {
        return "impl1";
    }
}
