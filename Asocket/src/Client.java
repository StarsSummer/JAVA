import java.net.*;
import java.io.*;


public class Client {
	public static void main(String args[])
	{
		
		for(int i=1;i<10;i++){
			UDPThread kidA=new UDPThread();
			TCPThread kidB=new TCPThread();
			new Thread(kidA).start();
			new Thread(kidB).start();
			
		}	
	}
}

class UDPThread implements Runnable{
	private int num,time,score=0;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String name="localhost";
		int port =8001;
		try {
			System.out.println("UDP Connecting to "+name);
			DatagramSocket client=new DatagramSocket();
			InetAddress address = InetAddress.getByName(name);
			System.out.println("Connected to "+address+":"+port);
			num=(int)(Math.random()*(11));
			time=((int)(Math.random()*2000));
			byte[] buffer = new byte[8];
			buffer[0]=(byte)((time>>>24)&0xff);
			buffer[1]=(byte)((time>>>16)&0xff);
			buffer[2]=(byte)((time>>>8)&0xff);
			buffer[3]=(byte)((time>>>0)&0xff);
			buffer[4]=(byte)(num);

			DatagramPacket packet = new DatagramPacket(buffer,8,address,port); 
			client.send(packet); 
			client.close();
			Thread.sleep(time);
		} catch (IOException e) {
		} catch (InterruptedException e) {
		}
	}
}

class TCPThread extends Thread{
	private DataOutputStream outputToServer;
	private int num,time,score=0;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String name="localhost";
		int port =8000;
		try{
			System.out.println("TCP Connecting to "+name);
			Socket client =new Socket(name,port);
			System.out.println("Connected to "+client.getRemoteSocketAddress());
			outputToServer = new DataOutputStream(client.getOutputStream());
			num=(int)(Math.random()*(11));
			time=((int)(Math.random()*2000));
			outputToServer.writeInt(num);
			outputToServer.flush();
			outputToServer.writeInt(time);
			outputToServer.flush();
			outputToServer.close();
			client.close();
			Thread.sleep(time);
		}catch(IOException e)
		{
		} catch (InterruptedException e) {
		} 
	}


}