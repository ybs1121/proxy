package hello.proxy.pureproxy.concreteproxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeProxy extends ConcreteLogic {

    private ConcreteLogic concreteLogic;

    public TimeProxy(ConcreteLogic concreteLogic) {
        this.concreteLogic = concreteLogic;
    }

    @Override
    public String operation() {
        long start = System.currentTimeMillis();
        log.info("TimeDecorator operation");
        String operation = concreteLogic.operation();
        long end = System.currentTimeMillis();
        log.info("TimeDecorator operation cost " + (end - start) + "ms");
        return operation;
    }
}
