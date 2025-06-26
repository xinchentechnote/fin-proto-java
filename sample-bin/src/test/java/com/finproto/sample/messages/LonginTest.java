package com.finproto.sample.messages;

import static org.junit.Assert.assertEquals;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

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
    assertEquals("testUser", decodedLogin.getUsername());
    assertEquals("testPass", decodedLogin.getPassword());
    assertEquals(login, decodedLogin);
    // Release the ByteBuf to prevent memory leaks
    System.out.println("Origin Login: " + login);
    System.out.println("Decoded Login: " + decodedLogin);
    byteBuf.release();
  }
}
