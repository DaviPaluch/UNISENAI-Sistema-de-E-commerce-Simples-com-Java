package com.paluch.ecommerce.modules.order.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import com.paluch.ecommerce.modules.order.enums.OrderStatus;
import com.paluch.ecommerce.modules.user.entity.UserEntity;
import com.paluch.ecommerce.modules.address.entity.Address;
import com.paluch.ecommerce.modules.cart.entity.CartEntity;

@Entity(name = "order")
@Data
public class OrderEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private UserEntity user;

  @OneToOne
  @JoinColumn(name = "cart_id", nullable = false)
  private CartEntity cart;

  @ManyToOne
  @JoinColumn(name = "address_id", nullable = false)
  private Address address;

  @NotNull(message = "O status do pedido não pode ser nulo")
  @Enumerated(EnumType.STRING) // Armazenar como string
  private OrderStatus status; // Usando a enumeração

  @NotNull(message = "O preço total do pedido não pode ser nulo")
  private BigDecimal totalPrice;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;
}
