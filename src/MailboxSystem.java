public class MailboxSystem 
{
  
  public static final int MailboxSize = 3; // for easier debugging, this system supports mailboxes with up to 3 messages
  public static UserList emailUsers = new UserList(); // the list of registered users
  
  // we need that one all the time...
  public static java.util.Scanner sc = new java.util.Scanner(System.in);

  public static void main (String args[])
  {
    
    while(true)
    {
      System.out.println("\nMain Menu Options:");
      System.out.println("-------------");
      
      System.out.println("1: Create a user");
      System.out.println("2: Login");
      System.out.println("3: Exit");
      
      String inputString = sc.nextLine();
      int input = transform(inputString, 4); // make sure input is readable     
      
 
      if (input == 1)
      {
        // read name of user to be created
        System.out.println("Name of the User:");
        String username = sc.nextLine();
        
        /* TODO: check whether user exists, if not create user and add to the emailUser List */
        //if not present, create and add user
        if(emailUsers.findUser(username) == null){
        	User newUser = new User (username, MailboxSize);
        	emailUsers.addUser(newUser);
        }
        //if already exists
        else{
        	System.out.println("User " + username + " already exists. Pick another username");
        }
        
      }
      else if (input == 2)
      {
        
        // read name of user to be logged in
        System.out.println("Name of the User:");
        String username = sc.nextLine();
        
        User u = emailUsers.findUser(username);
        
        if (u == null)
          System.out.println("User can't be found.");
        else
          handleUser(u);
        
      }
      else if (input == 3)
      {
        System.out.println("Exit");
        return;
      }
    }
  }

  // User menu
  public static void handleUser (User u)
  {

    while (true)
    {
      System.out.println("\n User Menu Options:");
      System.out.println("------------------");
      System.out.println("1: View your inbox:");
      System.out.println("2: View your outbox:");
      System.out.println("3: Send a message:");
      System.out.println("4: View specific inbox message");
      System.out.println("5: View specific output message");
      System.out.println("6: Remove specific inbox message");
      System.out.println("7: logout:");
      
      String inputString = sc.nextLine();
      int input = transform(inputString, 8);
      
      int msgn;
      
      switch (input)
      {
        case 1:
          /* TODO: u.inbox.viewMailbox(); */
        	u.getInbox().viewMailbox();
        	
          break;
      
        case 2:
          /* TODO: make according call to view outbox mailbox */
        	u.getOutbox().viewMailbox();
          break;
          
        case 3:
          System.out.println("Receiver: ");
          String receiver = sc.nextLine();
          System.out.println("Subject: ");
          String subject = sc.nextLine();
          System.out.println("One line msg body: ");
          String body = sc.nextLine();
          
          
          /* TODO: create message, add it to user's outbox, and if the receiver is also a user with the
           * very same email system, then add the messages to the receiver's inbox (if the receiver is not
           * a registered user, then the email should still be added to the sender's outbox */
          Message newMessage = new Message(u.getUsername(), receiver, subject, body);//create teh message
          u.getOutbox().addMsg(newMessage);//add to outbox
          
          //if user exists add to their inbox
          User recipientUser = emailUsers.findUser(receiver);
          if(recipientUser != null){
        	  recipientUser.getInbox().addMsg(newMessage);
          }
 
          break;
      
        case 4:
          System.out.println("Message Number in Inbox:");
          msgn = sc.nextInt();
          sc.nextLine();
          
          /* TODO: make the proper call to print the message */
          u.getInbox().printMailboxMsg(msgn);
          break;
          
        case 5:
          System.out.println("Message Number in Outbox");
          msgn = sc.nextInt();
          sc.nextLine();
          
          /* TODO: make the proper call to print the message */
          u.getOutbox().printMailboxMsg(msgn);
          break;
        case 6:
          System.out.println("Message Number in Inbox to be deleted");
          msgn = sc.nextInt();
          sc.nextLine();
          
          /* TODO: make the proper call to remove the message from the mailbox */
          u.getInbox().removeMailboxMsg(msgn);
          break;
        case 7:
          return;
        default:
      }
    }
  }
  
  // just make sure that input has correct format; if not, transform it into the exist number
  public static int transform(String inputstring, int other) 
  {
    if(inputstring.length() != 1)
      return other;
    
    char c = inputstring.charAt(0);
    
     if(c > 48 && c <= 48 + other)
       return  Character.getNumericValue(c);
     
     return other;
  }
  
}
  

        
        
      
      
                           
    
    
  