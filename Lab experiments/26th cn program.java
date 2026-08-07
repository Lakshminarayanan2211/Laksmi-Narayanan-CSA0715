import java.net.*;
import java.io.*;
import java.util.Date;
class TCPDemo {
    public static void main(String args[]) throws Exception {
        Thread server = new Thread(() -> {
            try {
                ServerSocket ss = new ServerSocket(5000);
                Socket s = ss.accept();
                DataInputStream dis =
                        new DataInputStream(s.getInputStream());
                System.out.println("Server Received: " + dis.readUTF());
                dis.close();
                s.close();
                ss.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        });
        server.start();
        Thread.sleep(1000);
        Socket s = new Socket("localhost", 5000);
        DataOutputStream dos =new DataOutputStream(s.getOutputStream());
        String date = new Date().toString();
        dos.writeUTF(date);
        dos.flush();
        System.out.println("Client Sent: " + date);
        dos.close();
        s.close();
        server.join();
    }
}