package hu.bme.mit.train.tachograf;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;



public class TachografTest {
    TachografImpl tachograf;

    @Before
    public void before() {
        tachograf = new TachografImpl();
    }

    @Test
    public void HasElements(){
        Assert.assertTrue(tachograf.hasElements());
    }

}
