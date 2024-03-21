import io.github.pixee.security.ObjectInputFilters;
import java.net.*;
import java.io.*;

class SockClient {
     public static void main (String args[]) throws Exception {
        Socket      sock = new Socket("localhost", 8888);    //Any IP name

        ObjectInputStream in = new ObjectInputStream(sock.getInputStream());
        ObjectInputFilters.enableObjectFilterIfUnprotected(in);
        ObjectOutputStream out = new ObjectOutputStream(sock.getOutputStream());

        String s = (String) in.readObject();
        out.writeObject("Back at you");

        in.close();
        out.close();
        sock.close();
    }
}
