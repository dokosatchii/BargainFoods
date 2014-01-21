import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.NamedQuery;


@NamedQuery(name="createBreakfastList", query="FROM Breakfast")
@Entity
@Table(name="breakfast")

public class Breakfast implements MakeMeal{

@Id
@Column(name="ID")
private int id;
		
@Column(name="Name")
private String recipeName;
		
@Column(name="Price")
private int cost;
		
@Column(name="Ingredients")
private String ingredients;
		
@Column(name="Pic")
private String picture;
		
	//Getters
	public final int getId(){
		return id;
	}

	public final String getRecipeName() {
		return recipeName;
	}

	public final String getIngredients() {
		return ingredients;
	}

	public final int getCost() {
		return cost;
	}
	//Setters
	public void setId(int id){
		this.id= id;
	}
	public final void setRecipeName(String newRecipeName){
		this.recipeName = newRecipeName;
	}

	public final void setCost(int newValue){
		this.cost = newValue;
	}

	public final void setIngredients(String newIngredients){
		this.ingredients = newIngredients;
	}

	public String getPic() {
		return picture;
	}
	

}
