package com.ufu.facom.citiesapp.countries.entities;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.*;

@Table(name = "pais")
@Entity
public class Country {
    public Country() {
    }

    public Country(Long id, String nome, String nomePt, String sigla, Integer bacen) {
        this.id = id;
        this.nome = nome;
        this.nomePt = nomePt;
        this.sigla = sigla;
        this.bacen = bacen;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome", length = 60)
    private String nome;

    @Column(name = "nome_pt", length = 60)
    private String nomePt;

    @Column(name = "sigla", length = 2)
    private String sigla;

    @Column(name = "bacen")
    private Integer bacen;

    public Integer getBacen() {
        return bacen;
    }

    public void setBacen(Integer bacen) {
        this.bacen = bacen;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNomePt() {
        return nomePt;
    }

    public void setNomePt(String nomePt) {
        this.nomePt = nomePt;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static interface CountryRepository extends JpaRepository<Country,Long> {
    }
}