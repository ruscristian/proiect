package sci.final_project.logistics_system.order;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sci.final_project.logistics_system.destination.DestinationEntity;
import sci.final_project.logistics_system.destination.DestinationRepository;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {


 private final OrdersService ordersService;
 private final OrdersRepository ordersRepository;
 private final DestinationRepository destinationRepository;

    public OrderController(OrdersService ordersService, OrdersRepository ordersRepository, DestinationRepository destinationRepository) {
        this.ordersService = ordersService;
        this.ordersRepository = ordersRepository;
        this.destinationRepository = destinationRepository;
    }


    @GetMapping("/get")
    public List<OrdersEntity> getOrders(){
        return ordersRepository.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<OrdersEntity> addOrder(@RequestBody OrdersEntity payload) throws IllegalArgumentException {
        return ordersService.addOrder(payload, destinationRepository);
    }
}
