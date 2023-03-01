package services;

import model.Toy;

import java.util.List;


public class AdminServices{

   public void addToy(Toy toy) {
      DataServices.writeData(toy, true);
   }

   public List<Toy> getPrizesList() {
      return DataServices.readData();
   }

   public boolean checkPassword(String password) {
      return password.equals("123456");
   }
}



