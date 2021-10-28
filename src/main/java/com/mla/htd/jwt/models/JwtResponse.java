package com.mla.htd.jwt.models;

import java.io.Serializable;

public class JwtResponse implements Serializable {
	
	private static final long serialVersionUID = -1093546235737696786L;

	private final String jwttoken;

	public JwtResponse(String jwttoken) {
		this.jwttoken = jwttoken;
	}

	public String getToken() {
		return this.jwttoken;
	}

}
