package hello.proxy.cglib;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

@Slf4j
public class TimeMethodInterceptor implements MethodInterceptor {

    private final Object target;

    public TimeMethodInterceptor(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        log.info("타임 프록시 실행");
        long start = System.currentTimeMillis();
        Object result = methodProxy.invoke(target, args);
//        Object result = method.invoke(target, args);
        long end = System.currentTimeMillis();
        log.info("time : {} ms", end - start);
        return result;
    }
}
