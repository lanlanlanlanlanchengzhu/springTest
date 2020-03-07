package x.test.handler.handler;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import x.test.entity.Context;
import x.test.handler.Handler;
import x.test.handler.HandlerChain;
import x.test.model.dto.ReqParam;

import java.util.HashMap;

/**
 * @author x
 * @date 2020-03-07
 */
public class DefaultInitParamHandler implements Handler {

    private ReqParam reqParam;

    @Override
    public void handle(Context context, HandlerChain handlerChain) {
        init(context);
    }

    protected void init(Context context) {
        context = new Context();
        if (StringUtils.isNoneBlank(reqParam.getReqId())) {
            context.reqId = reqParam.getReqId();
        }
        context.count = 0;
    }

}
