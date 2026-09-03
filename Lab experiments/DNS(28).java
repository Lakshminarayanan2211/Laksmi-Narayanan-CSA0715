import java.util.*;
import java.net.*;

class Main {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter hostname: ");
        String hostname = sc.nextLine();

        InetAddress address = InetAddress.getByName(hostname);

        System.out.println("DNS Server resolved the hostname.");
        System.out.println("HostName : " + hostname);
        System.out.println("IP Address : " + address.getHostAddress());

        sc.close();
    }
}
