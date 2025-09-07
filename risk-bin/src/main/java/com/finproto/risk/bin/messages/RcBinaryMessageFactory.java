package com.finproto.risk.bin.messages;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import com.finproto.codec.BinaryCodec;

public enum RcBinaryMessageFactory {
    INSTANCE;

    private final Map<Integer, Supplier<BinaryCodec>> codecMap = new HashMap<>();

    public void register(int msgType, Supplier<BinaryCodec> codec) {
        codecMap.put(msgType, codec);
    }

    static {
        getInstance().register((int) 100101, NewOrder::new);
        getInstance().register((int) 200102, OrderConfirm::new);
        getInstance().register((int) 200115, ExecutionReport::new);
        getInstance().register((int) 190007, OrderCancel::new);
        getInstance().register((int) 290008, CancelReject::new);
        getInstance().register((int) 800001, RiskResult::new);
    }

    public BinaryCodec create(int msgType) {
        Supplier<BinaryCodec> supplier = codecMap.get(msgType);
        if (null == supplier) {
            throw new IllegalArgumentException("Unsupported MsgType:" + msgType);
        }
        return supplier.get();
    }

    public boolean remove(int msgType) {
        return codecMap.remove(msgType) != null;
    }

    public static RcBinaryMessageFactory getInstance() {
        return INSTANCE;
    }
}
