package view;

import javax.swing.JOptionPane;

import controller.RedesController;

public class Main {
	
	public static void main(String[] args) {
		
		RedesController redesController = new RedesController();
		
		int opc = 9;
		
		do {
			opc = Integer.parseInt(JOptionPane.showInputDialog("1 - Adaptador Ethernet e IPv4\n2 - Tempo Medio do Ping\n9 - Encerrar Programa"));
			
			switch (opc) {
			case 1: redesController.ip(redesController.so());
				break;
			case 2: redesController.ping(redesController.so());
				break;
			}
		} while (opc != 9);
		
	}

}