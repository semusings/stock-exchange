package dev.bhuwanupadhyay.stockexchange;



public class ApplicationLoop {

    private OrderManager orderManager;
    private MatchingEngine matchingEngine;

    // pull events -> NewOrderEvent
    public void onNewOrderEvent(NewOrderEvent event) {
           if (!orderManager.canValidated()) {
                return;
           } 
           OrderBook orderBook = orderManager.updateOrderState();

           matchingEngine.handleOrder(orderBook, event);

    }
    
}
