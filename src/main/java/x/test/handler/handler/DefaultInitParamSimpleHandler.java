package x.test.handler.handler;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import x.test.entity.Context;
import x.test.handler.Handler;
import x.test.handler.HandlerChain;
import x.test.handler.SimpleHandler;
import x.test.model.dto.ReqParam;

/**
 * @author x
 * @date 2020-03-07
 */
@Slf4j
public class DefaultInitParamSimpleHandler implements SimpleHandler {

    private ReqParam reqParam;

    @Override
    public void handle(Context context) {
        init(context);
    }

    protected void init(Context context) {
        if (ObjectUtils.isNotEmpty(reqParam) && StringUtils.isNoneBlank(reqParam.getReqId())) {
            context.reqId = reqParam.getReqId();
        }
        context.count = 0;
        log.info("DefaultInitParamSimpleHandler.handle");
    }

}
