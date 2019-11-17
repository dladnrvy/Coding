import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static int solution(String S) {
		
		int N = 0;
		int firstIndex = 0;
		int lastIndex = 0;
		String ANSWER = "";

		while (S.contains("aaa") || S.contains("bbb")) {
			
			if(S.indexOf("aaa")>-1 || S.indexOf("bbb")>-1) {
				
				if(S.indexOf("aaa") > S.indexOf("bbb")) {
					firstIndex = S.indexOf("bbb")+1;
	
				}else {	
					firstIndex = S.indexOf("aaa")+1;
	
				}
			
				if(S.lastIndexOf("aaa") > S.lastIndexOf("bbb")) {
					lastIndex = S.lastIndexOf("aaa");
				}else {
					lastIndex = S.lastIndexOf("bbb");
	
				}
				ANSWER = S.substring(firstIndex, lastIndex);
				System.out.println(ANSWER);
				
				if(ANSWER.contains("aaa") || ANSWER.contains("bbb")){
					
				}
			}else {
				N = S.length();
				System.out.println(S);
				
				return N;
			}
		}
			
			

		
			
		
		
			
			
			
			
		
			
			N = ANSWER.length();
			
			System.out.println(ANSWER);
			
//			System.out.println(S.substring(S.indexOf("aaa")+1));
			
			return N;
			
			
		
		
		
	}

	public static void main(String[] args) {
		System.out.println(solution("abbaaaabbababababbbb"));
	}
	
	 
}
