package sq.demo.spring.boot.service.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import sq.demo.spring.boot.service.IPrimaryTest;

@Service
public class PrimeryTestImpl2 implements IPrimaryTest {
    @Override
    public String get() {
        return "impl2";
    }
}
