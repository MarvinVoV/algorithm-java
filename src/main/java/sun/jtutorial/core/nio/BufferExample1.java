package sun.jtutorial.core.nio;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/**
 * Created by 264929 on 2015/7/27.
 */
public class BufferExample1 {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);

        buffer.put((byte)'H').put((byte)'e').put((byte)'l').put((byte)'l').put((byte)'o');

        showBufferAttr(buffer);

        buffer.flip();
        showBufferAttr(buffer);

        for(int i = 0; buffer.hasRemaining(); i++) {
            System.out.printf("%c ", buffer.get());
        }

    }

    private static void showBufferAttr(Buffer buffer) {
        String result = String.format("position = %d, limit = %d, capacity = %d\n", buffer.position(),
                buffer.limit(), buffer.capacity());
        System.out.println(result);
    }
}
