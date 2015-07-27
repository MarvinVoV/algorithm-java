package sun.jtutorial.core.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/**
 * Created by 264929 on 2015/7/27.
 */
public class ChannelCopy {
    public static void main(String[] args) throws IOException {
        ReadableByteChannel source = Channels.newChannel(System.in);
        WritableByteChannel dest = Channels.newChannel(System.out);

        channelCopy(source, dest);

        source.close();
        dest.close();
    }

    private static void channelCopy(ReadableByteChannel src, WritableByteChannel dst)
            throws IOException {

        ByteBuffer buffer = ByteBuffer.allocate(16 * 1024);
        while (src.read(buffer) != -1) {
            // Prepare the buffer to drained
            buffer.flip();

            // Write to the channel; may block
            dst.write(buffer);

            // If partial transfer, shift remainder down
            // If buffer is empty, same as doing clear
            buffer.compact();
        }

        // EOF will leave buffer in fill state
        buffer.flip();

        // Make sure that the buffer is fully drained
        while (buffer.hasRemaining()) {
            dst.write(buffer);
        }
    }
}
