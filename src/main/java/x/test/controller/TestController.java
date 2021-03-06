package x.test.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import x.test.handler.processor.StatelessProcessor;
import x.test.model.dto.ReqParam;
import x.test.service.TestService;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping(path = "/test")
public class TestController {

    @Autowired
    TestService testService;

    @Autowired
    StatelessProcessor statelessProcessor;

    /**
     * 通过一个Bean接收json数据
     * post方式和get方式都可以
     * curl http://localhost:8080/test/testRequestBody\?reqId\=123\&name\=456 -X POST -d '{"reqId":"123456","sourceName":"x","sourceIp":"0.0.0.0"}' -H 'Content-type: application/json'
     * ReqParam{reqId='reqId', name='name'}
     *
     * @param reqParam
     * @return
     */
//    @EnableLog
    @RequestMapping(path = "/testRequestBody")
    public JSONObject testRequestBody(@RequestBody @Validated ReqParam reqParam) {
        testService.test(reqParam);
        JSONObject res = new JSONObject();
        res.put("retCode", "0");
        statelessProcessor.invoke();
        return res;
    }

    /**
     * form表单提交方式，通过url传递参数
     * 适用于get、post方式提交
     * curl http://localhost:8080/test/testFrom\?reqId\=123\&name\=456
     *
     * @param reqId
     * @param name
     * @return
     */
//    @EnableLog
    @RequestMapping(path = "/testFrom")
    public String testFrom(String reqId, String name) {
        // testService.test("hello");
        return "test";
    }

    /**
     * HttpServletRequest
     * post方式和get方式都可以
     *
     * @param httpServletRequest
     * @return
     */
//    @EnableLog
    @RequestMapping(path = "/testHttpServletRequest")
    public String testHttpServletRequest(HttpServletRequest httpServletRequest) {
        // testService.test("hello");
        return "test";
    }

    /**
     * 通过一个Bean接收
     * post方式和get方式都可以
     * curl http://localhost:8080/test/testRequestBody\?reqId\=123\&name\=456 -X POST -d '{"reqId":"reqId","name":"name"}' -H 'Content-type: application/json'
     * ReqParam{reqId='123', name='456'}
     *
     * @param reqParam
     * @return
     */
//    @EnableLog
    @RequestMapping(path = "/testBean")
    public String testBean(ReqParam reqParam) {
        // testService.test("hello");
        return "test";
    }

    /**
     * 通过一个Map接收json数据
     * post方式和get方式都可以
     * curl http://localhost:8080/test/testRequestBody\?reqId\=123\&name\=456 -X POST -d '{"reqId":"reqId","name":"name"}' -H 'Content-type: application/json'
     * ReqParam{reqId='reqId', name='name'}
     *
     * @param reqParam
     * @return
     */
//    @EnableLog
    @RequestMapping(path = "/testRequestBodyMap")
    public String testRequestBodyMap(@RequestBody Map<String, String> reqParam) {
        // testService.test("hello");
        return "test";
    }

}
