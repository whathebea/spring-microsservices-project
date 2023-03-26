package com.beagracia.orderservice.dto;

import java.util.List;
import java.util.Objects;

public class OrderRequest {
    private List<OrderLineItemsDto> orderLineItemsDtoList;

    public OrderRequest() {
        super();
    }

    public OrderRequest(List<OrderLineItemsDto> orderLineItemsDtoList) {
        this.orderLineItemsDtoList = orderLineItemsDtoList;
    }

    public List<OrderLineItemsDto> getOrderLineItemsDtoList() {
        return orderLineItemsDtoList;
    }

    public void setOrderLineItemsDtoList(List<OrderLineItemsDto> orderLineItemsDtoList) {
        this.orderLineItemsDtoList = orderLineItemsDtoList;
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                "orderLineItemsDtoList=" + orderLineItemsDtoList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderRequest that)) return false;
        return getOrderLineItemsDtoList().equals(that.getOrderLineItemsDtoList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderLineItemsDtoList());
    }
}
