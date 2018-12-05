/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distributedproject.p2p;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import javax.swing.JTextArea;

/**
 *
 * @author me
 */
public class Channel implements Runnable {

    private DatagramSocket socket;
    private boolean running;
    private JTextArea textArea;

    public Channel(JTextArea chatArea) {
        textArea = chatArea;
    }

    public void bind(int port) throws java.net.SocketException {
        socket = new DatagramSocket(port);
    }

    public void start() {
        Thread thread = new Thread(this);
        thread.start();
    }

    public void stop() {
        running = false;
        socket.close();
    }

    public void run() {
        byte[] buffer = new byte['Ѐ'];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        final String secretKey = "shhhhhhhhh!!!";
        running = true;
        while (running) {
            try {
                socket.receive(packet);
                String msg = new String(buffer, 0, packet.getLength());
                
                System.out.println(msg);
                msg = AES.decrypt(msg, secretKey);
                this.textArea.append(msg+"\n");
            } catch (IOException e) {
                break;
            }
        }
    }
    


    public void sendTo(java.net.SocketAddress address, String msg) throws IOException {
        byte[] buffer = msg.getBytes();

        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        packet.setSocketAddress(address);

        socket.send(packet);
    }

}
