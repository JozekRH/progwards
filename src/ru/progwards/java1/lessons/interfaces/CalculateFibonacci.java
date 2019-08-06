package ru.progwards.java1.lessons.interfaces;

public class CalculateFibonacci {

	public static int fiboNumber(int n)
	{
		CacheInfo lastFibo = new CacheInfo();
		
		if (lastFibo.n == n) return lastFibo.fibo;
		
		int a = 1;
        int fibo = 0;
        int counter = 0;

        while (counter++ < n) {
            int a1 = a;
            a = fibo;
            fibo += a1;

        }

        lastFibo.n = n;
        lastFibo.fibo = fibo;
        
        return fibo;
    }
	
	static class CacheInfo
	{
		public int n;
		public int fibo;
	}

}
