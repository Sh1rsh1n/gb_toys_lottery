import controller.Controller;


public class MainApp {
    public static void main(String[] args) {
        try {
            new Controller(args[0]).appStart();
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("============ Toys Lottery ============");
            System.out.println("Call help, enter arguments: --help, -h");
            System.out.println("======================================");
        }
    }
}
