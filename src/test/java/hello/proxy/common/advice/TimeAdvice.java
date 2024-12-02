package hello.proxy.common.advice;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

@Slf4j
public class TimeAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        log.info("타임 프록시 실행");
        long start = System.currentTimeMillis();

        Object result = invocation.proceed();


        long end = System.currentTimeMillis();
        log.info("time : {} ms", end - start);
        return result;
    }
}
