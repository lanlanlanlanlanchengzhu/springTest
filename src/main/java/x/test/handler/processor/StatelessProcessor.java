package x.test.handler.processor;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import x.test.entity.Context;
import x.test.handler.Handler;
import x.test.handler.SimpleHandler;

import java.util.List;

/**
 * @author x
 * @date 2020-03-07
 */
@Data
@Slf4j
public class StatelessProcessor {

    List<SimpleHandler> simpleHandlers;

    public void invoke() {
        log.info("StatelessProcessor.invoke");
        Context context = new Context();
        for (SimpleHandler simpleHandler: simpleHandlers) {
            simpleHandler.handle(context);
        }
        log.info(context.toString());
    }

}
