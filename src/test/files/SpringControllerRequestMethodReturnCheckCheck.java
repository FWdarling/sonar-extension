import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.persistence.Entity;

@Controller
public class HelloController {

    @RequestMapping("/updateOrder") // Noncompliant
    public Order updateOrder(Order order) {
        return null;
    }

    public Order updateOrder2(Order order) { // Compliant
        return null;
    }

    @RequestMapping("/client")
    public Client getClient(){return null;}

    public Client getClient2(){return null;}

    @Entity
    public class Order {
        String ordered;
    }

    public class Client {
        String cliendId;
    }
}

class HelloClass {

    @RequestMapping("/updateOrder")
    public Order updateOrder(Order order) { // Compliant
        return null;
    }


    @Entity
    public class Order {
        String ordered;
    }
}
