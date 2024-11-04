package com.paluch.ecommerce.modules.order.entities;

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

import com.paluch.ecommerce.modules.user.entities.User;
import com.paluch.ecommerce.modules.cart.entities.Cart;
import com.paluch.ecommerce.modules.order.enums.OrderStatus;
import com.paluch.ecommerce.modules.address.entities.Address;

@Entity(name = "order")
@Data
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @OneToOne
  @JoinColumn(name = "cart_id", nullable = false)
  private Cart cart;

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
