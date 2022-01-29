package socketprogramming.datagram;

import java.io.IOException;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket=new DatagramSocket();
        InetAddress ip=InetAddress.getLocalHost();

        String message="Hello Server";
        DatagramPacket datagramPacket=new DatagramPacket(message.getBytes(),message.length(),ip,8888);

        datagramSocket.send(datagramPacket);
    }
}
