package sn.sonatel.formation.junit.service;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by ext_sow18 on 03/01/2018.
 */
public class PromotionBusinessImplTest {

    static PromotionBusiness promotionBusiness ;

    @BeforeClass
    public static void setUp(){
        promotionBusiness = new PromotionBusinessImpl(new PromoCalculatorServiceImpl());
    }


    @Test
    public void doitAppliquer15PourcentRemiseSurProduitAnanasCoutant100() throws Exception {
    //    PromotionBusiness promotionBusiness = new PromotionBusinessImpl(new PromoCalculatorServiceImpl());
        double resultat = promotionBusiness.appliquerRemisePromotionnelleSurPrix(100.0, "Ananas");
        //assertEquals(85.0, resultat,0);
        assertThat(resultat, is(85.0));
    }

    @Test
    public void doitAppliquer5PourcentRemiseSurProduitBananeCoutant100() throws Exception {
    //    PromotionBusiness promotionBusiness = new PromotionBusinessImpl(new PromoCalculatorServiceImpl());
        double resultat = promotionBusiness.appliquerRemisePromotionnelleSurPrix(100.0, "Banane");
        assertEquals(95.0, resultat,0);
    }

    @Test
    public void doitAppliquer7PourcentRemiseSurProduitDontPrixSuperieurA500() throws Exception {
    //    PromotionBusiness promotionBusiness = new PromotionBusinessImpl(new PromoCalculatorServiceImpl());
        double resultat = promotionBusiness.appliquerRemisePromotionnelleSurPrix(1000.0, "Banane");
        assertEquals(930.0, resultat,0);
    }

    @Test
    public void doitAppliquer15PourcentRemiseSurProduitAnanasCoutant600() throws Exception {
    //    PromotionBusiness promotionBusiness = new PromotionBusinessImpl(new PromoCalculatorServiceImpl());
        double resultat = promotionBusiness.appliquerRemisePromotionnelleSurPrix(600.0, "Ananas");
        assertEquals(498.0, resultat,0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void doitjeterUneIllegalArgumentException() {
    //    PromotionBusiness promotionBusiness = new PromotionBusinessImpl(new PromoCalculatorServiceImpl());
        double resultat = promotionBusiness.appliquerRemisePromotionnelleSurPrix(null, "Ananas");
    }

    @Test(expected = IllegalArgumentException.class)
    public void doitJeterUneIllegalArgumentExceptionPourPrixZero() {
        //    PromotionBusiness promotionBusiness = new PromotionBusinessImpl(new PromoCalculatorServiceImpl());
        double resultat = promotionBusiness.appliquerRemisePromotionnelleSurPrix(0.0, "Ananas");
    }

}