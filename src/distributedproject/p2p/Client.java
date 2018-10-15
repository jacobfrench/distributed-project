/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distributedproject.p2p;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

/**
 *
 * @author me
 */
public class Client {

    private static int SOURCE_PORT = 8000;
    private static int DEST_PORT = 8000;
    private String clientIp;
    private String alias;
    private Channel channel;
    private InetSocketAddress address;
    private String destinationIp;

    public Client(String destinationIP, JTextArea chatBox) throws SocketException {
        setClientIp();
        System.out.println("My IP: " + clientIp);

        channel = new Channel(chatBox);
        channel.bind(SOURCE_PORT);
        channel.start();

    }
    
    public void setAlias(String alias){
        this.alias = alias;
    }
    

    public String sendMessage(String msg, String name, String destinationIp) {
        if (msg.isEmpty()) {
            return null;
        }

        msg = alias + ": " + msg;
        try {
            address = new java.net.InetSocketAddress(destinationIp, DEST_PORT);
            channel.sendTo(address, msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(msg);
        return msg;

    }

    public void exit() {
        channel.stop();
        System.out.println("Closed.");
    }
    
    public String getClientIp(){
        return clientIp;
    }

    public void setClientIp() {
        Socket socket = new Socket();
        try {
            socket.connect(new InetSocketAddress("google.com", 80));
            this.clientIp = socket.getLocalAddress().toString();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
