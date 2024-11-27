package hello.proxy.pureproxy.decorator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageDecorator implements Component {
    private Component component;

    public MessageDecorator(Component component) {
        this.component = component;
    }

    @Override
    public String operation() {
        log.info("MessageDecorator operation");
        String operation = component.operation();
        String decoResult = "$$$$$$$" + operation + "$$$$$$$";
        log.info("before operation: {}", operation);
        log.info("after operation: {}", decoResult);
        return decoResult;
    }
}
