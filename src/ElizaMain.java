import java.util.Scanner;

public class ElizaMain {

	public static void main(String[] args) {
		System.out.println("Welcome. My name is Eliza. I am here to help you.");
		System.out.println("What is the problem I can help you with?");
		
		Eliza e = new Eliza();
		e.prompt();
		@SuppressWarnings("resource")//hides warning since I'm not closing the scanner
		Scanner keyboard = new Scanner(System.in);
		String response = keyboard.nextLine();

		while (!response.toLowerCase().equals("quit")){

			System.out.println(e.generateReply(response));
			System.out.print(e.prompt());
			response = keyboard.nextLine();
			
		}
		System.out.println("I hope you found this session helpful. Please pay the receptionist on your way out.");

	}

}
