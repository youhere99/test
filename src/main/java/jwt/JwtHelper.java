package jwt;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

/**
 * Title.工具类 <br>
 * Description. 作者： Renky 链接：https:// www.jianshu.com/p/2fdc20a42c41
 * <p>
 * Copyright: Copyright (c) 2017年12月26日 下午2:40:33
 * <p>
 * Company: 翡翠教育
 * <p>
 * 
 * @author zhaomingxing
 * @version 1.0
 */
public class JwtHelper {

	private final static String base64Secret = "MDk4ZjZiY2Q0NjIxZDM3M2NhZGU0ZTgzMjYyN2I0ZjY=";

	private final static int expiresSecond = 172800000;

	public static void parseJWT(String jsonWebToken) {
		try {
			Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(base64Secret)).parseClaimsJws(jsonWebToken).getBody();
		}
		catch (ExpiredJwtException e) {
			System.out.println("token已过期");
		}
		catch (SignatureException e) {
			System.out.println("签名校验失败");
		}
		catch (Exception e) {
			System.out.println("其它错误");
		}
	}

	public static String createJWT(String username, String roles, String privileges) {
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);

		// 生成签名密钥
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(base64Secret);
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

		// 添加构成JWT的参数
		JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT").claim("user_name", username).claim("user_role", roles)
		        .claim("user_privilege", privileges).signWith(signatureAlgorithm, signingKey);
		// 添加Token过期时间
		if (expiresSecond >= 0) {
			long expMillis = nowMillis + expiresSecond;
			Date exp = new Date(expMillis);
			builder.setExpiration(exp).setNotBefore(now);
		}

		// 生成JWT
		return builder.compact();
	}

}
