import controller.Controller;


public class MainApp {
    public static void main(String[] args) {
        try {
            BaseView[] view = {new AdminView(), new ConsumerView()};
            new Controller().appStart(view, args[0]);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("============ Toys Lottery ============");
            System.out.println("Call help, enter arguments: --help, -h");
            System.out.println("======================================");
        }
    }
}
