/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distributedproject.p2p;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Vector;
import javax.swing.JList;

/**
 *
 * @author Jacob French
 */
public class PortScanner implements Runnable {

    private boolean running;
    private JList peerList;
    private Vector<String> peers;
    private String clientIp;

    public PortScanner(JList peerList, String clientIp) {
        this.peerList = peerList;
        this.clientIp = clientIp;
        this.peers = new Vector<>();

    }

    public void start() {
        Thread thread = new Thread(this);
        running = true;
        thread.start();
    }

    public void stop() {
        running = false;
        System.out.println("Stop.");
    }

    @Override
    public void run() {
        int timeout = 1000;
        int port = 8000;
        if (running) {
            for (int i = 1; i < 120; i++) {
                if (!running) {
                    break;
                }
                String host = "192.168.1." + i;
                try {
                    if (InetAddress.getByName(host).isReachable(timeout) && !clientIp.replace("/", "").equals(host)) {
                        System.out.println(host + " is reachable");
                        peers.add(host);
                        peerList.setListData(peers);

//                    checkPort(host);
                    } else {
                        System.out.println(host + " is NOT reachable");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

//    public boolean isSocketAliveUitlitybyCrunchify(String hostName, int port) {
//        boolean isAlive = false;
//
//        // Creates a socket address from a hostname and a port number
//        SocketAddress socketAddress = new InetSocketAddress(hostName, port);
//        Socket socket = new Socket();
//
//        // Timeout required - it's in milliseconds
//        int timeout = 2000;
//
//        log("hostName: " + hostName + ", port: " + port);
//        try {
//            socket.connect(socketAddress, timeout);
//            socket.close();
//            isAlive = true;
//
//        } catch (SocketTimeoutException exception) {
//            System.out.println("SocketTimeoutException " + hostName + ":" + port + ". " + exception.getMessage());
//        } catch (IOException exception) {
//            System.out.println(
//                    "IOException - Unable to connect to " + hostName + ":" + port + ". " + exception.getMessage());
//        }
//        return isAlive;
//    }
//
//    // Simple log utility
//    private void log(String string) {
//        System.out.println(string);
//    }
//
//    // Simple log utility returns boolean result
//    private void log(boolean isAlive) {
//        System.out.println("isAlive result: " + isAlive + "\n");
//    }
//
//    public void checkPort(String host) throws UnknownHostException {
//        InetAddress inetAddress = InetAddress.getByName(host);
//        String hostName = inetAddress.getHostName();
//        try {
//            Socket socket = new Socket(hostName, 8000);
//            String text = hostName + " is listening on port " + 8000;
//            System.out.println(text);
//            socket.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//
//        }
//    }
}
