package com.paluch.ecommerce.modules.user.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity(name = "user")
@Data
public class UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @NotBlank(message = "O nome do usuário não pode ser vazio")
  @Length(min = 1, max = 255, message = "O nome deve ter entre 1 e 255 caracteres")
  private String name;

  @NotBlank(message = "O e-mail não pode ser vazio")
  @Email(message = "O e-mail deve ser válido")
  private String email;

  @NotBlank(message = "A senha não pode ser vazia")
  @Length(min = 6, message = "A senha deve ter no mínimo 6 caracteres")
  private String password;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;
}
