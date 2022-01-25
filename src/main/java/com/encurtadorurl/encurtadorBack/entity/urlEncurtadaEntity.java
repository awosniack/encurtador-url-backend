package com.encurtadorurl.encurtadorBack.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "URL")
public class urlEncurtadaEntity {
    @Id
    @Column(name="id", nullable=false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="urlencurtada", nullable = false)
    private String urlEncurtada;

    @Column(name="urloriginal", nullable = false)
    private String urlOriginal;
}
