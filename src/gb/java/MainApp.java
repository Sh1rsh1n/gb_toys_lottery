import controller.Controller;
import view.AdminView;
import view.BaseView;
import view.ConsumerView;
import services.RSAUtil;

public class MainApp {
    public static void main(String[] args) {
      
      RSAUtil.keysCreator();
      
      /*
        try {
            BaseView[] view = {new AdminView(), new ConsumerView()};
            new Controller().appStart(view, args[0]);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("============ Toys Lottery ============");
            System.out.println("Call help, enter arguments: --help, -h");
            System.out.println("======================================");
        }
      */
    }
}
