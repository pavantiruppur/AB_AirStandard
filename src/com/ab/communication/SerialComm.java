package com.ab.communication;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;

import com.ab.Handler;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;

public class SerialComm {
	/** Milliseconds to block while waiting for port open */
	private static final int TIME_OUT = 2000;

	/** Default bits per second for COM port. */
	private static final int DATA_RATE = 9600;
	
	public static SerialWriter writer = null;
	
	public static Timer timer = null;

	public SerialComm() {
		super();
	}

	public void connect(String portName) throws Exception {
		CommPortIdentifier portIdentifier = CommPortIdentifier
				.getPortIdentifier(portName);
		if (portIdentifier.isCurrentlyOwned()) {
			System.out.println("Error: Port is currently in use");
		} else {
			CommPort commPort = portIdentifier.open(this.getClass().getName(),
					TIME_OUT);

			if (commPort instanceof SerialPort) {
				SerialPort serialPort = (SerialPort) commPort;
				serialPort.setSerialPortParams(DATA_RATE,
						SerialPort.DATABITS_8, SerialPort.STOPBITS_1,
						SerialPort.PARITY_NONE);

				InputStream in = serialPort.getInputStream();
				OutputStream out = serialPort.getOutputStream();

				(new Thread(new SerialReader(in))).start();
				writer = new SerialWriter(out);

			} else {
				System.out.println("Error: Only serial ports are handled by this example.");
			}
		}
	}

	/** */
	public static class SerialReader implements Runnable {
		InputStream in;

		public SerialReader(InputStream in) {
			this.in = in;
		}

		public void run() {
            System.out.println("**************");
			byte[] buffer = new byte[1024];
			int len = -1;
			int index = 0;
		    byte[] data = new byte[6]; 
		    String key = "";
		    Map<String, List<Byte>> dataSet = new HashMap<>();
			try {
				while ((len = this.in.read(buffer)) > -1) {
					System.out.println(len);
	                for(int i=0;i<len;i++){
	                		if (buffer[i] == 2){
							index=0;
							data = new byte[6];
						} else if (index == 0) {
							index++;
						} else if (index == 1 && buffer[i] != 3) {
							index++;
							key = String.format("%02x", buffer[i]);
							dataSet.put(key, new ArrayList<Byte>());
						} else if (index < 8 && buffer[i] != 3) {
							if(index == 7) {
								index = 1;
							} else {
								index++;
							}
							dataSet.get(key).add(buffer[i]);
						} else if (buffer[i] == 3) {
							try {
								System.out.println("------- " + dataSet);
								Handler.handleView("CommUpdateView.updateData", dataSet);
							} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
									| NoSuchMethodException | SecurityException e) {}
							dataSet = new HashMap<>();
						}
	                }
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/** */
	public static class SerialWriter implements Runnable {
		OutputStream out;

		public SerialWriter(OutputStream out) {
			this.out = out;
		}

		public void run() {
			try {
				int c = 0;
				while ((c = System.in.read()) > -1) {
					this.out.write(c);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public void write(String data){
			try {
				this.out.write(data.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public void write(int data){
			try {
				this.out.write(data);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
