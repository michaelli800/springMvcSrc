package com.lginfor.common.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NetClientGet {

	public String invokeGet(String link) {
		StringBuffer buffer = new StringBuffer();
		try {

			URL url = new URL("http://localhost:8080/getGreeting");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				buffer.append(output);
				System.out.println(output);
			}

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

		return buffer.toString();
	}

	// http://localhost:8080/getGreeting
	public static void main(String[] args) {
		NetClientGet client = new NetClientGet();
		client.invokeGet("http://localhost:8080/getGreeting");

	}

}