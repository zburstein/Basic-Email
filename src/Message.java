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
	

}
