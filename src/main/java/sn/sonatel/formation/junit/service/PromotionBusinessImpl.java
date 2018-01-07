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

        double promo = promoCalculatorService.calculate(nomProduit, prix);
        return prix  - (prix * promo);
    }


}
