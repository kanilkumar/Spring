package com.anil.crypto;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class SymmetricEncryption {

	static byte[] iv;

	public static void main(String[] args) {
		String originalStr = "Hello Anil!";
		String encryptedString = encryptData(originalStr);
		System.out.println("Original String ::" + originalStr);
		System.out.println("Encrypted String ::" + encryptedString);
		String decryptedString = decryptData(encryptedString);
		System.out.println("Decrypted String ::" + decryptedString);
	}

	public static String encryptData(String inputData) {
		String encryptedString = null;
		try {
			String key = "SampleEncryption";
			SecretKey secretKey = new SecretKeySpec(key.getBytes(), "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			byte[] cipherText = cipher.doFinal(inputData.getBytes());
			iv = cipher.getIV();
			encryptedString = new String(cipherText);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException
				| BadPaddingException e) {
			e.printStackTrace();
		}
		return encryptedString;
	}

	public static String decryptData(String encryptedData) {
		String decryptedString = null;
		try {
			String key = "SampleEncryption";
			SecretKey secretKey = new SecretKeySpec(key.getBytes(), "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(iv));
			decryptedString = new String(cipher.doFinal(encryptedData.getBytes()));
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException
				| InvalidKeyException | InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		}
		return decryptedString;
	}

}
