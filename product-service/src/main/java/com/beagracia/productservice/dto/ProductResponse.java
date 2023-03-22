package com.beagracia.productservice.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class ProductResponse {
    private int id;
    private String name;
    private String description;
    private BigDecimal price;

    public ProductResponse(int id, String name, String description, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public ProductResponse() {
        super();
    }

    public static Builder builder() {
        return new Builder();
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
        return "ProductResponse{" + "id=" + id + ", name='" + name + '\'' + ", description='" + description + '\'' + ", price=" + price + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductResponse that)) return false;
        return getId() == that.getId() && getName().equals(that.getName()) && getDescription().equals(that.getDescription()) && getPrice().equals(that.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDescription(), getPrice());
    }

    public static class Builder {
        private int id;
        private String name;
        private String description;
        private BigDecimal price;

        public Builder withId(int id) {
            this.id = id;
            return this;
        }

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

        public ProductResponse build() {
            return new ProductResponse(id, name, description, price);
        }
    }
}
