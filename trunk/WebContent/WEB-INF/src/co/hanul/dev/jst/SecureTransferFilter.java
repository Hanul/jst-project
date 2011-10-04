package co.hanul.dev.jst;

import static co.hanul.dev.jst.Constants.SESSION_PRIVATE_KEY;
import static co.hanul.dev.jst.Constants.SECURED_QUERY_NAME;

import java.io.IOException;
import java.security.PrivateKey;
import java.util.Map;
import java.util.Set;

import javax.crypto.Cipher;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 보안 전송 필터
 * 
 * @author 심영재(Mr. 하늘)
 */
public class SecureTransferFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		if (request.getMethod().equals("POST") && request.getParameter(SECURED_QUERY_NAME) != null) {
			HttpSession session = request.getSession();
			PrivateKey privateKey = (PrivateKey) session.getAttribute(SESSION_PRIVATE_KEY);
			session.removeAttribute(SESSION_PRIVATE_KEY); // 키의 재사용을 막는다. 항상 새로운 키를 받도록 강제한다.

			try {
				String securedQuery = decryptRsa(privateKey, request.getParameter(SECURED_QUERY_NAME));
				if (Boolean.parseBoolean(securedQuery)) {

					@SuppressWarnings("unchecked")
					Map<String, String[]> params = request.getParameterMap();
					Set<String> set = params.keySet();

					int i;
					for (String name : set) {
						if (params.get(name) instanceof String[]) {
							String[] paramsArray = params.get(name);

							for (i = 0; i < paramsArray.length; i++) {
								paramsArray[i] = decryptRsa(privateKey, paramsArray[i]);
							}
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		chain.doFilter(request, response);
	}

	private String decryptRsa(PrivateKey privateKey, String securedValue) throws Exception {
		Cipher cipher = Cipher.getInstance("RSA");
		byte[] encryptedBytes = hexToByteArray(securedValue);
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
		String decryptedValue = new String(decryptedBytes, "utf-8"); // 문자 인코딩에 주의한다.
		return decryptedValue;
	}

	/**
	 * 16진 문자열을 byte 배열로 변환한다.
	 */
	public static byte[] hexToByteArray(String hex) {
		if (hex == null || hex.length() % 2 != 0) {
			return new byte[] {};
		}

		byte[] bytes = new byte[hex.length() / 2];
		for (int i = 0; i < hex.length(); i += 2) {
			byte value = (byte) Integer.parseInt(hex.substring(i, i + 2), 16);
			bytes[(int) Math.floor(i / 2)] = value;
		}
		return bytes;
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
