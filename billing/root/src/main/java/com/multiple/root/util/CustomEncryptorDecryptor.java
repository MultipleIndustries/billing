package com.multiple.root.util;

import java.security.AlgorithmParameters;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

public class CustomEncryptorDecryptor {

	/*private static String salt;
    private static int iterations = 65536  ;
    private static int keySize = 256;
    private static byte[] ivBytes;

    private static SecretKey secretKey;
	public static String SHA256Hash(String orginal){
		return DigestUtils.sha256Hex(orginal);
	}
	
	 public static String encrypt(String original) throws Exception {
		 	salt=getSalt();
	        byte[] saltBytes = salt.getBytes();
	        char[] plaintext = original.toCharArray();

	        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
	        PBEKeySpec spec = new PBEKeySpec(plaintext, saltBytes, iterations, keySize);
	        secretKey = skf.generateSecret(spec);
	        SecretKeySpec secretSpec = new SecretKeySpec(secretKey.getEncoded(), "AES");

	        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
	        cipher.init(Cipher.ENCRYPT_MODE, secretSpec);
	        AlgorithmParameters params = cipher.getParameters();
	        ivBytes = params.getParameterSpec(IvParameterSpec.class).getIV();
	        byte[] encryptedTextBytes = cipher.doFinal(String.valueOf(plaintext).getBytes("UTF-8"));

	        return DatatypeConverter.printBase64Binary(encryptedTextBytes);
	    }

	    public static String decrypt(String encryptedString) throws Exception {

	        System.out.println(encryptedString);
	        char[] encryptedText =encryptedString.toCharArray();

	        byte[] encryptedTextBytes = DatatypeConverter.parseBase64Binary(new String(encryptedText));
	        SecretKeySpec secretSpec = new SecretKeySpec(secretKey.getEncoded(), "AES");

	        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
	        cipher.init(Cipher.DECRYPT_MODE, secretSpec, new IvParameterSpec(ivBytes));

	        byte[] decryptedTextBytes = null;

	        try {
	            decryptedTextBytes = cipher.doFinal(encryptedTextBytes);
	        }   catch (IllegalBlockSizeException e) {
	            e.printStackTrace();
	        }   catch (BadPaddingException e) {
	            e.printStackTrace();
	        }
	        return new String(decryptedTextBytes);
	    }

	    public static String getSalt() throws Exception {

	        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
	        byte[] salt = new byte[20];
	        sr.nextBytes(salt);
	        return new String(salt);
	    }*/
	

	public static String encrypt(String plainText)
			throws Exception {
		SecretKey secretKey = getKey();
		byte[] plainTextByte = plainText.getBytes();
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		byte[] encryptedByte = cipher.doFinal(plainTextByte);
//		Base64.Encoder encoder = Base64.getEncoder();
		String encryptedText = Base64.encodeBase64String(encryptedByte);
		return encryptedText;
	}

	public static String decrypt(String encryptedText)
			throws Exception {
		SecretKey secretKey = getKey();
		Cipher cipher = Cipher.getInstance("AES");
//		Base64.Decoder decoder = Base64.getDecoder();
		byte[] encryptedTextByte = Base64.decodeBase64(encryptedText);
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		byte[] decryptedByte = cipher.doFinal(encryptedTextByte);
		String decryptedText = new String(decryptedByte);
		return decryptedText;
	}
	
	private static SecretKey getKey() throws NoSuchAlgorithmException{
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update("multiple@123".getBytes());
		byte[] encryptionKey = md.digest();
		SecretKey secretKey = new SecretKeySpec(encryptionKey, "AES");
		return secretKey;
	}
	
	public static void main(String[] args){
		String og = "9967565010";
		
		System.out.println(og);
		
		try {
			System.out.println("Key :"+getKey().toString());
			System.out.println(encrypt(og));
			System.out.println(decrypt("6FK61yI8Y5DIrZVRMagcwg=="));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
