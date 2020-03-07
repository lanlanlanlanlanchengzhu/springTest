package x.test.handler;

import x.test.entity.Context;

public interface HandlerChain {

    void invoke(Context context);

    void fireNext(Context context);

}
