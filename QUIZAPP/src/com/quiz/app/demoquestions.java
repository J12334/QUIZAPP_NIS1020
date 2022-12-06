package com.quiz.app;
/* make in a layered architecture with packages instead of single package*/
import java.util.Random;
import java.util.Scanner;

public class demoquestions {
	
	
	static class Question_Node{
		
		String question;
		String answer;
		
		Question_Node(){
			
		}
		
		Question_Node(String question,String answer){
			this.question = question;
			this.answer = answer;
		}
		
	}
	
	

	public static void main(String[] args) {
		
		System.out.println("Starting quiz.....");
		
		Scanner scn = new Scanner(System.in);
		
		
		Question_Node[] questions = new Question_Node[5];
		
//		questions[0][0] = "Capital of Maharashtra :";
//		questions[0][1] = "Mumbai";
		
		questions[0] = new Question_Node("What is Capital of Maharashtra ?","mumbai");
		questions[1] = new Question_Node("What is Capital of Madhya Pradesh ?", "bhopal");
		questions[2] = new Question_Node("What is Capital of Bihar ?", "patna");
		questions[3] = new Question_Node("What is Capital of Himachal Pradesh ?", "shimla");
		questions[4] = new Question_Node("What is Capital of Goa ?", "panaji");
		
		playgame(questions);
		
	}
	
	public static void playgame(Question_Node[] arr) {
		
		 Scanner scn2 = new Scanner(System.in);
		
		 Random r = new Random();
		 int n = arr.length;
		 
		 String[][] Report_card = new String[6][4];
		 Report_card[0][3] = "Result";
		 Report_card[0][0] = "Question";
		 Report_card[0][1] = "Correct Answer";
		 Report_card[0][2] = "Your Answer";
         
	        // Start from the last element and swap one by one. We don't
	        // need to run for the first element that's why i > 0
	        for (int i = n-1; i > 0; i--) {
	             
	            
	            int j = r.nextInt(i+1);
	             
	            
	            Question_Node temp = arr[i];
	            arr[i] = arr[j];
	            arr[j] = temp;
	        }
		
		    int score = 0;
		    
		    for(int i=0; i<5; i++) {
		    	
		    	
		    	System.out.println(arr[i].question);
		    	
		    	Report_card[i+1][0] = arr[i].question;
		    	
		    	String ua = scn2.nextLine();
		    	
		    	ua.toLowerCase();
		    	
		    	String ca = arr[i].answer;
		    	Report_card[i+1][1] = arr[i].answer;
		    	Report_card[i+1][2] = ua;
		    	
		    	if(ua.equals(ca)) {
		    		score++;
		    		Report_card[i+1][3] = "Correct";
		    	}else {
		    		Report_card[i+1][3] = "Wrong";
		    	}
		    	
		    }
		    
		    
		    for(int i=0; i<=5; i++) {
		    	
		    	
		    	System.out.print((i+1) + " | " + Report_card[i][0] + " | " + Report_card[i][1] + " | " + Report_card[i][2] + " | " + Report_card[i][3] + " | ");
		    	System.out.println();
		    	
		    }
		    
		    
		    
		    System.out.println("You have scored : " + score);
		    
		    
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
}
