package sn.sonatel.formation.junit.service;

/**
 * Created by ext_sow18 on 03/01/2018.
 */

public class PromotionBusinessImpl implements PromotionBusiness {


    PromoCalculatorService promoCalculatorService;

    public PromotionBusinessImpl(PromoCalculatorService promoCalculatorService) {
        this.promoCalculatorService = promoCalculatorService;
    }

    public Double appliquerRemisePromotionnelleSurPrix(Double prix, String nomProduit) {

        // verifier quelques regles metier

        double promo = promoCalculatorService.calculate(nomProduit, prix);
        //retourner le prix après application des règles
        return prix  - (prix * promo);
    }


}
