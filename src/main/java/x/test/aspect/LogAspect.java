package x.test.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    @Pointcut("@annotation(x.test.annotion.EnableLog)")
    public void log () {}

    @Before("log()")
    public void logActual (JoinPoint joinPoint) {
    }

}
