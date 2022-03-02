package br.com.alura.aluraflix.domain;

import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "TB_VIDEO")
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank
    private String title;

    @Column(nullable = false)
    @NotBlank
    private String description;

    @Column(nullable = false)
    @NotBlank
    @URL(message = "A URL informada é inválida!")
    private String url;

}
