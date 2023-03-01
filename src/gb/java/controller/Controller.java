package controller;


import view.AdminView;
import view.BaseView;
import view.ConsumerView;

public class Controller {

    private BaseView[] view;

    private String args;

    public Controller(String args) {
        this.args = args;
        this.view = new BaseView[]{new AdminView(), new ConsumerView()};
    }

    public void appStart() {

        if (this.args.equals("--help") || this.args.equals("-h")) {
            System.out.println("\tAdmin menu:\n\t--admin: prizes manager (need enter admin password)");
            System.out.println("\tConsumer menu:\n\t--gp: get prize");
            System.out.println("\t--pl: prize list (chance to get prize, %)");
            return;
        }

        if (this.args.equals("--admin")) {
            view[0].action();
            return;
        }

        if (this.args.equals("--gp")) {
            System.out.println("Action selected, \"Get prize\"\nYour prize is:");
            view[1].action();
            System.out.println("Congratulations!!!!");
            return;
        }

        if (this.args.equals("--pl")) {
            System.out.println("Action selected, \"List of all prizes\"");
            view[1].action();
            return;
        }

        System.out.println("============ Toys Lottery ============");
        System.out.println("Call help, enter arguments: --help, -h");
        System.out.println("======================================");
    }
}