package cw_5_11;

public class Main {

	public static void main(String[] args) 
	{
		Hotel hotel = new Hotel(10);
		
		hotel.Wynajmij(0, new Osoba("Przemek", "Kojs"));
		hotel.Wynajmij(1, new Osoba("Lukasz", "Bielawski"));
		hotel.Wynajmij(1, new Osoba("Hania", "Olechowska"));
		hotel.Wynajmij(2, new Osoba("Hania", "Olechowska"));
		
		System.out.println(hotel.IleWolnychPokoi());
		System.out.println(hotel.SprawdzWlasciciela(0, "Bielawski"));
		System.out.println(hotel.SprawdzWlasciciela(1, "Bielawski"));
		
		hotel.Zwolnij(1);
		
		System.out.println("Wolne pokoje: " + hotel.IleWolnychPokoi());
		hotel.PokojeOsoby(new Osoba("Przemek", "Kojs"));
	}
}
