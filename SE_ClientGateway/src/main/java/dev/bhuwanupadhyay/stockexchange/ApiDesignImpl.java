

package dev.bhuwanupadhyay.stockexchange;

import org.springframework.stereotype.Service;

@Service
class ApiDesignImpl implements ApiDesign{

    @Override
    public OrderExecutionResult placeOrder(PlaceOrderParameters parameters) {
        return null;
    }

    @Override
    public ListOrderExecutionResult listExecution(ListOrderExecutionParameters parameters) {
        return null;
    }

    
}