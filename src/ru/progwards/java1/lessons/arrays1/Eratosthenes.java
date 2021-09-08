package ru.progwards.java1.lessons.arrays1;

import java.util.Arrays;

public class Eratosthenes {

	private boolean[] sieve;
	
	public Eratosthenes(int n)
	{
		sieve = new boolean[n + 1];
		Arrays.fill(sieve, true);
		sift();
	}
	
	private void sift()
	{
		for(int p = 2; p*p <= sieve.length - 1; p++) 
        { 
            if(sieve[p] == true) 
            { 
                for(int i = p*2; i <= sieve.length - 1; i += p) 
                    sieve[i] = false; 
            } 
        }
	}
	
	public boolean isSimple(int n)
	{
	    return !sieve[n];
	}
}
