package br.com.binsolution.ecs_fargate_cdk_01.model;

import java.util.Objects;

public class ProductEvent {
    private Long productId;
    private String code;
    private String username;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEvent that = (ProductEvent) o;
        return Objects.equals(productId, that.productId) && Objects.equals(code, that.code) && Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, code, username);
    }

    @Override
    public String toString() {
        return "ProductEvent{" +
                "productId=" + productId +
                ", code='" + code + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
