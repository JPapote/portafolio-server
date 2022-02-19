/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolioServer.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Antonio
 */
@Getter @Setter
@Entity
public class HabilidadesDurasBlandas implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
     private String nombre;
     @Max(value=10, message="El nivel maximo 10")
     private int nivel;
     
    
}
