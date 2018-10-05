package ru.example.swagger.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "The database generate product ID")
    private Integer id;

    @Version
    @ApiModelProperty(notes = "The auto-generated version of the product")
    private Integer version;

    @ApiModelProperty(notes = "The application-specific product ID")
    private String productId;

    @ApiModelProperty(notes = "The product description")
    private String description;

    @ApiModelProperty(notes = "The image url of the property")
    private String imgUrl;

    @ApiModelProperty(notes = "The price of the product", required = true)
    private BigDecimal price;

}
