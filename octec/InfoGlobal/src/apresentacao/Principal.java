package apresentacao;

import javax.swing.UIManager;

public class Principal {

	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		System.out.println("Ol� Mundo");
		
		ifInfoGlobal i = new ifInfoGlobal();
		i.setVisible(true);
		
	}

}
