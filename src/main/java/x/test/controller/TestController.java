package x.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import x.test.model.ReqParam;
import x.test.service.TestService;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping(path = "/test")
public class TestController {

    @Autowired
    TestService testService;

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
        System.out.println(reqId + name);
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
        System.out.println(httpServletRequest.getParameter("reqId"));
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
        System.out.println(reqParam);
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
        System.out.println(reqParam);
        // testService.test("hello");
        return "test";
    }

    /**
     * 通过一个Bean接收json数据
     * post方式和get方式都可以
     * curl http://localhost:8080/test/testRequestBody\?reqId\=123\&name\=456 -X POST -d '{"reqId":"reqId","name":"name"}' -H 'Content-type: application/json'
     * ReqParam{reqId='reqId', name='name'}
     *
     * @param reqParam
     * @return
     */
//    @EnableLog
    @RequestMapping(path = "/testRequestBody")
    public String testRequestBody(@RequestBody ReqParam reqParam) {
        System.out.println(reqParam);
         testService.test(reqParam);
        return "test";
    }

}
