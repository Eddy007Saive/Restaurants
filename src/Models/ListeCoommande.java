/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author MEGATRON
 */
public class ListeCoommande {
    
    private int idCom;
    private String Nom;
    private int qt;
    private int Montant;
    private int prix;

    public ListeCoommande(int idCom, String Nom, int qt,int prix, int Montant ) {
        this.idCom = idCom;
        this.Nom = Nom;
        this.qt = qt;
        this.Montant = Montant;
        this.prix = prix;
    }

    public int getPrix() {
        return prix;
    }
  

    public int getIdCom() {
        return idCom;
    }

    public String getNom() {
        return Nom;
    }

    public int getQt() {
        return qt;
    }

    public int getMontant() {
        return Montant;
    }
    
    
    
}
