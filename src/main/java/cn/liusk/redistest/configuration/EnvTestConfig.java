/**
 * BEYONDSOFT.COM INC
 */
package cn.liusk.redistest.configuration;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author liusk
 * @version $Id: EnvTestConfig.java, v 0.1 2018/6/7 9:56 liusk Exp $
 */
@Component
public class EnvTestConfig implements ApplicationContextAware{

    private ApplicationContext applicationContext;

    private Environment environment;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.environment = applicationContext.getEnvironment();
        this.applicationContext = applicationContext;
    }
}
