package cl.springmvcangular.jwtValidator.classes;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class GeneradorToken {
	final private String secretString = "gxcj1732";
	
	public String generarToken(String id, String issuer, String subject, long ttlMillis)  {
		  //The JWT signature algorithm we will be using to sign the token
	    SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

	    long nowMillis = System.currentTimeMillis();
	    Date now = new Date(nowMillis);

	    //Let's set the JWT Claims
	    JwtBuilder builder = Jwts.builder().setId(id)
	                                .setIssuedAt(now)
	                                .setSubject(subject)
	                                .setIssuer(issuer)
	                                .signWith(signatureAlgorithm, secretString);

	    //if it has been specified, let's add the expiration
	    if (ttlMillis >= 0) {
	    long expMillis = nowMillis + ttlMillis;
	        Date exp = new Date(expMillis);
	        builder.setExpiration(exp);
	    }

	    //Builds the JWT and serializes it to a compact, URL-safe string
	    return builder.compact();
	} 
	
	public boolean validarToken(String jwt) {
	    //This line will throw an exception if it is not a signed JWS (as expected)
	    Claims claims = Jwts.parser()         
	       .setSigningKey(secretString)
	       .parseClaimsJws(jwt).getBody();
	    
	    System.out.println("ID: " + claims.getId());
	    System.out.println("Subject: " + claims.getSubject());
	    System.out.println("Issuer: " + claims.getIssuer());
	    System.out.println("Expiration: " + claims.getExpiration());
	    
	    
	} 
	
}
