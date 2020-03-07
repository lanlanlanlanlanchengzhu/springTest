package x.test.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import x.test.handler.Handler;
import x.test.handler.SimpleHandler;
import x.test.handler.handler.DefaultInitHistoryDataHandler;
import x.test.handler.handler.DefaultInitHistoryDataSimpleHandler;
import x.test.handler.handler.DefaultInitParamHandler;
import x.test.handler.handler.DefaultInitParamSimpleHandler;
import x.test.handler.processor.StatelessProcessor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author x
 * @date 2020-03-07
 */
@Configuration
// @ComponentScan(basePackages = "x.test.handler.handler")
public class ProcessorFactory {

    @Bean
    public StatelessProcessor statelessProcessor() {
        List<SimpleHandler> simpleHandlers = new ArrayList<>();
        simpleHandlers.add(defaultInitParamSimpleHandler());
        simpleHandlers.add(defaultInitHistoryDataSimpleHandler());
        StatelessProcessor statelessProcessor = new StatelessProcessor();
        statelessProcessor.setSimpleHandlers(simpleHandlers);
        return statelessProcessor;
    }

    @Bean
    public DefaultInitParamHandler defaultInitParamHandler() {
        return new DefaultInitParamHandler();
    }

    // 如果使用@Service注解，此处就不能使用@Bean注解，二者会产生冲突
    @Bean
    public DefaultInitHistoryDataHandler defaultInitHistoryDataHandler() {
        return new DefaultInitHistoryDataHandler();
    }


    @Bean
    public DefaultInitParamSimpleHandler defaultInitParamSimpleHandler() {
        return new DefaultInitParamSimpleHandler();
    }

    // 如果使用@Service注解，此处就不能使用@Bean注解，二者会产生冲突
    @Bean
    public DefaultInitHistoryDataSimpleHandler defaultInitHistoryDataSimpleHandler() {
        return new DefaultInitHistoryDataSimpleHandler();
    }

}
