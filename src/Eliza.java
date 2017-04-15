import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Eliza {
	public static void main(String[] args){
		
		ArrayList<String> hedgeList = new ArrayList<String>();
		hedgeList.add("Please tell me more");
		hedgeList.add("Many of my patients tell me the same thing");
		hedgeList.add("It is getting late, maybe we had better quit");

		ArrayList<String> qualifierList = new ArrayList<String>();		
	    qualifierList.add("Why do you say that ");
	    qualifierList.add("You seem to think that ");
	    qualifierList.add("So, you are concerned that ");
	
		HashMap<String,String> replacementMap = new HashMap<String,String>();
		replacementMap.put("i", "you");
		replacementMap.put("me","you");
		replacementMap.put("my","your");
		
		System.out.println("Welcome. My name is Eliza. I am here to help you.");
		System.out.println("What is the problem I can help you with?");
		
		System.out.println("Enter your response for Eliza: ");
		@SuppressWarnings("resource")//hides warning since I'm not closing the scanner
		Scanner keyboard = new Scanner(System.in);
		String response = keyboard.nextLine();
		
		//determine if you use a qualifier or a hedge
		//just decide that 0 gives a hedge, 1 gives a qualifier
		if(getRandomInt(0,1)==0){
			//get random hedge
			int x = getRandomInt(0,2);
			System.out.println(hedgeList.get(x));
		}else{
			//get random qualifier
			int x = getRandomInt(0,2);
			System.out.println(qualifierList.get(x));
		}
		
		
		
		
		
		//use another scanner object to break the response into words
		@SuppressWarnings("resource")
		Scanner words = new Scanner(response);
		String result = "";
		
		while (words.hasNext()){
			
			String keyword  = words.next();
			keyword = keyword.toLowerCase();
			
			if (replacementMap.containsKey(keyword)){
				result = result + ' ' + replacementMap.get(keyword);
			}else{
				result = result + ' ' + keyword;
			}
			
		}

		System.out.print("Why do you say that ");
		System.out.println(result);
		
	}
	private static int getRandomInt(int lo, int hi){
		Random r = new Random();
		return lo + r.nextInt(hi);
	}

}
