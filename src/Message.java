public class Message {
	private String sender;
	private String recipient;
	private String subject;
	private String body;
	
	public Message(String sender, String recipient, String subject, String body){
		this.sender = sender;
		this.recipient = recipient;
		this.subject = subject;
		this.body = body;
	}
	
	public String toString(){
		String x = "From: "+ sender + "\n" + "To: " + recipient + "\n" + "Subject: " + subject +  "\n" + body;
		return x;
	}
	
	public String getSender(){
		return sender;
	}
	
	public String getRecipient(){
		return recipient;
	}
	
	public String getSubject(){
		return subject;
	}
	
	public String getBody(){
		return body;
	}
	
	public static void main(String args[]){
		Message test = new Message("Zane", "Hannah", "test", "hello world");

		
		Mailbox mboxtest = new Mailbox(3);
		mboxtest.addMsg(test);
		//mboxtest.viewMailbox();
		
		test = new Message("01234567890123456789012345678", "012345678901234567890123456", "This is how long the subjct is", "test");
		mboxtest.addMsg(test);
		mboxtest.viewMailbox();
		
		mboxtest.printMailboxMsg(0);
		mboxtest.printMailboxMsg(1);
		mboxtest.printMailboxMsg(2);
		mboxtest.printMailboxMsg(3);
		mboxtest.printMailboxMsg(4);
		mboxtest.printMailboxMsg(-1);
		
		mboxtest.removeMailboxMsg(0);
		mboxtest.removeMailboxMsg(1);
		mboxtest.viewMailbox();
		mboxtest.removeMailboxMsg(2);
		//mboxtest.removeMailboxMsg(3);
		//mboxtest.removeMailboxMsg(4);
	}
	

}
