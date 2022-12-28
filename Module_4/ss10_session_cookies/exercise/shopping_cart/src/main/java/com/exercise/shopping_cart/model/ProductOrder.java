package com.exercise.shopping_cart.model;

import javax.persistence.*;

@Entity
public class ProductOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrder;
    private Integer quantityOrder;
    @ManyToOne
    @JoinColumn(name = "idProduct")
    private Product product;

    public ProductOrder() {
    }

    public ProductOrder(Integer quantityOrder, Product product) {
        this.quantityOrder = quantityOrder;
        this.product = product;
    }

    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }

    public Integer getQuantityOrder() {
        return quantityOrder;
    }

    public void setQuantityOrder(Integer quantityOrder) {
        this.quantityOrder = quantityOrder;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
