//Задача 1. Класс Season
package ru.progwards.java1.lessons.trial;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ru.progwards.java1.lessons.trial.Season.Language;

public class TestClass1{
	
	// массив с данными для процессинга результата теста
	// 0: идентификатор теста, - имя функции @Test
	// 1: имя теста словами, если == "", то возмется идентификатор
	// 2: баллы за эту часть теста
	// 3: * отмечены обязательные части теста
	private static String[][] testData = { 
			// первая строка содержит данные о всем тесте. Оценка отражает прходной балл 
			{"task1", "Задача 1. Класс Season", "20", ""}, 
			{"test1", "Метод setLang(Language lang)", "10", "*"},
			{"test2", "Метод toString(int month)", "10", "*"},
	};
	
	private String[] enSeason = {"winter", "spring", "summer", "autumn"};
	private String[] ruSeason = {"зима", "весна", "лето", "осень"};
	
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
		Season s = null;
		try
		{
			s = new Season();
		}
		catch (Exception e){}
		
        if (s == null)
        {
        	Assert.assertTrue("Не удалось создать новый экземпляр класса Season", false);
        	return;
        }

		try
		{
			s.setLang(Language.EN);
		}
		catch (Exception e)
		{
	    	Assert.assertTrue("Не удалось вызвать метод", false);
		}
	}
	
	@Test
	public void test2()
	{
		Season s = null;
		try
		{
			s = new Season();
		}
		catch (Exception e){}
		
        if (s == null)
        {
        	Assert.assertTrue("Не удалось создать новый экземпляр класса Season", false);
        	return;
        }

		boolean b = true;

        try
		{
			for (int l = 0; l < 2; l++)
			{
				s.setLang(l == 0 ? Language.EN : Language.RU);
				
				for (int n = 0; n <= 13; n ++)
				{
					switch (n)
					{
					 case 1:
					 case 2:
					 case 12:
							if (!s.toString(n).equals(l == 0 ? enSeason[0] : ruSeason[0])) b = false;
							break;
					 case 3:
					 case 4:
					 case 5:
							if (!s.toString(n).equals(l == 0 ? enSeason[1] : ruSeason[1])) b = false;
							break;
					 case 6:
					 case 7:
					 case 8:
							if (!s.toString(n).equals(l == 0 ? enSeason[2] : ruSeason[2])) b = false;
							break;
					 case 9:
					 case 10:
					 case 11:
							if (!s.toString(n).equals(l == 0 ? enSeason[3] : ruSeason[3])) b = false;
							break;
					default:
						if (!s.toString(n).equals(l == 0 ? "not valid" : "не определено")) b = false;
						
					}
				}
			}
		}
		catch (Exception e)
        {
			b = false;
        }
        
        Assert.assertTrue("Метод возвращает неверное значение", b);
	}

	public static String[][] getData()
	{
		return testData;
	}
}

