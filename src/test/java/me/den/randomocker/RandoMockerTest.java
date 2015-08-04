package me.den.randomocker;

import org.junit.Before;
import org.junit.Test;

import me.den.randomocker.entities.TestCat;

import static org.junit.Assert.assertTrue;

public class RandoMockerTest {

   @Before
   public void setUp() throws Exception {
      // do nothing so far?
   }

   @Test
   public void testFetchDefaultInts() throws Exception {
      assertTrue(new RandoMocker().fetch(TestCat.class).startsWith("legsNumber: "));
   }

//   @Test
//   public void testFetchMinInt() throws Exception {
//      assertTrue(new RandoMocker().fetch(TestCat.class).startsWith("legsNumber: "));
//   }
}
