package sun.jtutorial.core.nio;

import sun.jtutorial.core.socket.Server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketOption;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * Created by 264929 on 2015/7/27.
 */
public class SelectServerA {

    private static ByteBuffer buffer = ByteBuffer.allocate(16 * 1024);

    public static void main(String[] args) {

        ServerSocketChannel server = null;
        Selector selector = null;

        try {
            //  Create a selectable channel for stream-oriented listening sockets
            server = ServerSocketChannel.open();
            server.configureBlocking(false);

            // Create listening socket
            ServerSocket serverSocket = server.socket();
            serverSocket.bind(new InetSocketAddress(Constants.PORT));

            // A multiplexor of SelectableChannel objects.
            selector = Selector.open();

            // Registers listening socket channel with the given selector
            server.register(selector, SelectionKey.OP_ACCEPT);

            while (true) {
                selector.select();

                Iterator<SelectionKey> it = selector.selectedKeys().iterator();
                while (it.hasNext()) {
                    SelectionKey key = it.next();
                    try {
                        if (key.isConnectable()) {
                            System.out.println("server connect");
                            ((SocketChannel) key.channel()).finishConnect();
                        }

                        if (key.isAcceptable()) {
                            SocketChannel client = server.accept();
                            System.out.println(client.getRemoteAddress().toString());
                            client.configureBlocking(false);
                            client.register(selector, SelectionKey.OP_READ);
                            sayHello(client);
                        }

                        if (key.isReadable()) {
                            echoToClient(key);
                        }
                    } catch (IOException ex) {
                        key.cancel();
                    }

                    it.remove();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (selector != null)
                    selector.close();
                if (server != null) {
                    server.socket().close();
                    server.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void sayHello(SocketChannel channel) throws IOException {
        channel.write(ByteBuffer.wrap("hello".getBytes()));
    }

    private static void echoToClient(SelectionKey key) throws Exception {
        int count;
        SocketChannel channel = (SocketChannel) key.channel();

        buffer.clear();
        while ((count = channel.read(buffer)) > 0) {
            // make buffer readable
            buffer.flip();
            // send the data; don't assume it goes all at once.
            while (buffer.hasRemaining()) {
                channel.write(buffer);
            }
            buffer.clear();
        }
        if (count < 0) {
            // close channel on EOF, invalidates the key
            channel.close();
        }
    }
}
