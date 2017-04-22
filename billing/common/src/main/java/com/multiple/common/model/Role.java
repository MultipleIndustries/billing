package com.multiple.common.model;


public enum Role {
	
	SUPER_ADMIN(1),
	MEMBER(2);

	private final int id;
	
	private Role(int id){
		this.id = id;
	}
	
	public int getId() {
		return id;
	}


	public static Role fromInt(int id) {
		switch (id) {
		case 1:
			return SUPER_ADMIN;
		case 2:
			return MEMBER;
		
		default:
			return null;
		}
	}
}
