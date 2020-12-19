//-------------maanged by bhavya-------------------------//
package com.lti.pojo;

public class RetailerLoginDto {
	private String email;
	private String password;
	
	
	public RetailerLoginDto() {
	}
	
	public RetailerLoginDto(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
