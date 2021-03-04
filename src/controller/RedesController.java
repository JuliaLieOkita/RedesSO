package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {
	
	public RedesController() {
		super();
	}
	
	public String so() {
		String so = System.getProperty("os.name");
		return so;
	}
	
	String adap;
	String aux;
	
	public void ip(String nomeSO) {
		
		if (nomeSO.contains("Windows")){
			try {
				Process p = Runtime.getRuntime().exec("ipconfig");
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				
				while (linha != null) {
					if (linha.contains("Adaptador")) {
						aux = linha + "\n";
					}
					if (linha.contains("IPv4")) {
						adap += aux + linha + "\n\n";
					}
					
					linha = buffer.readLine();
				}
				System.out.println(adap);
				
				buffer.close();
				leitor.close();
				fluxo.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				Process p = Runtime.getRuntime().exec("ifconfig");
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				
				while (linha != null) {
					if (linha.contains("flags")) {
						aux = linha + "\n";
					}
					if (linha.contains("netmask")) {
						adap += aux + linha + "\n\n";
					}
					
					linha = buffer.readLine();
				}
				System.out.println(adap);
				
				buffer.close();
				leitor.close();
				fluxo.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void ping(String nomeSO) {
		
		if (nomeSO.contains("Windows")){
			try {
				Process p = Runtime.getRuntime().exec("ping -n 10 www.google.com.br");
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				
				System.out.println("Processo em andamento...");
				
				while (linha != null) {
					if (linha.contains("M")) {
						String[] media = linha.split("=");
						System.out.println("Media:" + media[3]);
					}
					linha = buffer.readLine();
				}
				
				buffer.close();
				leitor.close();
				fluxo.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				Process p = Runtime.getRuntime().exec("ping -c 10 www.google.com.br");
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				
				System.out.println("Processo em andamento...");
				
				while (linha != null) {
					if (linha.contains("avg")) {
						String[] media = linha.split("/");
						System.out.println("Media:" + media[4] + "ms");
					}
					linha = buffer.readLine();
				}
				
				buffer.close();
				leitor.close();
				fluxo.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}