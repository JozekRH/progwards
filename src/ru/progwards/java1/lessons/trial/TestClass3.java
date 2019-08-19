//Задача 3. Класс BArray
package ru.progwards.java1.lessons.trial;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestClass3{
	
	// массив с данными для процессинга результата теста
	// 0: идентификатор теста, - имя функции @Test
	// 1: имя теста словами, если == "", то возмется идентификатор
	// 2: баллы за эту часть теста
	// 3: * отмечены обязательные части теста
	private static String[][] testData = { 
			// первая строка содержит данные о всем тесте. Оценка отражает прходной балл 
			{"task3", "Задача 3. Класс BArray", "22", ""}, 
			{"test1", "Метод copyData(T[] src, Object[] dst)", "1", "*"},
			{"test2", "Метод int size()", "1", "*"},
			{"test3", "Метод insert(int index, T item)", "10", "*"},
			{"test4", "Метод delete(int index)", "10", "*"},
	};
	
	private Object[] arr = new Object[]{11, 22, 33, 55, 66, 77, 88, 99};
	private Object[] addArr = new Object[]{11, 22, 33, 44, 55, 66, 77, 88, 99};
	private int pos = 3;
	private int addInt = 44;

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
		BArray<Object> ba = new BArray<Object>(8, 8);
		
		Object[] na = new Object[8];
		
		ba.copyData(arr, na);
		
		boolean b = true;
		
		for (int n = 0; n < arr.length; n++)
		{
			try
			{
				if ((int)arr[n] != (int)na[n])
				{
					b = false;
					break;
				}
			}
			catch(Exception e)
			{
				b = false;
				break;
			}
		}
		
		if (b && arr.length != na.length) b = false;
		
		Assert.assertTrue("Метод работает неправильно", b);
	}

	@Test
	public void test2()
	{
		BArray<Object> ba = new BArray<Object>(8, 8);
		
		for (int n = 0; n < arr.length; n ++)
		{
			ba.add(arr[n]);
		}
		
		Assert.assertTrue("Метод возвращает неверное значение", ba.size == 8);
	}

	@Test
	public void test3()
	{
		BArray<Object> ba = new BArray<Object>(8, 8);
		
		for (int n = 0; n < arr.length; n ++)
		{
			ba.add(arr[n]);
		}
		
		ba.insert(pos, addInt);
		
		boolean b = true;
		
		for (int n = 0; n < addArr.length; n++)
		{
			if ((int)ba.get(n) != (int)addArr[n])
			{
				b = false;
				break;
			}
		}
		
		Assert.assertTrue("Метод работает неверно, либо метод get(int index) возвращает неверное значение", b);
	}
	
	@Test
	public void test4()
	{
		BArray<Object> ba = new BArray<Object>(8, 8);
		
		for (int n = 0; n < addArr.length; n ++)
		{
			ba.add(addArr[n]);
		}
		
		ba.delete(pos);
		
		boolean b = true;
		
		for (int n = 0; n < arr.length; n++)
		{
			if ((int)ba.get(n) != (int)arr[n])
			{
				b = false;
				break;
			}
		}
		
		Assert.assertTrue("Метод работает неверно, либо метод get(int index) возвращает неверное значение", b);
	}

	public static String[][] getData()
	{
		return testData;
	}
}

