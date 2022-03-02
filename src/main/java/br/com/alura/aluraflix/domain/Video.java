package br.com.alura.aluraflix.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TB_VIDEO")
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String url;

}
