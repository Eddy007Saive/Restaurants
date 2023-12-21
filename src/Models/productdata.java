/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author MEGATRON
 */
public class productdata {

    private Integer id;
    private String nom;
    private Integer prix;
    private String dispo;
     private String desc;
     private String cat;

    public String getDesc() {
        return desc;
    }

    public productdata(Integer id,String nom,String desc,String cat,Integer prix,String dispo) {
        this.id=id;
        this.nom=nom;
        this.desc=desc;
        this.prix=prix;
        this.dispo=dispo;
        this.cat=cat;

    }

    public String getCat() {
        return cat;
    }

    public Integer getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public Integer getPrix() {
        return prix;
    }

    public String getDispo() {
        return dispo;
    }
    

}
