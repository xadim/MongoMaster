package mongo.products;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

public class MongoDB{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{				
			User rest = new User();
			rest.createUser();
			
			MongoConn db = new MongoConn();
			DBCollection myDb = db.connectDb();
			db.createDbObj(rest, myDb);
			
		}
		catch(Exception e)
		{
			
		}
	}
	
	
	 
	  
}
