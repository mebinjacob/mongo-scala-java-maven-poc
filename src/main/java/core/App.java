package core;

import model.Users;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
public class App {
	public static void main(String[] args) {
		 ApplicationContext ctx = new GenericXmlApplicationContext("SpringConfig.xml");
		   MongoOperations mongoOperation = (MongoOperations)ctx.getBean("mongoTemplate");
		 Users user = new Users("mebin", "mebin@123");
		 
		 //save operation
		 mongoOperation.save(user);
		
		 System.out.println("1. user id is : " + user.getId());
		 
		 //query to search user
		 Query searchUserQuery = new Query(Criteria.where("name").is("mebin"));
		 Users searchedUser = mongoOperation.findOne(searchUserQuery, Users.class);
		 System.out.println("The searched user is " + searchedUser.getName());
	}
}
