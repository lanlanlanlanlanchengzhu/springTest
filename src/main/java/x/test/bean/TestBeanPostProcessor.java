package x.test.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;

/**
 * Bean处理后置操作，对容器中所有Bean生效
 */
@Slf4j
@Service
public class TestBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        log.info("TestBeanPostProcessor postProcessBeforeInitialization invoked" + beanName);
        return bean;
    }

}
