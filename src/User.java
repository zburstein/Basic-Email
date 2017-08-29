public class User {
	private String username;
	private Mailbox inbox;
	private Mailbox outbox;
	
	public User(String username, int size){
		this.username = username;
		inbox = new Mailbox(size);
		outbox = new Mailbox(size);
	}
	
	public String getUsername(){
		return username;
	}
	public Mailbox getInbox(){
		return inbox;
	}
	public Mailbox getOutbox(){
		return outbox;
	}
}
