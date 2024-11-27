package hello.proxy.pureproxy.decorator;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class DecoratorTest {

    @Test
    void noDecorator() {
        Component realComponent = new RealComponent();
        DecoratorClient decoratorClient = new DecoratorClient(realComponent);
        decoratorClient.execute();
    }

    @Test
    void decorator1() {
        Component realComponent = new RealComponent();
        Component messageDecorator = new MessageDecorator(realComponent);
        DecoratorClient decoratorClient = new DecoratorClient(messageDecorator);
        decoratorClient.execute();
    }

    @Test
    void decorator2() {
        Component realComponent = new RealComponent();
        Component messageDecorator = new MessageDecorator(realComponent);
        Component timeDecorator = new TimeDecorator(messageDecorator);
        DecoratorClient decoratorClient = new DecoratorClient(timeDecorator);
        decoratorClient.execute();
    }
}
