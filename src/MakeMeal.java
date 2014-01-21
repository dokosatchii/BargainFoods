
public interface MakeMeal {
	
	//Getters
	int getId();
	
	String getRecipeName();
	
	String getIngredients();

	int getCost();
	
	String getPic();
	
	//Setters
	public void setId(int id);
	
	void setRecipeName(String newRecipeName);

	void setCost(int newValue);

	void setIngredients(String newIngredients);
	
}
