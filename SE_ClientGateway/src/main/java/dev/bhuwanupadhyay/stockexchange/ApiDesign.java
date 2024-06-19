package dev.bhuwanupadhyay.stockexchange;

import java.util.List;

interface ApiDesign {

        OrderExecutionResult placeOrder(PlaceOrderParameters parameters);

        ListOrderExecutionResult listExecution(ListOrderExecutionParameters parameters);

}

record PlaceOrderParameters(
                String symbol,
                String side,
                Double price,
                String orderType,
                Long quantity) {

}

record OrderExecutionResult(
                Long id,
                Long creationTime,
                Long filledQuantity,
                Long remainingQuanity,
                String status,
                String symbol,
                String side,
                Double price,
                String orderType,
                Long quantity) {

}

record ListOrderExecutionParameters(
                String symbol,
                Long orderId,
                Long startTime,
                Long endTime,
                Integer pageNumber,
                Integer pageSize) {
}

record ListOrderExecutionObjectResult(
                Long id,
                Long orderId,
                String symbol,
                String side,
                Double price,
                String orderType,
                Long quantity) {
}

record ListOrderExecutionResult(
                List<ListOrderExecutionObjectResult> results,
                Long totalCount) {
}
