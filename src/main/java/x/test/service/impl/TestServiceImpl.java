package x.test.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import x.test.annotion.EnableLog;
import x.test.constants.LogTypeEnum;
import x.test.model.ReqParam;
import x.test.service.TestService;

@Service
//@Service(value = "xxx")
@Slf4j
public class TestServiceImpl implements TestService, BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {

    private static final Logger loggerBizA = LoggerFactory.getLogger(LogTypeEnum.LOG_TYPE_BIZA.getLogType());
    private static final Logger loggerBizB = LoggerFactory.getLogger(LogTypeEnum.LOG_TYPE_BIZB.getLogType());

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    BeanFactory beanFactory;

    @Override
    @EnableLog
    public void test(ReqParam param) {
        stringRedisTemplate.opsForValue().set(param.getReqId(), param.getSourceName());
        loggerBizA.info("loggerBizA test function");
        loggerBizB.info("loggerBizB test function");
    }

    public TestServiceImpl() {
        log.info("TestServiceImpl constructor.");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        log.info("BeanFactoryAware setBeanFactory");
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String s) {
        log.info("BeanNameAware setBeanName " + s);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // 通过反射，调用完set方法后，调用此方法
        log.info("InitializingBean afterPropertiesSet");
    }

    @Override
    public void destroy() throws Exception {
        log.info("DisposableBean destroyv");
    }
}
