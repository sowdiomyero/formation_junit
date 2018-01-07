package sn.sonatel.formation.junit.service;

/**
 * Created by ext_sow18 on 03/01/2018.
 */
public class PromoCalculatorServiceImpl implements PromoCalculatorService{


    public double calculate(String nomProduit, Double prix) {
        return getPromotionSurMontant(prix, getPromotionSurCategorie(nomProduit));
    }

    public double getPromotionSurCategorie (String nomProduit){

        if(nomProduit == null)
            throw new  IllegalArgumentException (" F310 : Vous devez obligatoirement renseigner un nom de produit");

        double result = 0.0;

        if(nomProduit.startsWith("A"))
            result = 0.15;

        if(nomProduit.startsWith("B"))
            result = 0.05;

        return result;
    }

    public double getPromotionSurMontant(Double prix, Double promo){

        if(prix == null || prix == 0.0 )
            throw new  IllegalArgumentException (" F311 : Vous devez obligatoirement renseigner un prix de produit");


        if(prix > 500)
            return promo + 0.02;
        return promo;
    }
}
