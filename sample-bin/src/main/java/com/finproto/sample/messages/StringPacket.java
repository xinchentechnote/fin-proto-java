package com.finproto.sample.messages;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;
import com.finproto.codec.BinaryCodec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.internal.StringUtil;


public class StringPacket implements BinaryCodec {
    private String fieldDynamicString;
    private String fieldDynamicString1;
    private String fieldFixedString1;
    private String fieldFixedString10;
    private List<String> fieldDynamicStringList;
    private List<String> fieldDynamicString1List;
    private List<String> fieldFixedString1List;
    private List<String> fieldFixedString10List;

    public String getFieldDynamicString() {
        return this.fieldDynamicString;
    }
    
    
    public void setFieldDynamicString(String fieldDynamicString) {
        this.fieldDynamicString = fieldDynamicString;
    }
    
    public String getFieldDynamicString1() {
        return this.fieldDynamicString1;
    }
    
    
    public void setFieldDynamicString1(String fieldDynamicString1) {
        this.fieldDynamicString1 = fieldDynamicString1;
    }
    
    public String getFieldFixedString1() {
        return this.fieldFixedString1;
    }
    
    
    public void setFieldFixedString1(String fieldFixedString1) {
        this.fieldFixedString1 = fieldFixedString1;
    }
    
    public String getFieldFixedString10() {
        return this.fieldFixedString10;
    }
    
    
    public void setFieldFixedString10(String fieldFixedString10) {
        this.fieldFixedString10 = fieldFixedString10;
    }
    
    public List<String> getFieldDynamicStringList() {
        return this.fieldDynamicStringList;
    }
    
    
    public void setFieldDynamicStringList(List<String> fieldDynamicStringList) {
        this.fieldDynamicStringList = fieldDynamicStringList;
    }
    
    public List<String> getFieldDynamicString1List() {
        return this.fieldDynamicString1List;
    }
    
    
    public void setFieldDynamicString1List(List<String> fieldDynamicString1List) {
        this.fieldDynamicString1List = fieldDynamicString1List;
    }
    
    public List<String> getFieldFixedString1List() {
        return this.fieldFixedString1List;
    }
    
    
    public void setFieldFixedString1List(List<String> fieldFixedString1List) {
        this.fieldFixedString1List = fieldFixedString1List;
    }
    
    public List<String> getFieldFixedString10List() {
        return this.fieldFixedString10List;
    }
    
    
    public void setFieldFixedString10List(List<String> fieldFixedString10List) {
        this.fieldFixedString10List = fieldFixedString10List;
    }
    

    @Override
    public void encode(ByteBuf byteBuf) {
        if (StringUtil.isNullOrEmpty(this.fieldDynamicString)) {
            byteBuf.writeShort(0);
        } else {
            byte[] bytes = this.fieldDynamicString.getBytes(StandardCharsets.UTF_8);
            byteBuf.writeShortLE(bytes.length);
            byteBuf.writeBytes(bytes);
        }
        
        if (StringUtil.isNullOrEmpty(this.fieldDynamicString1)) {
            byteBuf.writeShort(0);
        } else {
            byte[] bytes = this.fieldDynamicString1.getBytes(StandardCharsets.UTF_8);
            byteBuf.writeShortLE(bytes.length);
            byteBuf.writeBytes(bytes);
        }
        
        writeFixedString(byteBuf, this.fieldFixedString1, 1);
        writeFixedString(byteBuf, this.fieldFixedString10, 10);
        if (null == this.fieldDynamicStringList || this.fieldDynamicStringList.size() == 0) {
            byteBuf.writeShort(0);
        } else {
            byteBuf.writeShortLE((short) this.fieldDynamicStringList.size());
            for (int i = 0; i < this.fieldDynamicStringList.size(); i++) {
                if (StringUtil.isNullOrEmpty(this.fieldDynamicStringList.get(i))) {
                    byteBuf.writeShort(0);
                } else {
                    byte[] bytes = this.fieldDynamicStringList.get(i).getBytes(StandardCharsets.UTF_8);
                    byteBuf.writeShortLE(bytes.length);
                    byteBuf.writeBytes(bytes);
                }
                
            }
        }
        if (null == this.fieldDynamicString1List || this.fieldDynamicString1List.size() == 0) {
            byteBuf.writeShort(0);
        } else {
            byteBuf.writeShortLE((short) this.fieldDynamicString1List.size());
            for (int i = 0; i < this.fieldDynamicString1List.size(); i++) {
                if (StringUtil.isNullOrEmpty(this.fieldDynamicString1List.get(i))) {
                    byteBuf.writeShort(0);
                } else {
                    byte[] bytes = this.fieldDynamicString1List.get(i).getBytes(StandardCharsets.UTF_8);
                    byteBuf.writeShortLE(bytes.length);
                    byteBuf.writeBytes(bytes);
                }
                
            }
        }
        if (null == this.fieldFixedString1List || this.fieldFixedString1List.size() == 0) {
            byteBuf.writeShort(0);
        } else {
            byteBuf.writeShortLE((short) this.fieldFixedString1List.size());
            for (int i = 0; i < this.fieldFixedString1List.size(); i++) {
                writeFixedString(byteBuf, this.fieldFixedString1List.get(i), 1);
            }
        }
        if (null == this.fieldFixedString10List || this.fieldFixedString10List.size() == 0) {
            byteBuf.writeShort(0);
        } else {
            byteBuf.writeShortLE((short) this.fieldFixedString10List.size());
            for (int i = 0; i < this.fieldFixedString10List.size(); i++) {
                writeFixedString(byteBuf, this.fieldFixedString10List.get(i), 10);
            }
        }
    }
    

