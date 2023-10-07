package hw.hw13;

import java.util.LinkedList;
import java.util.Queue;

class CoffeeOrderBoard {
    private Queue<Order> orderQueue;
    private int orderNumber;

    public CoffeeOrderBoard() {
        orderQueue = new LinkedList<>();
        orderNumber = 1;
    }
    public void add(Order order) {
        order.setNumber(orderNumber++);
        orderQueue.offer(order);
    }
    public void deliver() {
        if (!orderQueue.isEmpty()) {
            Order order = orderQueue.poll();
            System.out.println("Delivering order " + order.getNumber() + " for " + order.getName());
        } else {
            System.out.println("No orders to deliver.");
        }
    }
    public void deliver(int orderNumber) {
        for (Order order : orderQueue) {
            if (order.getNumber() == orderNumber) {
                System.out.println("Delivering order " + order.getNumber() + " for " + order.getName());
                orderQueue.remove(order);
                return;
            }
        }
        System.out.println("Order with number " + orderNumber + " not found.");
    }
    public void draw() {
        System.out.println("=====================");
        System.out.println("Num | Name");
        for (Order order : orderQueue) {
            System.out.println(order.getNumber() + " | " + order.getName());
        }
        System.out.println("=====================");
    }
}