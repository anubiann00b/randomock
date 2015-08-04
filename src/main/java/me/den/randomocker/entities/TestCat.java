package me.den.randomocker.entities;

import me.den.randomocker.anno.RandoMock;

public class TestCat {

   @RandoMock
   private int legsNumber;

   @Override public String toString() {
      return "legsNumber: " + legsNumber;
   }

   public int getLegsNumber() {
      return legsNumber;
   }

   public void setLegsNumber(int legsNumber) {
      this.legsNumber = legsNumber;
   }
}
