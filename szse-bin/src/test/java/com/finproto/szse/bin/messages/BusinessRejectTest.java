package com.finproto.szse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class BusinessRejectTest {
  @Test
  public void testEncodeDecode() {
    BusinessReject original = new BusinessReject();
    original.setApplId("111");
    original.setTransactTime(8L);
    original.setSubmittingPbuid("111111");
    original.setSecurityId("11111111");
    original.setSecurityIdsource("1111");
    original.setRefSeqNum(8L);
    original.setRefMsgType(4);
    original.setBusinessRejectRefId("1111111111");
    original.setBusinessRejectReason((short) 2);
    original.setBusinessRejectText("11111111111111111111111111111111111111111111111111");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    BusinessReject decoded = new BusinessReject();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
