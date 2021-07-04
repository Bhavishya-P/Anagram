package assign;

import java.util.HashMap;
import java.util.Scanner;

public class Anagram {
	
	public static int makeAnagram(String a, String b)
	{
		int totalLength = a.length()+b.length();
		
		HashMap<Character,Integer> aMap = new HashMap<Character, Integer>();
		HashMap<Character, Integer> bMap = new HashMap<Character, Integer>();
		
		for(int i=0;i<a.length();i++)
		{
			if(aMap.containsKey(a.charAt(i)))
			{
				aMap.put(a.charAt(i), aMap.get(a.charAt(i))+1);
			}
			else
			{
				aMap.put(a.charAt(i), 1);
			}
		}
		
		for(int i=0;i<b.length();i++)
		{
			if(bMap.containsKey(b.charAt(i)))
			{
				bMap.put(b.charAt(i), bMap.get(b.charAt(i))+1);
			}
			else
			{
				bMap.put(b.charAt(i), 1);
			}
		}
		
		int numberOfDeletion = 0;
		for(Character temp : aMap.keySet())
		{
			if(aMap.containsKey(temp) && bMap.containsKey(temp))
			{
				if(aMap.get(temp) == bMap.get(temp))
				{
					numberOfDeletion = numberOfDeletion + aMap.get(temp) + bMap.get(temp);
				}
				else
				{
					numberOfDeletion = numberOfDeletion + (aMap.get(temp) + bMap.get(temp) - Math.abs(aMap.get(temp) - bMap.get(temp)));
				}
			}
			
		}
		return totalLength - numberOfDeletion;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String a = sc.next();
		String b = sc.next();
		
		int result = makeAnagram(a, b);
		
		System.out.println(result);
		
		

	}

}