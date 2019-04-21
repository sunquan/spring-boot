package sq.demo.spring.boot.service.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import sq.demo.spring.boot.service.IPrimaryTest;

@Service
@Primary
public class PrimeryTestImpl1 implements IPrimaryTest {
    @Override
    public String get() {
        return "impl1";
    }
}
