package ru.progwards.java1.lessons.interfaces;

public class CalculateFibonacci {

	public static int fiboNumber(int n)
	{
		if (CacheInfo.n == n) return CacheInfo.fibo;
		
		int a = 1;
        int fibo = 0;
        int counter = 0;

        while (counter++ < n) {
            int a1 = a;
            a = fibo;
            fibo += a1;

        }

        CacheInfo.n = n;
        CacheInfo.fibo = fibo;
        
        return fibo;
    }
	
	public static class CacheInfo
	{
		public static int n;
		public static int fibo;
	}

}
