package com.felixlaura.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.felixlaura.messenger.database.DatabaseClass;
import com.felixlaura.messenger.model.Message;

public class MessageService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public MessageService(){
		messages.put(1L, new Message(1, "Hello World", "Felix Laura"));
		messages.put(2L, new Message(2, "Hello Jersey", "Marly Chavez"));
		messages.put(3L, new Message(3, "Hello RestEasy", "Nicolas Laura"));
		
	}

	public List<Message> getAllMessages() {
		// return a Arraylist of messages values. this returs all values of messages in themap
		return new ArrayList<Message>(messages.values());

		/*Message m1 = new Message(1, "Hello World", "Felix Laura");
		Message m2 = new Message(1, "Hello Jersey", "Nicolas Laura");
		Message m3 = new Message(1, "Hello RestEasy", "Marly Chavez");

		List<Message> list = new ArrayList<>();
		list.add(m1);
		list.add(m2);
		list.add(m3);

		return list;*/

	}
	
	public Message getMessage(long id){
		return messages.get(id);
	}
	
	public Message addMessage(Message message){
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message){
		if(message.getId() <= 0){
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id){
		return messages.get(id);
	}
}
