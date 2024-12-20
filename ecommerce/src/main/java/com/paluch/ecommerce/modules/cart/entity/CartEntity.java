package com.paluch.ecommerce.modules.cart.entity;

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
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import com.paluch.ecommerce.modules.address.entity.Address;
import com.paluch.ecommerce.modules.cart.enums.CartStatus;
import com.paluch.ecommerce.modules.user.entity.UserEntity;

@Entity(name = "cart")
@Data
public class CartEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private UserEntity user;

  @ManyToOne
  @JoinColumn(name = "address_id", nullable = false)
  private Address address;

  @NotNull(message = "O status do carrinho não pode ser nulo")
  @Enumerated(EnumType.STRING)
  private CartStatus status;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;
}
