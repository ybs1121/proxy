package hello.proxy.pureproxy.decorator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeDecorator implements Component {
    private Component component;

    public TimeDecorator(Component component) {
        this.component = component;
    }

    @Override
    public String operation() {
        long start = System.currentTimeMillis();
        log.info("TimeDecorator operation");
        String operation = component.operation();
        long end = System.currentTimeMillis();
        log.info("TimeDecorator operation cost " + (end - start) + "ms");
        return operation;
    }
}
