import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Eliza {
	static ArrayList<String> hedgeList = new ArrayList<String>();
	static ArrayList<String> qualifierList = new ArrayList<String>();
	static HashMap<String,String> replacementMap = new HashMap<String,String>();
	
	public Eliza(){
		//constructor is a good place to initialize stuff	
		hedgeList.add("Please tell me more");
		hedgeList.add("Many of my patients tell me the same thing");
		hedgeList.add("It is getting late, maybe we had better quit");
	
	    qualifierList.add("Why do you say that");
	    qualifierList.add("You seem to think that");
	    qualifierList.add("So, you are concerned that");

		replacementMap.put("i", "you");
		replacementMap.put("me","you");
		replacementMap.put("my","your");
	}
	
	public String prompt(){
		return "Enter your response for Eliza: ";
	}
	
	public String generateReply(String response){
		//use scanner object to break the response into words
		
		String reply = "";
		//pick a random number from 1 to 100 then
		//it will be less than 34 which 1/3 of the time
		//so at that point select a random hedge
		//otherwise select a random qualifier and replace words in the user's response
		int hedgeOrQualifier = getRandomInt(1,100);
		if (response.trim().length()==0){
			reply = "Take your time... some things are difficult to express.";
		}else if(hedgeOrQualifier < 34){
			//get random hedge
			int x = getRandomInt(1,3);
			reply = hedgeList.get(x-1);
		}else{
			//get random qualifier
			int x = getRandomInt(0,2);
			String qual = qualifierList.get(x);
			String replacement = getReplacement(response);
			reply = qual + " " + replacement;
		}

		return reply;
	}
	
	private String getReplacement(String response){
		String result = "";
		@SuppressWarnings("resource")
		Scanner words = new Scanner(response);
		while (words.hasNext()){	
			String keyword  = words.next();
			keyword = keyword.toLowerCase();

			if (replacementMap.containsKey(keyword)){
				result = result + ' ' + replacementMap.get(keyword);
			}else{
				result = result + ' ' + keyword;
			}
		}
		return result;
	}
	private static int getRandomInt(int min, int max){
		Random r = new Random();
		return min + r.nextInt(max - min + 1);
	}

}
