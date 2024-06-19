package dev.bhuwanupadhyay.stockexchange;

class MatchingEngine {
    
    Context handleOrder(OrderBook orderBook, OrderEvent orderEvent) {
        if (orderEvent.getSequenceId() != nextSequence) {
            return Error(OUT_OF_ORDER, nextSequence);
        }
        if (!validateOrder(symbol, price, quantity)) {
            return Error(INVAID_ORDER, orderEvent);
        }
        Order order = createOrderFromEvent(orderEvent);
        switch (msgType) {
            case NEW:
                return handleNew(orderBook, order);
                break;
            case CANCEL:
                return handleCancel(orderBook, order);
                break;        
            default:
                return Error(INVAID_MSG_TYPE, orderEvent);
                break;
        }
    }

    Context handleNew(OrderBook orderBook, Order order) {
        if(BUY.equals(order.side)) {
            return match(orderBook.sellBook, order);
        } else {
            return match(orderBook.buyBook, order);
        }
    }

    Context handleCancel(OrderBook orderBook, Order order) {
        if(!orderBook.orderMap.contains(order.orderId)) {
            return Error(CANNOT_CANCEL_ALREADY_MATCHED, order);
        }
        removeOrder(order);
        setOrderStatus(order, CANCELLED);
        return Success(CANCEL_SUCCESS, order);
    }

    Context match(OrderBook orderBook, Order order) {
        Quantity leavesQuantity = order.quantity - order.matchingQuantity;
        Iterator<Order> limitIter = book.limitMap.get(order.price).orders;
        while(limitIter.hasNext() && leavesQuantity > 0) {
            Quantity matched = min()
        }
    }

}
