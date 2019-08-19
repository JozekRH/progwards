package ru.progwards.java1.lessons.trial;

public class Season {

	private Language lang = Language.EN;
	private String[] enSeason = {"winter", "spring", "summer", "autumn"};
	private String[] ruSeason = {"зима", "весна", "лето", "осень"};
	public enum Language {EN, RU};
	
	
	public Season() {
		// TODO Auto-generated constructor stub
	}
	
	public void setLang(Language lang)
	{
		this.lang = lang;
	}
	
	public String toString(int month)
	{
		return (this.lang == Language.EN) ? enSeason[0] : ruSeason[0];
	}

}
