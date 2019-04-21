package sq.demo.spring.boot.conf.models;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "sysconf")
public class ConfProperties {
    private String propertity1;

    public String getPropertity1() {
        return propertity1;
    }

    public void setPropertity1(String propertity1) {
        this.propertity1 = propertity1;
    }
}
