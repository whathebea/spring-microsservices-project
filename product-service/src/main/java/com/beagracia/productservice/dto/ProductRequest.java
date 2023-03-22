package com.beagracia.productservice.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class ProductRequest {
    private String name;
    private String description;
    private BigDecimal price;

    public ProductRequest(String name, String description, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public ProductRequest() {
        super();
    }

    public static Builder builder() {
        return new Builder();
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
        return "ProductRequest{" + "name='" + name + '\'' + ", description='" + description + '\'' + ", price=" + price + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductRequest that)) return false;
        return getName().equals(that.getName()) && getDescription().equals(that.getDescription()) && getPrice().equals(that.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDescription(), getPrice());
    }

    public static class Builder {
        private String name;
        private String description;
        private BigDecimal price;

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public ProductRequest build() {
            return new ProductRequest(name, description, price);
        }
    }
}
