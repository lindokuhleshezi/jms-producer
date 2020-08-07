package com.producer.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = Message.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Message {
	
	private String message;
	
	@Override
	public String toString() {
		return "Message:{ " + this.message +"}";
	}
}
