package com.finproto.sample.messages;

import org.junit.Test;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class LonginTest {
    @Test
    public void testEncodeAndDecode() {
        Login login = new Login();
        login.setUsername("testUser");
        login.setPassword("testPass");
        // Encode the Longin object to a ByteBuf
        ByteBuf byteBuf = Unpooled.buffer();
        login.encode(byteBuf);
        // Decode the ByteBuf back to a Longin object
        Login decodedLogin = new Login();
        decodedLogin.decode(byteBuf);
        // Assert that the decoded values match the original values
        assert "testUser".equals(decodedLogin.getUsername());
        assert "testPass".equals(decodedLogin.getPassword());
        // Release the ByteBuf to prevent memory leaks
        System.out.println("Origin Login: " + login);
        System.out.println("Decoded Login: " + decodedLogin);
        byteBuf.release();
    }
}
