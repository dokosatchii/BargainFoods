import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.NamedQuery;
//updates table with ingredients cost

@NamedQuery(name="updateIngredients", query="UPDATE IngredientsCost SET Ingredients=:fName") //need to change query to be able to update table
@Entity
@Table(name="Ingredients")

public class IngredientsCost {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="Ingredients", unique=true)
	private String ingredientName;
	
	private Double Cost;
	
	public IngredientsCost(String name) {
		this.ingredientName = name;
	}
	public IngredientsCost() {
		
	}
	
	public String getName(){
		return ingredientName;
		
	}
	

}
