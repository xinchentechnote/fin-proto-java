package com.finproto.bitmap;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class ByteBitMapTest {

  @Test
  public void testSetAndGet() {
    ByteBitMap bm = new ByteBitMap();

    for (int i = 0; i < bm.bitCount(); i++) {
      assertFalse("bit " + i + " should be false initially", bm.get(i));
    }

    bm.set(0); // MSB
    bm.set(3);
    bm.set(7); // LSB

    assertTrue(bm.get(0));
    assertTrue(bm.get(3));
    assertTrue(bm.get(7));

    for (int i = 0; i < 8; i++) {
      if (i != 0 && i != 3 && i != 7) {
        assertFalse("bit " + i + " should be false", bm.get(i));
      }
    }
  }

  @Test
  public void testClear() {
    ByteBitMap bm = new ByteBitMap();
    bm.set(0);
    bm.set(5);

    assertTrue(bm.get(0));
    assertTrue(bm.get(5));

    bm.clear(0);
    assertFalse(bm.get(0));
    assertTrue(bm.get(5));

    bm.clear(5);
    assertFalse(bm.get(5));
  }

  @Test
  public void testWriteAndRead() {
    ByteBitMap bm = new ByteBitMap();

    bm.set(1);
    bm.set(4);
    bm.set(7);

    ByteBuf buf = Unpooled.buffer();
    bm.write(buf);

    assertEquals(1, buf.readableBytes());

    ByteBitMap bm2 = new ByteBitMap();
    bm2.read(buf);

    for (int i = 0; i < 8; i++) {
      assertEquals("bit mismatch at pos " + i, bm.get(i), bm2.get(i));
    }
  }

  @Test
  public void testRoundTripAllBits() {
    for (int mask = 0; mask < 256; mask++) {
      ByteBitMap bm = new ByteBitMap();

      for (int pos = 0; pos < 8; pos++) {
        if (((mask >> (7 - pos)) & 1) == 1) {
          bm.set(pos);
        }
      }

      ByteBuf buf = Unpooled.buffer();
      bm.write(buf);

      ByteBitMap bm2 = new ByteBitMap();
      bm2.read(buf);

      for (int pos = 0; pos < 8; pos++) {
        assertEquals(
            "RoundTrip mismatch at mask=" + mask + " pos=" + pos, bm.get(pos), bm2.get(pos));
      }
    }
  }

  @Test
  public void testBitCount() {
    ByteBitMap bm = new ByteBitMap();
    assertEquals(8, bm.bitCount());
  }
}
