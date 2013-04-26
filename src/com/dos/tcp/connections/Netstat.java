/**
 * 
 */
package com.dos.tcp.connections;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author Prabu S B
 *
 */
public class Netstat {
	
	final static String cmd = "netstat -n";
	
	public static void getAvailableCOnnection() {
		   try {
		        Process process = Runtime.getRuntime().exec(cmd);

		        InputStream in = process.getInputStream();

		        File tmp = File.createTempFile("allConnections","txt");

		        byte[] buf = new byte[256];

		        OutputStream outputConnectionsToFile = new FileOutputStream(tmp);

		        int numbytes = 0;

		        while ((numbytes = in.read(buf, 0, 256)) != -1) {

		            outputConnectionsToFile.write(buf, 0, numbytes);

		        }

		        System.out.println("File is present at "+tmp.getAbsolutePath());


		    } catch (Exception e) {
		        e.printStackTrace(System.err);
		    }
	}
	
	public static void main(String args[]) {
		getAvailableCOnnection();
	}

 

}
