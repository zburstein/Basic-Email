import java.util.*;

public class UserList {
	ArrayList<User> userList;
	
	public UserList(){
		userList = new ArrayList<User>();
	}
	
	public User findUser(String name){
		//iterate through
		Iterator <User> itr = userList.iterator();
		while(itr.hasNext()){
			User current = itr.next();
			//if user present
			if(current.getUsername().equals(name)){
				return current;
			}
		}
		//if nothing
		return null;
	}
	
	public void addUser(User newUser){
		//iterate through the list
		Iterator <User> itr = userList.iterator();
		while(itr.hasNext()){
			User current = itr.next();
			
			//if username present
			if(current.getUsername().equals(newUser.getUsername())){
				System.out.println("This username is already taken");
				return;
			}
		}
		
		//if not present then add it
		userList.add(newUser);
	}

}
