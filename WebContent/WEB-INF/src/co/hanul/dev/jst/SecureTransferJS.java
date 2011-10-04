package co.hanul.dev.jst;

import static co.hanul.dev.jst.Constants.KEY_SIZE;
import static co.hanul.dev.jst.Constants.SECURED_QUERY_NAME;
import static co.hanul.dev.jst.Constants.SESSION_PRIVATE_KEY;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 보안 전송 JavaScript 로드
 * 
 * @author 심영재(Mr. 하늘)
 */
public class SecureTransferJS extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SecureTransferJS() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
			generator.initialize(KEY_SIZE);

			KeyPair keyPair = generator.genKeyPair();
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");

			PublicKey publicKey = keyPair.getPublic();
			PrivateKey privateKey = keyPair.getPrivate();

			HttpSession session = request.getSession();
			// 세션에 공개키의 문자열을 키로하여 개인키를 저장한다.
			session.setAttribute(SESSION_PRIVATE_KEY, privateKey);

			// 공개키를 문자열로 변환하여 JavaScript RSA 라이브러리 넘겨준다.
			RSAPublicKeySpec publicSpec = (RSAPublicKeySpec) keyFactory.getKeySpec(publicKey, RSAPublicKeySpec.class);

			String publicKeyModulus = publicSpec.getModulus().toString(16);
			String publicKeyExponent = publicSpec.getPublicExponent().toString(16);

			PrintWriter out = response.getWriter();
			out.println("var publicKeyModulus = '" + publicKeyModulus + "';");
			out.println("var publicKeyExponent = '" + publicKeyExponent + "';");
			out.println("var SECURED_QUERY_NAME = '" + SECURED_QUERY_NAME + "';");

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
	}

}
