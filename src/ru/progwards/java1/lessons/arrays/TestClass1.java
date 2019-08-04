//Задача 1. Решето Эратосфена, класс Eratosthenes
package ru.progwards.java1.lessons.arrays;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestClass1{
	
	// массив с данными для процессинга результата теста
	// 0: идентификатор теста, - имя функции @Test
	// 1: имя теста словами, если == "", то возмется идентификатор
	// 2: баллы за эту часть теста
	// 3: * отмечены обязательные части теста
	private static String[][] testData = { 
			// первая строка содержит данные о всем тесте. Оценка отражает прходной балл 
			{"task", "Задача 1. Решето Эратосфена, класс Eratosthenes", "20", ""}, 
			{"test1", "Конструктор Eratosthenes(int n)", "3", "*"},
			{"test2", "Метод isSimple(int n)", "3", "*"},
	};
	
	private int eraSize = 300;
	private int[] eraArr = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293};
	private Eratosthenes era;
	
	@Before
    public void init() 
	{ 
	}
    
	@After
    public void done()
    {
    }
	
	
	@Test
	public void test1()
	{
		era  = null;
		try
		{
			era = new Eratosthenes(eraSize); 
		}
		catch (Exception e){}
		
		Assert.assertTrue("Не удалось создать новый экземпляр класса Eratosthenes", era != null);
	}
	
	@Test
	public void test2()
	{
		era = new Eratosthenes(eraSize); 
		boolean isRight = true;
		
		for (int i = 0; i < eraArr.length; i++)
		{
			if (!era.isSimple(eraArr[i]))
			{
				isRight = false;
				break;
			}
		}

		for (int i = 2; i < 300; i ++)
		{
			boolean isSimple = false;
			
			for (int n = 0; n < eraArr.length; n++)
			{
				if (i == eraArr[n])
				{
					isSimple = true;
					break;
				}
			}
			
			if (!isSimple && era.isSimple(i))
			{
				isRight = false;
				break;
			}
		}
		
		
		Assert.assertTrue("Метод isSimple(int n) возвращает неверное значение", isRight);
	}
	
	public static String[][] getData()
	{
		return testData;
	}
	
}

