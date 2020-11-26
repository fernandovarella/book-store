package com.fernando.bookstore.data.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.data.annotation.LastModifiedDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
// @Document(value = "stock")
// public class Stock extends DefaultEntity {
public class Stock implements Serializable {

    private static final long serialVersionUID = 1L;

    // @DBRef(lazy = true)
    // private Book book;

    private Long quantity;

    @JsonIgnore
    @LastModifiedDate
    private Date updatedAt;

}
