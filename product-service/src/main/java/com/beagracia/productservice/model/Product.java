package com.beagracia.productservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Objects;

@Document(value = "product")
public class Product {
    @Id
    private int id;
    private String name;
    private String description;
    private BigDecimal price;
    public Product(int id, String name, String description, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }
    public Product() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return getId() == product.getId() && getName().equals(product.getName()) && getDescription().equals(product.getDescription()) && getPrice().equals(product.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDescription(), getPrice());
    }

    // create builder
    public static ProductBuilder builder() {
        return new ProductBuilder();
    }

    public static class ProductBuilder {
        private final Product product;

        public ProductBuilder() {
            this.product = new Product();
        }

        public ProductBuilder withId(int id) {
            this.product.id = id;
            return this;
        }

        public ProductBuilder withName(String name) {
            this.product.name = name;
            return this;
        }

        public ProductBuilder withDescription(String description) {
            this.product.description = description;
            return this;
        }

        public ProductBuilder withPrice(BigDecimal price) {
            this.product.price = price;
            return this;
        }

        public Product build() {
            return this.product;
        }
    }

}
