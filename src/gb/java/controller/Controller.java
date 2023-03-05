package controller;

import services.AdminServices;
import view.BaseView;

public class Controller {

    private AdminServices adminServices;

    public void appStart(BaseView[] view, String args) {

        if (args.equals("--help") || args.equals("-h")) {
            System.out.println("\tWork is admin mode, enter argument:\n\t-adm (enter admin password)");
            System.out.println("\tWork is consumer mode, enter argument:\n\t-cns");
            return;
        }

        if (args.equals("-adm")) {
            System.out.println("ADMIN MODE IS SELECTED");
            view[0].action(adminServices);
            return;
        }

        if (args.equals("-cns")) {
            System.out.println("CONSUMER MODE IS SELECTED");
            view[1].action(adminServices);
            return;
        }

        System.out.println("============ Toys Lottery ============");
        System.out.println("Call help, enter arguments: --help, -h");
        System.out.println("======================================");
    }
}