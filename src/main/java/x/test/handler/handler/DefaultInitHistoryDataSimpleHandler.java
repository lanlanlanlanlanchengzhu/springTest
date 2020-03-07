package x.test.handler.handler;

import lombok.extern.slf4j.Slf4j;
import x.test.entity.Context;
import x.test.handler.Handler;
import x.test.handler.HandlerChain;
import x.test.handler.SimpleHandler;

/**
 * @author x
 * @date 2020-03-07
 */
@Slf4j
public class DefaultInitHistoryDataSimpleHandler implements SimpleHandler {

    @Override
    public void handle(Context context) {
        log.info("DefaultInitHistoryDataSimpleHandler.handle");
    }

}
