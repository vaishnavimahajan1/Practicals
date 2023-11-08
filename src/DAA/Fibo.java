package DAA;

import java.util.Scanner;

public class Fibo {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the number of fibonacci numbers to calculate:");
		int n=s.nextInt();
		
		calculatefibonacci(n);
		s.close();
	}
	
	public static void calculatefibonacci(int n) {
		int[] fibseq=new int[n];
		fibseq[0]=0;
		fibseq[1]=1;
		
		for(int i=2;i<n;i++){
			fibseq[i]=fibseq[i-1]+fibseq[i-2];
		}
		
		System.out.println("Fibonacci squence is:");
		for(int i=0;i<n;i++)
		{
			System.out.println(fibseq[i]+" ");
		}
		
	}

}
