package Projekt_Main;

import java.util.Random;
import Bukiet.Bukiet;
import Florysta.Florysta;

public class Main {

	public static void main(String[] args) 
	{
		Bukiet[] kwiaciarnia = new Bukiet[5];		
		Random random = new Random();
		
		for(int index = 0; index < kwiaciarnia.length; index++)
		{
			kwiaciarnia[index] = new Bukiet(random.nextInt(6) + 1, false);
			Florysta.TworzBukiet(kwiaciarnia[index]);
		}
		
		ShowAll(kwiaciarnia, 7);
		
		System.out.println();
		System.out.println("Florysta sprzedal kwiatki: 1, 3, 4");
		Florysta.SprzedajBukiet(kwiaciarnia[1]);
		Florysta.SprzedajBukiet(kwiaciarnia[3]);
		Florysta.SprzedajBukiet(kwiaciarnia[4]);
		
		ShowAll(kwiaciarnia, 7);
		
		System.out.println();
		System.out.println("Florysta zrobi³ kwiatki: 1, 3, 4");
		Florysta.TworzBukiet(kwiaciarnia[1]);
		Florysta.TworzBukiet(kwiaciarnia[3]);
		Florysta.TworzBukiet(kwiaciarnia[4]);
		
		ShowAll(kwiaciarnia, 7);
	}
	
	public static void ShowAll(Bukiet[] kwiaciarnia, int n)
	{
		if(n > kwiaciarnia.length)
		{
			n = kwiaciarnia.length;
		}
		
		for(int index = 0; index < n; index++)
		{			
			System.out.printf("Bukiet o indeksie=%d kwiat=%d dostepny=%b%n", index, kwiaciarnia[index].GetKwiat().GetNazwa(), kwiaciarnia[index].GetDostepny());
		}
	}
}
