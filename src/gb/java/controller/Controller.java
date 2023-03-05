package controller;

import view.BaseView;

public class Controller {

    public void appStart(BaseView[] view, String args) {

        if (args.equals("--help") || args.equals("-h")) {
            System.out.println("\tAdmin menu write argument:\n\t--admin: prizes manager (need enter admin password)");
            System.out.println("\tConsumer menu, write argument:\n\t--wp: \"want prize\"");
            return;
        }

        if (args.equals("--admin")) {
            view[0].action();
            return;
        }

        if (args.equals("--wp")) {
            System.out.println("Action selected, \"Get prize\"\nYour prize is:");
            view[1].action();
            System.out.println("Congratulations!!!!");
            return;
        }

        if (args.equals("--pl")) {
            System.out.println("Action selected, \"List of all prizes\"");
            view[1].action();
            return;
        }

        System.out.println("============ Toys Lottery ============");
        System.out.println("Call help, enter arguments: --help, -h");
        System.out.println("======================================");
    }
}