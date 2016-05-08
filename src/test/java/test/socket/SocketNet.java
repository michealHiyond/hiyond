package test.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * 
 * @author Hiyond
 *
 */
@SuppressWarnings("all")
public class SocketNet {

	public void testSocket(){
		String hostName = "time-A.timefreq.bldrdoc.gov";
		Socket socket = new Socket();
		try {
			socket.connect(new InetSocketAddress(hostName, 13), 1000);
			InputStream inputStream = socket.getInputStream();
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
