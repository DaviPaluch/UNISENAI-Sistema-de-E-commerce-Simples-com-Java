package com.paluch.ecommerce.modules.payment.entities;

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
import jakarta.persistence.OneToOne;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import com.paluch.ecommerce.modules.order.entities.Order;
import com.paluch.ecommerce.modules.payment.enums.PaymentMethod;
import com.paluch.ecommerce.modules.payment.enums.PaymentStatus;

@Entity(name = "payment")
@Data
public class Payment {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @OneToOne
  @JoinColumn(name = "order_id", nullable = false)
  private Order order;

  @NotNull(message = "O valor do pagamento não pode ser nulo")
  private BigDecimal amount;

  @NotNull(message = "O método de pagamento não pode ser nulo")
  @Enumerated(EnumType.STRING)
  private PaymentMethod method;

  @NotNull(message = "O status do pagamento não pode ser nulo")
  @Enumerated(EnumType.STRING)
  private PaymentStatus status;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;
}
