package com.nt.bean;

import java.util.Set;

public class User {
     
	private Set<String> phones;

	public void setPhones(Set<String> phones) {
		this.phones = phones;
	}

	@Override
	public String toString() {
		return "User [phones=" + phones + "]";
	}
	
}