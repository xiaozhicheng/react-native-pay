package com.reactnativepay.payment.alipay;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;


public class SignUtils {

	private static final String ALGORITHM = "RSA";

	private static final String SIGN_ALGORITHMS = "SHA1WithRSA";

	private static final String DEFAULT_CHARSET = "UTF-8";

	public static String sign(String content, String privateKey) {
		try {
			PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(
					Base64.decode(privateKey));
			KeyFactory keyf = KeyFactory.getInstance(ALGORITHM);
			PrivateKey priKey = keyf.generatePrivate(priPKCS8);

			java.security.Signature signature = java.security.Signature
					.getInstance(SIGN_ALGORITHMS);

			signature.initSign(priKey);
			signature.update(content.getBytes(DEFAULT_CHARSET));

			byte[] signed = signature.sign();

			return Base64.encode(signed);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 对支付结果进行验签
	 * 
	 * @author JPH
	 * @date 2015-6-11 上午10:45:06
	 * @param content
	 *            签名内容
	 * @param publicKey
	 *            支付宝公钥
	 * @param sigResult
	 *            要验证的签名内容
	 * @return
	 */
	public static boolean verifySign(String content, String publicKey,
			String sigResult) {
		if (sigResult == null)
			return false;
		try {
			X509EncodedKeySpec xKeySpec = new X509EncodedKeySpec(
					Base64.decode(publicKey));
			KeyFactory keyf = KeyFactory.getInstance(ALGORITHM);
			PublicKey pubKey = keyf.generatePublic(xKeySpec);

			java.security.Signature signature = java.security.Signature
					.getInstance(SIGN_ALGORITHMS);

			signature.initVerify(pubKey);
			signature.update(sigResult.getBytes(DEFAULT_CHARSET));
			return signature.verify(sigResult.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
