
package sn.sonatel.formation.junit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ext_sow18 on 06/01/2018.
 */
public class FirstClassTest {

    @Test
    public void shoudReturn20(){
        int valeurDeRetour = 40/5;
        assertEquals(8, valeurDeRetour);
        
    }

}
