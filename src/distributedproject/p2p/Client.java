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

/**
 *
 * @author me
 */
public class Client {

    private String clientIp;
    private String alias;
    private Channel channel;
    private InetSocketAddress address;
    private String destinationIp;
    private int sourcePort;
    private int destPort;

    public Client(String destinationIP, JTextArea chatBox, int sourcePort, int destPort) throws SocketException {
        setClientIp();
        System.out.println("My IP: " + clientIp);
        this.destPort = destPort;
        channel = new Channel(chatBox);
        channel.bind(sourcePort);
        channel.start();

    }
    
    public void setAlias(String alias){
        this.alias = alias;
    }
    

    public String sendMessage(String msg, String alias, String destinationIp) {
        final String secretKey = "shhhhhhhhh!!!";
        if (msg.isEmpty()) {
            return null;
        }

        msg = AES.encrypt(alias + ": " + msg, secretKey );
        try {
            address = new java.net.InetSocketAddress(destinationIp, destPort);
            channel.sendTo(address, msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(msg);
        msg = AES.decrypt(msg, secretKey);
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
