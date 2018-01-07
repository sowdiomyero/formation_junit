package sn.sonatel.formation.junit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ext_sow18 on 03/01/2018.
 */
public class CalculatorTest {


    /*
    *  Dans une classe sn.sonatel.formation.junit.service.PromotionBusiness.java :
    *  Ecrire une fonction qui prend deux valeurs en parametre : prix produit et nom du produit
    *  Puis si le nom du produit commence par A, appliquer une réduction promotionnelle de 15% sur le prix du produit.
    *  Si le produit commence par B, appliquer 5% de remise.
    *  Si le prix du produit est superieur à 500 francs, appliquer une réduction de 5%
    * */

    @Test
    public void shoudReturn20(){
        int valeurDeRetour = 40/5;
        assertEquals(8, valeurDeRetour);
    }

    @Test
    public void shoudReturn8(){
        int valeurDeRetour = 4*2;
        assertEquals(8, valeurDeRetour);
    }

    @Test
    public void shoudReturnZero(){
        int valeurDeRetour = 4%2;
        assertEquals(0, valeurDeRetour);
    }
}
