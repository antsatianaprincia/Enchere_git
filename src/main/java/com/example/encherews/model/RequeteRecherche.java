package com.example.encherews.model;

import lombok.Data;

import java.sql.Date;

@Data
public class RequeteRecherche {

    private String description; //(mot clé)

    private Date dateDebut;

    private Date dateFin;
    private Category categorie;
    private double prixMin;
    private double prixMax;
    private int status; //(isClosed)

    //requete pour le mot cle
    public String reqDescription(){
        String req = "";
        if (this.description==null){
            req+="descriptions ilike '%%'";
        }
        else {
            req+="descriptions ilike '%"+this.description+"%'";
        }

        return req;
    }

    public String reqDate(){
        String req = "";

        if(this.dateDebut != null && this.dateFin != null){
            req += " and pubdate BETWEEN '"+dateDebut+"' and '"+dateFin+"'";
            return req;
        }

        if(this.dateDebut == null && this.dateFin != null){
            req += " and pubdate::text LIKE '%"+dateFin+"%'";
            return req;
        }

        if(this.dateDebut != null && this.dateFin == null){
            req += " and pubdate::text LIKE '%"+dateDebut+"%'";
            return req;
        }

        else{
            req+="";
        }


        return req;
    }

    public String reqCategory(){
        String req = "";
        if (this.categorie==null){
          //  req+="description like '%%'";
            req+="";
            return req;
        }
        else {
            req+="and idcategory ="+this.categorie.getId();
        }

        return req;
    }

    public String reqPrix(){
        String req = "";
        if (this.prixMin==0){
            req+="price >0";

            if (this.prixMax==0){
                req+="";
            }
        }
        else {
            req+="price >"+this.prixMin;

            if (this.prixMax==0){
                req+="";
            }

            else {
                req+=" and price <"+this.prixMax;
            }
        }
        return req;
    }

    public String reqStatut(){
        String req = "";
        if (this.status>1){
            req+="";
            return req;
        }
        else {
            req+=" and isClosed ="+this.status;
        }

        return req;
    }


    public String reqFinale(){
        String req = "Select auction.*,products.idcategory from auction join products on auction.idproducts=products.id where 1=1 ";

        req+="and "+reqDescription()+reqDate()+reqCategory()+" and "+reqPrix()+reqStatut();

        return req;
    }

    public static void main(String[] args) {
        RequeteRecherche req = new RequeteRecherche();
        Category c = new Category();
        c.setId(1);
        req.setDescription("v");
        req.setDateDebut(Date.valueOf("2023-02-02"));
        req.setDateFin(Date.valueOf("2023-02-04"));
        req.setCategorie(c);
        req.setPrixMin(1);
        req.setPrixMax(1000);
        req.setStatus(0);

        String val = req.reqFinale();

        System.out.println(val);
    }

}