    @Override
    public void decode(ByteBuf byteBuf) {
        short fieldDynamicStringLen = byteBuf.readShortLE();
        if (fieldDynamicStringLen > 0) {
            this.fieldDynamicString = byteBuf.readCharSequence(fieldDynamicStringLen, StandardCharsets.UTF_8).toString();
        }
        short fieldDynamicString1Len = byteBuf.readShortLE();
        if (fieldDynamicString1Len > 0) {
            this.fieldDynamicString1 = byteBuf.readCharSequence(fieldDynamicString1Len, StandardCharsets.UTF_8).toString();
        }
        this.fieldFixedString1 = readFixedString(byteBuf, 1);
        this.fieldFixedString10 = readFixedString(byteBuf, 10);
    short fieldDynamicStringListSize = byteBuf.readShortLE();
        if(fieldDynamicStringListSize > 0) {
        this.fieldDynamicStringList = new ArrayList<>();
        for(int i=0;i<fieldDynamicStringListSize;i++) {
        short fieldDynamicStringListLen = byteBuf.readShortLE();
        if (fieldDynamicStringListLen > 0) {
            this.fieldDynamicStringList.add(byteBuf.readCharSequence(fieldDynamicStringListLen, StandardCharsets.UTF_8).toString());
        }
        }
        }
    short fieldDynamicString1ListSize = byteBuf.readShortLE();
        if(fieldDynamicString1ListSize > 0) {
        this.fieldDynamicString1List = new ArrayList<>();
        for(int i=0;i<fieldDynamicString1ListSize;i++) {
        short fieldDynamicString1ListLen = byteBuf.readShortLE();
        if (fieldDynamicString1ListLen > 0) {
            this.fieldDynamicString1List.add(byteBuf.readCharSequence(fieldDynamicString1ListLen, StandardCharsets.UTF_8).toString());
        }
        }
        }
    short fieldFixedString1ListSize = byteBuf.readShortLE();
        if(fieldFixedString1ListSize > 0) {
        this.fieldFixedString1List = new ArrayList<>();
        for(int i=0;i<fieldFixedString1ListSize;i++) {
        this.fieldFixedString1List.add(readFixedString(byteBuf, 1));
        }
        }
    short fieldFixedString10ListSize = byteBuf.readShortLE();
        if(fieldFixedString10ListSize > 0) {
        this.fieldFixedString10List = new ArrayList<>();
        for(int i=0;i<fieldFixedString10ListSize;i++) {
        this.fieldFixedString10List.add(readFixedString(byteBuf, 10));
        }
        }
    }
    

    @Override
    public int hashCode() {
        return Objects.hash(fieldDynamicString, fieldDynamicString1, fieldFixedString1, fieldFixedString10, fieldDynamicStringList, fieldDynamicString1List, fieldFixedString1List, fieldFixedString10List);
    }
    
    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(null == obj || getClass() != obj.getClass()) {
            return false;
        }
        StringPacket orther_ = (StringPacket) obj;
        return Objects.equals(fieldDynamicString, orther_.fieldDynamicString) && Objects.equals(fieldDynamicString1, orther_.fieldDynamicString1) && Objects.equals(fieldFixedString1, orther_.fieldFixedString1) && Objects.equals(fieldFixedString10, orther_.fieldFixedString10) && Objects.equals(fieldDynamicStringList, orther_.fieldDynamicStringList) && Objects.equals(fieldDynamicString1List, orther_.fieldDynamicString1List) && Objects.equals(fieldFixedString1List, orther_.fieldFixedString1List) && Objects.equals(fieldFixedString10List, orther_.fieldFixedString10List);
    }
    

    @Override
    public String toString() {
        return "StringPacket [" + "fieldDynamicString=" + this.fieldDynamicString + ", fieldDynamicString1=" + this.fieldDynamicString1 + ", fieldFixedString1=" + this.fieldFixedString1 + ", fieldFixedString10=" + this.fieldFixedString10 + ", fieldDynamicStringList=" + this.fieldDynamicStringList + ", fieldDynamicString1List=" + this.fieldDynamicString1List + ", fieldFixedString1List=" + this.fieldFixedString1List + ", fieldFixedString10List=" + this.fieldFixedString10List + "]";
    }
    

}