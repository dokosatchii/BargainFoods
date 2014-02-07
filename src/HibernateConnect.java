import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernateConnect {

	List<Breakfast> breakfastRecipes;
	List<Lunch> lunchRecipes;
	List<Dinner> dinnerRecipes;
	
public HibernateConnect() {
		
		breakfastRecipes = fetchBreakfastRecipes();
		lunchRecipes = fetchLunchRecipes();
		dinnerRecipes = fetchDinnerRecipes();
		
	}//End of Constructor
	
	public List<Breakfast> getBreakfastRecipes() {
		return breakfastRecipes;
	}
	
	public List<Lunch> getLunchRecipes() {
		return lunchRecipes;
	}
	
	public List<Dinner> getDinnerRecipes() {
		return dinnerRecipes;
	}
	
	
	private static Session getSession() {
		
		Configuration config = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
		builder.applySettings(config.getProperties());
		ServiceRegistry serviceRegistry = builder.build();
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		return session;
	}
	
	private static void closeSession(Session sess){
		if(sess!=null){
			try {
				sess.close();
			}
			catch(HibernateException e){
				
			}
		}
	}
	
	private List<Breakfast> fetchBreakfastRecipes() { 
		Session sess = null;
		try{
			sess = getSession();
			Query qry = sess.getNamedQuery("createBreakfastList");
			//qry.setString("fName", price);
			return qry.list();
			
		}
		catch(HibernateException e){
			e.printStackTrace();
		}
		finally{
			HibernateConnect.closeSession(sess);
		}
		return null;
	}
	
	private List<Lunch> fetchLunchRecipes() { 
		Session sess = null;
		try{
			sess = getSession();
			Query qry = sess.getNamedQuery("createLunchList");
			//qry.setString("fName", price);
			return qry.list();
			
		}
		catch(HibernateException e){
			e.printStackTrace();
		}
		finally{
			HibernateConnect.closeSession(sess);
		}
		return null;
	}
	
	private List<Dinner> fetchDinnerRecipes() { 
		Session sess = null;
		try{
			sess = getSession();
			Query qry = sess.getNamedQuery("createDinnerList");
			//qry.setString("fName", price);
			return qry.list();
			
		}
		catch(HibernateException e){
			e.printStackTrace();
		}
		finally{
			HibernateConnect.closeSession(sess);
		}
		return null;
	}

	public void setIngredientCost(String name) { 
		Session sess = null;
		try{
			sess = getSession();
			Query qry = sess.getNamedQuery("updateIngredients");
			qry.setString("fName", name);
			
		}
		catch(HibernateException e){
			e.printStackTrace();
		}
		finally{
			HibernateConnect.closeSession(sess);
		}
	}
		
	
}//End of Code
