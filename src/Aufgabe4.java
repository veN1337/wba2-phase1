import generated.*;

import java.io.File;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;



public class Aufgabe4 {

	public static void main(String[] args) {
		try {
			Scanner s = new Scanner(System.in);

			int in = -1;
			while (in != 0) {
				if (in == -1) {
					System.out.println("Menü:");
					System.out.println("Alle Rezepte anzeigen = 1");
					System.out.println("Ein Rezept anzeigen = 2");
					System.out.println("Kommentar hinzufügen = 3");
					System.out.println("Schließen = 4");
					in = s.nextInt();
				}
				if (in == 1) {
					all();
					in = 0;
				}
				
				else if (in == 2) {
					list();
					System.out.println("Rezept auswählen:");
					in = s.nextInt();
					ausgeben(in-1);
					in = 0;
				}
	
				else if (in == 3) {
					list();
					System.out.println("Rezept auswählen:");
					in = s.nextInt();
					kommentar(in-1);
					in = 0;
				}
				
				else if (in == 4) {
					in = 0;
				}
	
				else {
					in = -1;
					System.out.println("Ungültige Eingabe!");
				}
			}
			s.close();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	private static void list() throws JAXBException {
		System.out.println("Verfügbare Rezepte: ");
		Recipes list = getrecipes();
		for (int i = 0; i < list.getRecipe().size(); i++) {
			if (list.getRecipe().get(i) instanceof Recipe) {
				System.out.print(i+1);
				if(i+1 < list.getRecipe().size()) {
					System.out.print(", "); 
				}
			}
		}
		System.out.println();
	}

	private static void all() throws JAXBException {
		Recipes list = getrecipes();
		for (int i = 0; i < list.getRecipe().size(); i++) {
			if (list.getRecipe().get(i) instanceof Recipe) {
				ausgeben(i);
			}
		}
	}
	
	private static void kommentar(int i) throws JAXBException {
		JAXBContext ctx = JAXBContext.newInstance("generated");
		Recipes l = getrecipes();
		Recipe r = l.getRecipe().get(i);
		Comment c = new Comment();
		
		int id = 1;
		
		if(r.getComments() instanceof Comments) {
			id = r.getComments().getComment().size() + 1;
		} else {
			r.setComments(new Comments());
		}
		
		c.setCommentId(id+"");
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Neuer Kommentar:");
		String in = s.nextLine();
		s.close();
		
		c.setValue(in);
		
		r.getComments().getComment().add(c);

		Marshaller marshaller = ctx.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		marshaller.marshal(l, (new File("src/Aufgabe3d.xml")));
	}

	private static void ausgeben(int a) throws JAXBException {
		
		Recipes list = getrecipes();
		if(a < list.getRecipe().size()) {
			if (list.getRecipe().get(a) instanceof Recipe) {
				
				Recipe r = list.getRecipe().get(a);
				
				System.out.println("#" + r.getRecipeId());
				System.out.println("Name: " + r.getTitle());
				System.out.println("Arbeitszeit: " + r.getWorkingtime());
				System.out.println("Schwierigkeit: " + r.getDifficulty());
				System.out.println(r.getKcal() + " kcal");
				System.out.println();
				
				System.out.println("Zutaten:");
				for (int ii = 0; ii < r.getIngredients().getIngredient().size(); ii++) {
					Ingredient ingr = r.getIngredients().getIngredient().get(ii);
					System.out.println(ingr.getAmount() + " " + ingr.getUnit() + " " + ingr.getValue());
				}
				System.out.println();
	
				System.out.println("Zubereitung:");
				for (int iii = 0; iii < r.getPreperation().getStep().size(); iii++) {
					Step s = r.getPreperation().getStep().get(iii);
					System.out.println(s.getValue());
				}
				System.out.println();
				
				if (r.getComments() instanceof Comments) {
					System.out.println("Kommentare:");
					for (int iiii = 0; iiii < r.getComments().getComment().size(); iiii++) {
						Comment c = r.getComments().getComment().get(iiii);
						System.out.println("Kommentar " + c.getCommentId() + ": " + c.getValue());
					}
					System.out.println();
				}
			}
		}
	}
	
	private static Recipes getrecipes() throws JAXBException {
		JAXBContext ctx = JAXBContext.newInstance("generated");
		Unmarshaller unmarshaller = ctx.createUnmarshaller();
		Recipes list = (Recipes) unmarshaller.unmarshal(new File("src/Aufgabe3d.xml"));
		return list;
	}
	
}
