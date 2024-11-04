package com.paluch.ecommerce.modules.product.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import lombok.Data;

@Entity(name = "product")
@Data
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @NotBlank(message = "O nome do produto não pode ser vazio")
  @Length(min = 1, max = 255, message = "O nome do produto deve ter entre 1 e 255 caracteres")
  private String name;

  @NotBlank(message = "A descrição do produto não pode ser vazia")
  private String description;

  @Positive(message = "O preço do produto deve ser positivo")
  private BigDecimal price;

  @NotBlank(message = "A URL da imagem não pode ser vazia")
  @URL(message = "A URL da imagem deve ser válida")
  private String imageUrl;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;
}
