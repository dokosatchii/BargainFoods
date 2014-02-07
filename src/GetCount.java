import java.util.*;
import java.io.*;

public class GetCount {

		private int counter=0;
		private HibernateConnect db = new HibernateConnect();
		private HashSet<WordCount> list = new HashSet<WordCount>();

	public GetCount() {
	

		for(Breakfast item: db.getBreakfastRecipes()) {
			String[] ingredients = item.getIngredients().split(","); //Split the ingredients into individual strings
			for(int i=0;i<ingredients.length;i++){					//trim the strings
				ingredients[i] = ingredients[i].trim();
			}
			for(int i=0;i<ingredients.length; i++){ 				//For each ingredient
				for( Breakfast item1: db.getBreakfastRecipes()){
					if(item1.getIngredients().contains(ingredients[i])){ //Count how many times the ingredient is mentioned in all available recipes
					counter++;
					}
				}
			list.add(new WordCount(ingredients[i],counter));  //Add the recipe name and count to an object
			counter = 0;
			}
		}


	for(Lunch item: db.getLunchRecipes()) {
		String[] ingredients = item.getIngredients().split(",");
		for(int i=0;i<ingredients.length; i++){
			for(Lunch item1: db.getLunchRecipes()){
				if(item1.getIngredients().contains(ingredients[i])){
				counter++;
				}
			}
		list.add(new WordCount(ingredients[i],counter));
		counter = 0;
		}
	}

for(Dinner item: db.getDinnerRecipes()) {
	String[] ingredients = item.getIngredients().split(",");
	for(int i=0;i<ingredients.length; i++){
		for(Dinner item1: db.getDinnerRecipes()){
			if(item1.getIngredients().contains(ingredients[i])){
			counter++;
			}
		}
	list.add(new WordCount(ingredients[i],counter));
	counter = 0;
		}
	}
}
	
public void printArrayList() {									//print out the list
	ArrayList<WordCount> list1 = new ArrayList<WordCount>();
	list1.addAll(list);
	ListIterator<WordCount> newlist = list1.listIterator();
	while(newlist.hasNext()){
		WordCount temp = newlist.next();
		System.out.println(temp.getIngredientName() + " " + temp.getCount());
	}
}
/*public void uploadArrayList() {
	
	for(WordCount item: list){
		db.setIngredientCost(new IngredientsCost(item.getIngredientName()).getName());
	}
}*/
public void appendList(){							//print the list to a text file
	
	File saveFile = new File("/Users/dokosatchii/Documents/list.txt");
	try {
		if(saveFile.exists()){
			saveFile.delete();
		}
		PrintWriter ingredientstowrite = new PrintWriter(new BufferedWriter(new FileWriter(saveFile)));
		saveFile.createNewFile();
		ArrayList<WordCount> list1 = new ArrayList<WordCount>();
		list1.addAll(list);
		for(WordCount item: list1){
		ingredientstowrite.println(item.getIngredientName() +" "+ item.getCount());
		}
		System.out.println("File written to");
		ingredientstowrite.close();
	
	}
	
	catch(IOException e) {
		e.printStackTrace();
	}
	finally{
		
	}
	
	
}

	
	
}//End of code
	
