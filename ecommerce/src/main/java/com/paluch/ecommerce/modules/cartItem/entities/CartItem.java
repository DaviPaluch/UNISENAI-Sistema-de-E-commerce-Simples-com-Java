package com.paluch.ecommerce.modules.cartItem.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import com.paluch.ecommerce.modules.cart.entities.Cart;
import com.paluch.ecommerce.modules.product.entities.Product;

@Entity(name = "cart_item")
@Data
public class CartItem {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @ManyToOne
  @JoinColumn(name = "cart_id", nullable = false)
  private Cart cart;

  @OneToOne
  @JoinColumn(name = "product_id", nullable = false)
  private Product product;

  @NotNull(message = "A quantidade do produto não pode ser nula")
  @Min(value = 1, message = "A quantidade deve ser pelo menos 1")
  private Integer quantity;

  @NotNull(message = "O preço do produto não pode ser nulo")
  private BigDecimal price;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;
}
