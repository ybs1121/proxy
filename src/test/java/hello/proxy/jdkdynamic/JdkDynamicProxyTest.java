package hello.proxy.jdkdynamic;

import hello.proxy.jdkdynamic.code.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

@Slf4j
public class JdkDynamicProxyTest {

    @Test
    void dynamicA() {
        AInterface target = new AImpl();
        TimeInvocationHandler timeInvocationHandler = new TimeInvocationHandler(target);

        AInterface proxy = (AInterface)Proxy.newProxyInstance(AInterface.class.getClassLoader(), new Class[]{AInterface.class}, timeInvocationHandler);
        proxy.call();
        log.info("target = {}", target.getClass());
        log.info("proxy = {}", proxy.getClass());
    }

    @Test
    void dynamicB() {
        BInterface target = new BImpl();
        TimeInvocationHandler timeInvocationHandler = new TimeInvocationHandler(target);

        BInterface proxy = (BInterface)Proxy.newProxyInstance(BInterface.class.getClassLoader(), new Class[]{BInterface.class}, timeInvocationHandler);
        proxy.call();
        log.info("target = {}", target.getClass());
        log.info("proxy = {}", proxy.getClass());
    }
}
