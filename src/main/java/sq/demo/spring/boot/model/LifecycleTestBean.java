package sq.demo.spring.boot.model;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import sq.demo.spring.boot.conf.models.ConfBean;
import sq.demo.spring.boot.conf.models.ConfProfile;
import sq.demo.spring.boot.conf.models.ConfProperties;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class LifecycleTestBean implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {
    private ConfProperties confProperties;
    private ConfProfile confProfile;
    private ConfBean confBean;

    /**
     * 如果重写了默认构造方法，只执行这个，不执行其他
     */
    public LifecycleTestBean(){
        System.out.println("--------------执行默认构造方法" );
    }

    /**
     * 多个Autowired构造方法，如果没有重写默认构造方法，会报错
     */
    public LifecycleTestBean(@Autowired ConfProfile confProfile){
        this.confProfile = confProfile;
        System.out.println("--------------执行带注入参数带构造方法1" );
    }

    public LifecycleTestBean(@Autowired ConfBean confBean){
        this.confBean = confBean;
        System.out.println("--------------执行带注入参数带构造方法2" );
    }

    public ConfProperties getConfProperties() {
        return confProperties;
    }

    @Autowired
    public void setConfProperties(ConfProperties confProperties) {
        this.confProperties = confProperties;
        System.out.println("--------------执行属性注入");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("--------------执行postConstruct" );
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("--------------执行preDestroy" );
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("--------------执行setBeanFactory" );
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("--------------执行setBeanName" );
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("--------------执行destroy" );
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("--------------执行afterPropertiesSet" );
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("--------------执行setApplicationContext" );
    }
}
