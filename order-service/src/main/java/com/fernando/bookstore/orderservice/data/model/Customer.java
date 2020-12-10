package com.fernando.bookstore.orderservice.data.model;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Customer implements Serializable {
    
    private static final long serialVersionUID = 1089264305390859511L;

    private String uid;
    
    private String userId;

    private String name;

    private String lastName;

}
