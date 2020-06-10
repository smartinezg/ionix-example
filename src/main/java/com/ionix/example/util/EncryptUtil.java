package com.ionix.example.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EncryptUtil {

	private static final Logger logger = LogManager.getLogger(EncryptUtil.class);

	public static String getEncryptDES(String value) {
		String encryptValue = "";
		try {
			DESKeySpec keySpec = new DESKeySpec("ionix123456".getBytes("UTF8"));
			SecretKey secretKey = SecretKeyFactory.getInstance("DES").generateSecret(keySpec);
			byte[] valueByte = value.getBytes("UTF8");
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE,secretKey);
			encryptValue = Base64.getEncoder().encodeToString(cipher.doFinal(valueByte));
		} catch (InvalidKeyException invalidKey) {
			logger.error(invalidKey.getMessage());
		} catch (UnsupportedEncodingException unsupportedEncoding) {
			logger.error(unsupportedEncoding.getMessage());
		} catch (InvalidKeySpecException invalidKeySpec) {
			logger.error(invalidKeySpec.getMessage());
		} catch (NoSuchAlgorithmException noSuchAlgorithm) {
			logger.error(noSuchAlgorithm.getMessage());
		} catch (NoSuchPaddingException noSuchPadding) {
			logger.error(noSuchPadding.getMessage());
		} catch (IllegalBlockSizeException illegalBlockSize) {
			logger.error(illegalBlockSize.getMessage());
		} catch (BadPaddingException badPadding) {
			logger.error(badPadding.getMessage());
		}
		return encryptValue;
	}
}
