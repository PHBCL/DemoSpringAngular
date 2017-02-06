package cl.springmvcangular.jwtValidator.classes;

public class Token {
	private String token;

	public Token(){}
	
	public Token(String tokenString){
		this.token = tokenString;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
	
}
