package hello.proxy.proxyfactory;

import hello.proxy.common.advice.TimeAdvice;
import hello.proxy.common.service.ConCreteService;
import hello.proxy.common.service.ServiceImpl;
import hello.proxy.common.service.ServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.AopUtils;

@Slf4j
public class ProxyFactoryTest {

    @Test
    @DisplayName("인터페이스가 있으면 JDK 동적 프록시 실행")
    void interfaceProxy() {
        ServiceInterface target = new ServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.addAdvice(new TimeAdvice());
        ServiceInterface proxy = (ServiceInterface) proxyFactory.getProxy();
        log.info("target: {}", target.getClass());
        log.info("proxy: {}", proxy.getClass());
        proxy.save();

        boolean aopProxy = AopUtils.isAopProxy(proxy);
        boolean jdkDynamicProxy = AopUtils.isJdkDynamicProxy(proxy);
        boolean cglibProxy = AopUtils.isCglibProxy(proxy);
        log.info("aopProxy: {}", aopProxy);
        log.info("jdkDynamicProxy: {}", jdkDynamicProxy);
        log.info("cglibProxy: {}", cglibProxy);

    }


    @Test
    @DisplayName("구체클래스만 있으면 CGLIB 사용")
    void concreteProxy() {
        ConCreteService target = new ConCreteService();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.addAdvice(new TimeAdvice());
        ConCreteService proxy = (ConCreteService) proxyFactory.getProxy();
        log.info("target: {}", target.getClass());
        log.info("proxy: {}", proxy.getClass());
        proxy.call();

        boolean aopProxy = AopUtils.isAopProxy(proxy);
        boolean jdkDynamicProxy = AopUtils.isJdkDynamicProxy(proxy);
        boolean cglibProxy = AopUtils.isCglibProxy(proxy);
        log.info("aopProxy: {}", aopProxy);
        log.info("jdkDynamicProxy: {}", jdkDynamicProxy);
        log.info("cglibProxy: {}", cglibProxy);

    }


    @Test
    @DisplayName("ProxyTargetClass 옵션을 사용하면 인터페이스가 있어도 CGLIB 사용")
    void proxyTargetClass() {
        ServiceInterface target = new ServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.addAdvice(new TimeAdvice());
        proxyFactory.setProxyTargetClass(true);
        ServiceInterface proxy = (ServiceInterface) proxyFactory.getProxy();
        log.info("target: {}", target.getClass());
        log.info("proxy: {}", proxy.getClass());
        proxy.save();

        boolean aopProxy = AopUtils.isAopProxy(proxy);
        boolean jdkDynamicProxy = AopUtils.isJdkDynamicProxy(proxy);
        boolean cglibProxy = AopUtils.isCglibProxy(proxy);
        log.info("aopProxy: {}", aopProxy);
        log.info("jdkDynamicProxy: {}", jdkDynamicProxy);
        log.info("cglibProxy: {}", cglibProxy);

    }
}
