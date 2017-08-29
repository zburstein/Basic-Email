import java.util.*;

public class Mailbox {
	private LinkedList<Message> mb;
	private int size;
	
	public Mailbox(int size){
		mb = new LinkedList<Message>();
		this.size = size;
	}
	
	public void addMsg(Message m){
		
		//more code but never overloads the mailbox
		//if not full, just add
		if(mb.size() < size){
			mb.add(m);
		}
		//if full then remove oldest and then add
		else{
			mb.removeFirst();
			mb.add(m);
		}
		
		
	}
	
	public void viewMailbox(){
		System.out.println("NO" + "  " + "SENDER              " + "  " + "RECIPIENT           " + "  " + "SUBJECT             ");
		//make iterator in order to traverse list of messages
		Iterator <Message> itr = mb.iterator();
		
		int i = 1;
		
		
		while (itr.hasNext()){
			
			//get the next message
			Message current = itr.next();
			
			///////print the number in mailbox///////
			//1 digit
			if(i < 10){
				System.out.print(i + " ");
			}
			//2 digit
			else{
				System.out.print(i);
			}
			
			////padding////
			System.out.print("  ");
			
			/////////print the sender//////////
			String sender = current.getSender();
			//if longer than space just print the first 20 characters
			if(sender.length() > 20){
				System.out.print(sender.substring(0, 20));
			}
			else{
				printPlusPadding(sender);
			}
			
			///padding///
			System.out.print("  ");;
			
			////////print the Recipient///////
			String recipient = current.getRecipient();
			//if longer than space just print the first 20 characters
			if(recipient.length() > 20){
				System.out.print(recipient.substring(0, 20));
			}
			//else print and then fill the space
			else{
				printPlusPadding(recipient);
			}
			
			///padding///
			System.out.print("  ");
			
			//////print the subject///////
			String subject = current.getSubject();
			if(subject.length() > 20){
				System.out.print(subject.substring(0, 20));
			}
			else{
				printPlusPadding(subject);
			}
			System.out.println("");
			i++;
		}
	}
	
	public void printMailboxMsg(int number){
		//if number is not available in list
		if(number > mb.size() || number <= 0){
			System.out.println("The message you requested does not exist!");
		}
		else{
			System.out.println(mb.get(number - 1).toString());
		}
		
	}
	
	public void removeMailboxMsg(int number){
		//if number not available in the list
		if(number > mb.size() || number<= 0){
			System.out.println("The message you requested to delete does not exist!");
		}
		else{
			mb.remove(number - 1);
		}
	}
	
	//when the string is larger than space allotted, print nad add the padding
	private void printPlusPadding(String x){
		System.out.print(x);
		int remaining = 20 - x.length();
		while(remaining > 0){
			System.out.print(" ");
			remaining--;
		}
		
	}

}
