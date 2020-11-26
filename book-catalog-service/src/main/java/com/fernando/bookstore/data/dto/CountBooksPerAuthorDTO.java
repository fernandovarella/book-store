package com.fernando.bookstore.data.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class CountBooksPerAuthorDTO {
    
    private String _id;
    private String authors;
    private Integer count;

}
