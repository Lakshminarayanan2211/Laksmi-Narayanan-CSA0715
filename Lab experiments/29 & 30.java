import java.net.*;
import java.io.*;

class Main {
    public static void main(String[] args) {

        // Server
        Thread server = new Thread(() -> {
            try {
                ServerSocket ss = new ServerSocket(5000);
                Socket s = ss.accept();

                BufferedReader in = new BufferedReader(
                    new InputStreamReader(s.getInputStream()));

                PrintWriter out = new PrintWriter(
                    s.getOutputStream(), true);

                String msg;

                while ((msg = in.readLine()) != null) {
                    System.out.println("Client: " + msg);
                    out.println("Server Received: " + msg);

                    if (msg.equalsIgnoreCase("bye"))
                        break;
                }

                s.close();
                ss.close();

            } catch (Exception e) {
                System.out.println(e);
            }
        });

        // Client
        Thread client = new Thread(() -> {
            try {
                Thread.sleep(1000);

                Socket s = new Socket("localhost", 5000);

                BufferedReader in = new BufferedReader(
                    new InputStreamReader(s.getInputStream()));

                PrintWriter out = new PrintWriter(
                    s.getOutputStream(), true);

                out.println("Hello Server");
                System.out.println("Server: " + in.readLine());

                out.println("How Are You?");
                System.out.println("Server: " + in.readLine());

                out.println("Bye");
                System.out.println("Server: " + in.readLine());

                s.close();

            } catch (Exception e) {
                System.out.println(e);
            }
        });

        server.start();
        client.start();
    }
}
