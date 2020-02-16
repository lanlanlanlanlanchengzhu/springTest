package x.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import x.test.annotion.EnableLog;
import x.test.model.ReqParam;
import x.test.service.TestService;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Override
    @EnableLog
    public void test(ReqParam param) {
        stringRedisTemplate.opsForValue().set(param.getReqId(), param.getName());
        System.out.println("test function");
    }

}
