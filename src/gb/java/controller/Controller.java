


public class Controller {

    	private BaseView[] view;
	
	public Controller() {
		this.view = new BaseView[]{new AdminView(), new PrizeView()};
	}
    
    public void appStart(String args) {
	
	if args.equals("--help") || args.equals("-h"){
		System.out.println("Список всех команд:\n\t--admin: вход в меню администратора (нужно ввести пароль)");
		System.out.println("\t--gp: (get prize) получить приз");
		System.out.println("\t--pl: (prize list) список призов (шанс получения в %)");
		return;
	}
	
	if args.equals("--admin") {
		view[0].prizesListManager();
		return;
	}
	
	if args.equals("--gp") {
		view[1].getPrize();
		return;
	}
	
	if args.equals("--pl") {
		view[1].showPrizesList();
	}
	
	System.out.println("Вызов справки, введите аргумент: --help, -h");
    }
}