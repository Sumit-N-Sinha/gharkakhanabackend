package com.Gharkakhana.service;

import com.Gharkakhana.dto.Order1DTO;
import com.Gharkakhana.entity.Order1;

import java.util.List;

public interface OrderService {
    public void createOrder(Order1DTO orderDTO);
    public List<Order1> getAllOrders();
    public void cancelOrder(int orderId);
    public void deleteOrder(int orderId);
    public void updateOrder(Order1DTO orderDTO, int id);
    public Order1 viewOrder(int oid);


}
