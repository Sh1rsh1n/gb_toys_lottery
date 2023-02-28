package services;

import model.Toy;


public class AdminServices{

   public void addPrize(Toy toy) {
      DataServices.writeData(toy, true);
   }

   public boolean checkPassword(String password) {
      return false;
   }
}



