package x.test.handler;

import x.test.entity.Context;

/**
 * @author x
 */
public class DefaultHandlerChain implements HandlerChain {

    private HandlerChain next;

    private Handler handler;

    @Override
    public void invoke(Context context) {
        handler.handle(context, this);
    }

    @Override
    public void fireNext(Context context) {
        if (this.next != null) {
            this.next.invoke(context);
        }
    }

}
