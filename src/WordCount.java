public class WordCount {
	
private String iingredientName;
private int icount;

public WordCount(String ingredientName, int count){
	iingredientName = ingredientName;
	icount = count;
	
	}
public WordCount() {
	
}

public int getCount() {
	return icount;
}

public String getIngredientName(){
	return iingredientName;
}


}