package x.test.service;

import org.springframework.stereotype.Service;
import x.test.annotion.EnableLog;
import x.test.model.ReqParam;

//@Service
public interface TestService {

//    @EnableLog
    public void test(ReqParam param);

}
