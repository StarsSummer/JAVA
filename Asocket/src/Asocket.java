
import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.*;

import javax.swing.*;

public class Asocket{
	public int i=1;
	private int numa,numb,timea,timeb;
	private int scorea=0,scoreb=0;
	public static void main(String[] args) {
		new Asocket();
		
	}

	public Asocket() {

		try {
			// Create a server socket
			ServerSocket serverSocket = new ServerSocket(8000);
			DatagramSocket serverSocket2 = new DatagramSocket(8001);
			System.out.println("MultiThreadServer started at " + new Date() + '\n');
			System.out.println("Server started at " + new Date() + '\n');
			System.out.println("             ThreadA                   ThreadB");
			System.out.println("Round  sleep  Random  Points     sleep  Random  Points");
			System.out.println("       time   integer obtained   time   integer obtained");


			while (true) {
				// Listen for a new connection request
				Socket socket = serverSocket.accept();
				// Create a new thread for the connection
				HandleATCP thread = new HandleATCP(socket);
				HandleAUDP thread2 =new HandleAUDP(serverSocket2);
				// Start the new thread
				thread.start();
				thread2.start();
				try {
					thread.join();
					thread2.join();
				} catch (InterruptedException e) {
				}
				
				numb=thread.num;
				timeb=thread.time;
				numa=thread2.num;
				timea=thread2.time;
				if(numa>numb)
					scorea++;
				else
					if(numb>numa)
						scoreb++;
				System.out.printf("%d      %-7d%-8d%-11d%-7d%-8d%-11d\n",i++,timea,numa,scorea,timeb,numb,scoreb);
				if(i==9){
					System.out.printf("%d      %-7d%-8d%-11d%-7d%-8d%-11d\n",i++,timea,numa,scorea,timeb,numb,scoreb);
					System.out.println("\ntatal points---ThreadA:"+scorea+",ThreadB:"+scoreb);
					if(scorea>scoreb)
						System.out.println("\nA is the winner");
					else
						System.out.println("\nB is the winner");
					break;
				}
				
			}
		} catch (IOException ex) {
			System.err.println(ex);
		}
	}

	// Inner class
	// Define the thread class for handling new connection
	class HandleATCP extends Thread {
		private Socket socket; // A connected socket
		public int num,time;
		/** Construct a thread */
		public HandleATCP(Socket socket) {
			this.socket = socket;
		}

		/** Run a thread */
		public void run() {
			try {
				// Create data input and output streams
				DataInputStream inputFromClient = new DataInputStream(
						socket.getInputStream());

				// Continuously serve the client
				while (true) {
					num = inputFromClient.readInt();
					time =inputFromClient.readInt();
				}
			} catch (IOException e) {
			}
		}
	}
	
	class HandleAUDP extends Thread {
		private DatagramSocket socket; // A connected socket
		public int num,time;
		/** Construct a thread */
		public HandleAUDP(DatagramSocket socket) {
			this.socket = socket;
		}

		/** Run a thread */
		public void run() {
			try {
				byte[] buffer = new byte[8];
			    DatagramPacket packet = new DatagramPacket(buffer, 8);
				socket.receive(packet);
				int a=(buffer[0]&0xff)<<24;
				int b=(buffer[1]&0xff)<<16;
				int c=(buffer[2]&0xff)<<8;
				int d=(buffer[3]&0xff);
				time=a|b|c|d;
				num=buffer[4];
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
