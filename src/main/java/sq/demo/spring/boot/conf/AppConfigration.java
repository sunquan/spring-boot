package sq.demo.spring.boot.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import sq.demo.spring.boot.conf.models.ConfBean;
import sq.demo.spring.boot.conf.models.ConfProfile;

@Configuration
public class AppConfigration {

    @Bean
    public ConfBean initUserConf(){
        ConfBean conf1 = new ConfBean();
        conf1.setName("name_1");
        return conf1;
    }

    @Bean
    @Profile("dev")
    public ConfProfile initDbConfMysql(){
        ConfProfile conf1 = new ConfProfile();
        conf1.setName("name_1");
        return conf1;
    }

    @Bean
    @Profile("prod")
    public ConfProfile initDbConfSqlServer(){
        ConfProfile conf1 = new ConfProfile();
        conf1.setName("name_1");
        return conf1;
    }

    @Bean(name="bean_1")
    public ConfBean initBean(@Value("sysconf.propertity1") String name){
        ConfBean conf1 = new ConfBean();
        conf1.setName(name);
        return conf1;
    }

    @Bean(name="bean_2")
    public ConfBean initBean2(@Autowired ConfProfile confProfile){
        ConfBean conf1 = new ConfBean();
        conf1.setName(confProfile.getName());
        return conf1;
    }

    @Bean(name="bean_3")
    public ConfBean initBean3(ConfProfile confProfile){
        ConfBean conf1 = new ConfBean();
        conf1.setName(confProfile.getName());
        return conf1;
    }
}
