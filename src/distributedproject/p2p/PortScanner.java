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
import java.util.*;

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
        Hashtable yafeelme = new Hashtable(); 
        Enumeration aliases;
        String str;
        
        
        if (running) {
            for (int i = 1; i < 120; i++) {
                if (!running) {
                    break;
                }
                String host = "192.168.1." + i;
                
                
                try {
                    if (InetAddress.getByName(host).isReachable(timeout) && !clientIp.replace("/", "").equals(host)) {
                        //String anon_alias = "Anonymous_Cat";
                        System.out.println(host + " is reachable");
                        //peers.add(anon_alias);
                        peerList.setListData(peers);

//                    checkPort(host);
                    } else {
                        System.out.println(host + " is NOT reachable");
                        String thisdoieck = "Anonymous Koala lol";
                        peers.add(thisdoieck);
                        peerList.setListData(peers);
                        yafeelme.put("Bob", new String(host));
                
                        // show da Hash Table lawels
                        aliases = yafeelme.keys();
                
                        while(aliases.hasMoreElements()) {
                            str = (String) aliases.nextElement();
                            System.out.println(str + ": " + yafeelme.get(str));
                        }        
                        System.out.println();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
