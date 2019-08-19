//Задача 2. Класс IsDate
package ru.progwards.java1.lessons.trial;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

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
			{"task2", "Задача 2. Класс IsDate", "20", ""}, 
			{"test1", "Метод check(int day, int month, int year)", "20", "*"},
	};
	
	private static final DateFormat format = new SimpleDateFormat("d.M.yyyy");	
	
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
		boolean b = checkDate();
		
		Assert.assertTrue("Метод возвращает неверное значение", b);
	}
	
	private boolean checkDate()
	{
		boolean b = true;

		for (int d = 1; d <= 31; d ++)
		{
			for (int m = 1; m <= 12; m++)
			{
				for (int y = 1970; y <= 2030; y++)
				{
					String sd = d + "." + m + "." + y;
					b = (IsDate.check(d, m, y) == isValid(sd));
					if (!b) return b;
				}
			}
		}
		
		return b;
	}
	

	private boolean isValid(String date){
        try {
            return format.format(format.parse(date)).equals(date);
        }catch (Exception e){
            return false;
        }
    }
	
	public static String[][] getData()
	{
		return testData;
	}
}

