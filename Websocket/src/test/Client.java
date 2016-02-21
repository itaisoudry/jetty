package test;

import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		String str = null;
		Scanner scan = new Scanner(System.in);
		str = scan.nextLine();
		
		while (!str.equals('a')) {
			ClientMain client = new ClientMain(str);
			client.run();
			System.out.println("client running");
			str = scan.nextLine();
		}
	}
}
