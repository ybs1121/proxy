package hello.proxy.app.v1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping//스프링 @Controller OR RequestMapping 어노테이션이 있어야 스프링 컨트롤러로 인식
@ResponseBody
public class OrderControllerV1Impl implements OrderControllerV1{
    
    private final OrderServiceV1 orderService;

    public OrderControllerV1Impl(OrderServiceV1 orderService) {
        this.orderService = orderService;
    }


    @Override
    public String request(String itemId) {
        return "ok";
    }

    @Override
    public String noLog() {
        return "ok";
    }
}
