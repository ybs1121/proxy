package hello.proxy.cglib;

import hello.proxy.common.service.ConCreteService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;

@Slf4j
public class CglibTest {

    @Test
    void cglib() {
        ConCreteService target = new ConCreteService();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ConCreteService.class);
        enhancer.setCallback(new TimeMethodInterceptor(target));
        ConCreteService proxy = (ConCreteService) enhancer.create();
        proxy.call();
        log.info("targetClass: {}", target.getClass());
        log.info("proxyClass: {}", proxy.getClass());

    }
}
