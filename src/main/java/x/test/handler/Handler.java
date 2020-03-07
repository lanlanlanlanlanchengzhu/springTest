package x.test.handler;

import x.test.entity.Context;

public interface Handler {

    void handle(Context context, HandlerChain handlerChain);

}
