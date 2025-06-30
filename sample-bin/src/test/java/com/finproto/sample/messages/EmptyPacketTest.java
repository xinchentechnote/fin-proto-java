package com.finproto.sample.messages;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;


public class EmptyPacketTest {
    @Test
    public void testEncodeDecode() {
        EmptyPacket original = new EmptyPacket();
        
        ByteBuf buffer = Unpooled.buffer();
        original.encode(buffer);
        EmptyPacket decoded = new EmptyPacket();
        decoded.decode(buffer);
        assertEquals(original, decoded);
    }
}
