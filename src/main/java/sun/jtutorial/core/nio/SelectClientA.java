package sun.jtutorial.core.nio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * Created by 264929 on 2015/7/27.
 */
public class SelectClientA {

    private static Logger logger = LoggerFactory.getLogger(SelectClientA.class);

    public static void main(String[] args) {
        SocketChannel client = null;
        Selector selector = null;

        try {
            client = SocketChannel.open();
            client.configureBlocking(false);

            selector = Selector.open();
            client.register(selector, SelectionKey.OP_CONNECT);

            InetSocketAddress inetSocketAddress = new InetSocketAddress(Constants.HOST, Constants.PORT);
           client.connect(inetSocketAddress);

            while (true) {
                selector.select();

                Iterator<SelectionKey> it = selector.selectedKeys().iterator();
                while (it.hasNext()) {
                    SelectionKey key = it.next();
                    try {
                        if (key.isConnectable()) {
                            SocketChannel socketChannel = (SocketChannel) key.channel();
                            if (socketChannel.finishConnect()) {
                                logger.info("connecte to {} success.", socketChannel.getRemoteAddress());
                            }else {
                                logger.info("connecte to {} failed.", socketChannel.getRemoteAddress());
                            }
                            socketChannel.register(selector, SelectionKey.OP_READ);
                        }

                        if (key.isReadable()) {
                            System.out.println("readable");
                            readDataFromSocket(key);
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
                if (selector != null) {
                    selector.close();
                }
                if (client != null) {
                    client.socket().close();
                    client.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    private static void readDataFromSocket(SelectionKey key) throws Exception {
        int count;
        SocketChannel channel = (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(16 * 1024);
        buffer.clear();

        while ((count = channel.read(buffer)) > 0) {
            // make buffer readable
            buffer.flip();
            // send the data; don't assume it goes all at once.
            //while (buffer.hasRemaining()) {
                System.out.println(Tools.getString(buffer));
            //}

            buffer.clear();
        }
        if (count < 0) {
            // close channel on EOF, invalidates the key
            channel.close();
        }
    }
}


