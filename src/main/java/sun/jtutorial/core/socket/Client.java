package sun.jtutorial.core.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by 264929 on 2015/6/18.
 */
public class Client {
    /*
        Read line from standard in and send to server.
     */
    public static void main(String[] args) {
        Socket socket = null;
        PrintWriter os = null;
        try {
            socket = new Socket("127.0.0.1", 4700);
            System.out.println("connect success.");

            BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
            os = new PrintWriter(socket.getOutputStream());

            String line;
            while (!(line = sin.readLine()).equals("bye")) {
                os.println(line);
                os.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null)
                os.close();
            try {
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
