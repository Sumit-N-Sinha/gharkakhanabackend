package com.Gharkakhana.Controller;

import com.Gharkakhana.dto.Order1DTO;
import com.Gharkakhana.entity.Order1;
import com.Gharkakhana.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<String> createAOrder(@Valid @RequestBody Order1DTO orderDTO) {
        orderService.createOrder(orderDTO);
        return new ResponseEntity<>("Order created successfully", HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<Order1> fetchAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/get/{oid}")
    public ResponseEntity<Order1> getOrderById(@PathVariable int oid) {
        Order1 o = orderService.viewOrder(oid);
        return new ResponseEntity<>(o, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{oid}")
    public ResponseEntity<String> deleteAOrder(@PathVariable int oid) {
        orderService.deleteOrder(oid);
        return new ResponseEntity<>("Order deleted successfully", HttpStatus.OK);

    }

    @PutMapping("/update/{oid}")
    public ResponseEntity<String> updateAOrder(@RequestBody Order1DTO orderDTO, @PathVariable int oid) {
        orderService.updateOrder(orderDTO, oid);
        return new ResponseEntity<>("Order updated successfully", HttpStatus.OK);

    }

    @DeleteMapping("/cancel/{oid}")
    public ResponseEntity<String> cancelAOrder(@PathVariable int oid) {
        orderService.cancelOrder(oid);
        return new ResponseEntity<>("Order deleted successfully", HttpStatus.OK);
    }
}
