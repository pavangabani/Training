package socketprogramming.datagram;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket=new DatagramSocket(8888);

        byte[] message=new byte[1024];
        DatagramPacket datagramPacket=new DatagramPacket(message,message.length);
        datagramSocket.receive(datagramPacket);

        String clientMessage=new String(datagramPacket.getData(),0,datagramPacket.getLength());
        System.out.println(clientMessage);
    }
}
