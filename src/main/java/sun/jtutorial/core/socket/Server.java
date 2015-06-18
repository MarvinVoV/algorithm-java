package sun.jtutorial.core.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by 264929 on 2015/6/18.
 */
public class Server {
    /*
        Read from client.
     */
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;
        BufferedReader is = null;
        PrintWriter os = null;

        try {
            server = new ServerSocket(4700);

            socket = server.accept();

            is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            os = new PrintWriter(socket.getOutputStream());
            String line;
            while (!(line = is.readLine()).equals("bye")) {
                System.out.println("Client:" + line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (os != null)
                os.close();
            try {
                if (is != null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (server != null)
                    server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
