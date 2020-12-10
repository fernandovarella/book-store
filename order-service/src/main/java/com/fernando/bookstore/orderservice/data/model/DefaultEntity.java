package com.fernando.bookstore.orderservice.data.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public abstract class DefaultEntity  {

    @Id
    private String id;

    @JsonIgnore
    @CreatedDate
    private Date createdAt;

    @JsonIgnore
    @LastModifiedDate
    private Date updatedAt;

    @Version
    private Long version;

}