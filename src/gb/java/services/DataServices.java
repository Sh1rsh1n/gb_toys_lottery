
public class DataServices{

   String path = "src/gb/java/services/toys_lottery_list.txt";
   
   /*
    метод записывает данные в файл
     */
    public static void writeData(Toy toy, boolean newLine) {
    
        try (FileWriter writer = new FileWriter(path, newLine)) { // записываем данные в файл, с добавлением с новой строки
            	writer.write(toy.getId() + ","); // записываем имя
           	writer.write(toy.getTittle() + ",");
		writer.write(toy.getPriority());
            	writer.flush();
		writer.close();
        } catch (IOException ex) {
           	ex.printStackTrace();
        }
    }
	
	public static void reWriteData(List<Toy> toysList) {
       	
		   for (Toy toy: toysList) {
		   	writeData(toy, false);
		   }
    	}
}



