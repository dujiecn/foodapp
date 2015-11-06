package org.market.foodapp.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.apache.commons.codec.binary.Hex;

public class GUIDGenerator {
	private static SecureRandom secureRandom;
	private static String sid;

	static {
		secureRandom = new SecureRandom();
		try {
			sid = InetAddress.getLocalHost().toString();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	public static String nextString() {
		StringBuffer sbValueBeforeMD5 = new StringBuffer(128);
		long time = System.nanoTime();
		long rand = secureRandom.nextLong();
		sbValueBeforeMD5.append(sid);
		sbValueBeforeMD5.append(":");
		sbValueBeforeMD5.append(Long.toString(time));
		sbValueBeforeMD5.append(":");
		sbValueBeforeMD5.append(Long.toString(rand));
		return md5(sbValueBeforeMD5.toString());
	}

	/**
	 * 截取固定长度的md5串
	 * 
	 * @param length
	 * @return
	 */
	public static String nextString(int length) {
		String str = nextString();

		int len = str.length();

		if (length > len) {
			length = len;
		} else if (length < 0) {
			length = 0;
		}

		// 随机生成开始下标
		int start = (int) (Math.random() * (len - length));

		return nextString().substring(start, start + length);
	}

	public static String md5(String s) {
		if (s == null) {
			return null;
		}

		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
			md5.update(s.getBytes());
			byte[] array = md5.digest();
			return Hex.encodeHexString(array);
		} catch (NoSuchAlgorithmException e) {
		}
		return null;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			System.out.println(nextString(10));
		}

	}

}