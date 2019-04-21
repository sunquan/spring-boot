package sq.demo.spring.boot.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import sq.demo.spring.boot.service.IQualifierTest;

@Service("impl2")
public class QualifierTestImpl2 implements IQualifierTest {
    @Override
    public String get() {
        return "impl2";
    }
}
