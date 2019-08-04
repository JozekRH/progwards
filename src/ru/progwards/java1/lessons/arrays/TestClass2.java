//Задача 2. Свой алгоритм сортировки, класс ArraySort
package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestClass2{
	
	// массив с данными для процессинга результата теста
	// 0: идентификатор теста, - имя функции @Test
	// 1: имя теста словами, если == "", то возмется идентификатор
	// 2: баллы за эту часть теста
	// 3: * отмечены обязательные части теста
	private static String[][] testData = { 
			// первая строка содержит данные о всем тесте. Оценка отражает прходной балл 
			{"task", "Задача 2. Свой алгоритм сортировки, класс ArraySort", "20", ""}, 
			{"test1", "Функция sort(int[] a)", "3", "*"},
	};
	
	private int[] arrUnsort = new int[]{22, 11, 55, 44, 33, 66, 99, 88, 77};
	private int[] arrSort = new int[]{11, 22, 33, 44, 55, 66, 77, 88, 99};
	
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
		int[] arr = ArraySort.sort(arrUnsort);
		Assert.assertTrue("Функция возвращает неверный массив", Arrays.equals(arr, arrSort));
	}
	
	public static String[][] getData()
	{
		return testData;
	}
}

