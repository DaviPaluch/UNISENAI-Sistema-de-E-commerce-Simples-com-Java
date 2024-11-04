package com.paluch.ecommerce.modules.address.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import com.paluch.ecommerce.modules.user.entities.User;

@Entity(name = "address")
@Data
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @NotBlank(message = "A rua não pode ser vazia")
  @Length(max = 255, message = "A rua deve ter no máximo 255 caracteres")
  private String street;

  @NotBlank(message = "O número não pode ser vazio")
  @Length(max = 10, message = "O número deve ter no máximo 10 caracteres")
  private String number;

  @NotBlank(message = "A cidade não pode ser vazia")
  @Length(max = 100, message = "A cidade deve ter no máximo 100 caracteres")
  private String city;

  @NotBlank(message = "O estado não pode ser vazio")
  @Length(max = 100, message = "O estado deve ter no máximo 100 caracteres")
  private String state;

  @NotBlank(message = "O código postal não pode ser vazio")
  @Pattern(regexp = "\\d{5}-\\d{3}", message = "O código postal deve estar no formato 00000-000")
  private String zipCode;

  @NotBlank(message = "O país não pode ser vazio")
  @Length(max = 100, message = "O país deve ter no máximo 100 caracteres")
  private String country;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;

  private Boolean isDefault;
}
