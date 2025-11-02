package com.example.accesdades.ra2.ac1.acess_dades.Model;

public class student {
    
    private long id;
    private String nom;
    private String cognom;
    private int age;
    private String cicle;
    private int any_curs;
    

    public student() {
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getCognom() {
        return cognom;
    }
    public void setCognom(String cognom) {
        this.cognom = cognom;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getCicle() {
        return cicle;
    }
    public void setCicle(String cicle) {
        this.cicle = cicle;
    }

    public int getAny_curs() {
        return any_curs;
    }

    public void setAny_curs(int any_curs) {
        this.any_curs = any_curs;
    }


}
