/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolioServer.model;

/**
 *
 * @author Antonio
 */
public class ImagenBase64 {
    private String name;
    private int size;
    private String type;
    private StringBuffer base64;

    
    public ImagenBase64(String name, int size, String type, StringBuffer base64){
        
        this.name = name;
        this.size = size;
        this.type = type;
        this.base64 = base64;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the base65
     */
    public StringBuffer getBase65() {
        return base64;
    }

    /**
     * @param base64 the base65 to set
     */
    public void setBase64(StringBuffer base64) {
        this.base64 = base64;
    }
}
