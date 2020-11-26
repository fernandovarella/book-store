package com.fernando.bookstore.data.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(value = "books")
@JsonInclude(Include.NON_ABSENT)
public class Book extends DefaultEntity {
    
    private static final long serialVersionUID = 7596222660798490812L;

    private String isbn;

    private String title;

    @Field("original_title")
    private String originalTitle;

    @Field("original_publication_year")
    private Integer publicationYear;

    @Field("average_rating")
    private Double averageRating;

    @Field("ratings_count")
    private Integer ratingsCount;

    @Field("image_url")
    private String imgUrl;

    @Field("small_image_url")
    private String imgUrlSmall;

    private List<String> authors;

    private Stock stock;

    @DBRef(lazy = true)
    private List<StockIn> stockIns;

    @DBRef
    private List<StockOut> stockOuts = new ArrayList<>();


}
