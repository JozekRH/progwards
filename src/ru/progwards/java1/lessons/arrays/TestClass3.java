//Задача 3. Класс DIntArray
package ru.progwards.java1.lessons.arrays;

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
			{"task", "Задача 3. Класс DIntArray", "20", ""}, 
			{"test1", "Конструктор по умолчанию", "3", "*"},
			{"test2", "Метод add(int num)", "3", "*"},
			{"test3", "Метод atInsert(int pos, int num)", "3", "*"},
			{"test4", "Метод atDelete(int pos)", "3", "*"},
	};
	
	private int[] arr = new int[]{11, 22, 33, 55, 66, 77, 88, 99};
	private int[] addArr = new int[]{11, 22, 33, 44, 55, 66, 77, 88, 99};
	private int pos = 3;
	private int addInt = 44;
	DIntArray dia;
	
	private DIntArray fill(int[] ia)
	{
		dia = new DIntArray(); 

		for (int i = 0; i < ia.length; i++)
		{
			dia.add(ia[i]);
		}
		
		return dia;
	}

	private boolean checkAt(int[] ia, DIntArray di)
	{
		boolean isRight = true;

		for (int i = 0; i < ia.length; i++)
		{
			if (ia[i] != di.at(i))
			{
				isRight = false;
				break;
			}
		}
		
		return isRight;
	}

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
		dia  = null;
		try
		{
			dia = new DIntArray(); 
		}
		catch (Exception e){}
		
		Assert.assertTrue("Не удалось создать новый экземпляр класса DIntArray", dia != null);
	}
	
	@Test
	public void test2()
	{
		dia = fill(arr); 
		Assert.assertTrue("Метод работает неверно, либо метод at(int pos) возвращает неверное значение", checkAt(arr, dia));
	}

	@Test
	public void test3()
	{
		dia = fill(arr); 
		dia.atInsert(pos, addInt);
		Assert.assertTrue("Метод работает неверно, либо метод at(int pos) возвращает неверное значение", checkAt(addArr, dia));
	}

	@Test
	public void test4()
	{
		dia = fill(addArr); 
		dia.atDelete(pos);
		Assert.assertTrue("Метод работает неверно, либо метод at(int pos) возвращает неверное значение", checkAt(arr, dia));
	}
	
	public static String[][] getData()
	{
		return testData;
	}
}

