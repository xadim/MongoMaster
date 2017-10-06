package mongo.products;


import java.net.UnknownHostException;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import mongo.products.security.Security;


public class MongoConn {
	Security sec =new Security();
	//Connects to mongo db instaance
	public DBCollection connectDb()
	{
		MongoClient mongoClient = null;
		try {
			mongoClient = new MongoClient( "localhost" , 27017);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
         // Now connect to your databases
         DB db = mongoClient.getDB(Constants.dbName);
         System.out.println("Connect to database successfully");	         
         DBCollection coll = db.getCollection(Constants.collName);
		 return coll;
	}

	//Creates new Document in db
	public void createDbObj(User rest, DBCollection myDb)
	{
		
		BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
        
        docBuilder.append(Constants.userId, rest.getUserId());
        docBuilder.append(Constants.userName, rest.getUserName());
        docBuilder.append(Constants.password, rest.getPassword());
        docBuilder.append(Constants.firstName, rest.getFirstName());
        docBuilder.append(Constants.lastName, rest.getLastName());
        docBuilder.append(Constants.emailId, rest.getEmailId());
        myDb.insert(docBuilder.get());
        //return docBuilder.get();		
	}
	
	 	 
	 //Remove one document from db
	 public void removeDoc(DBCollection coll)
	 {
		 DBObject myDoc = coll.findOne();
         coll.remove(myDoc);
	 }
	 
	 //Read documents from db
	 public void readData(DBCollection coll)
	 {
		 DBCursor cursor = coll.find();
         int i = 0;
         while(cursor.hasNext())
         {
        	 Object a = cursor.next().get(Constants.password);
        	// sec.decrpytPassword(a);
        	 System.out.println(i + "Doc" + cursor.next());
        	 i++;
         }
         
	 }
	 
	 //Update all document in db, can be modified by quering
	 public void updateDoc(DBCollection coll)
	 {
		 DBCursor cursor = coll.find();
		 while (cursor.hasNext()) { 
         DBObject updateDocument = cursor.next();
         updateDocument.put(Constants.emailId,"abc@gmail.com");
         coll.update(updateDocument, null); 
      }
	 }
	 
	 //find Documents in db
	 public void findDoc(DBCollection coll)
	 {
		 //Query can be modified to find document
		  DBObject query = BasicDBObjectBuilder.start().add(Constants.firstName,"Priyanka").get();
	      DBCursor cursor = coll.find(query);
	      while(cursor.hasNext()){
	          System.out.println(cursor.next());
	       }
	 }
}
