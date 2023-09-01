package com.ecom.order.others;

import com.ecom.order.entity.Orders;

public class CustomResponse {

    private Orders order;
    private String message;

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public CustomResponse(Orders order, String message) {
        this.order = order;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
