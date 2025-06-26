package com.finproto.sample.messages;

import com.finproto.codec.BinaryCodec;
import io.netty.buffer.ByteBuf;
import io.netty.util.internal.StringUtil;
import java.nio.charset.StandardCharsets;

public class Login implements BinaryCodec {

  private String username;
  private String password;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public void encode(ByteBuf byteBuf) {
    if (StringUtil.isNullOrEmpty(this.username)) {
      byteBuf.writeShort(0);
    } else {
      byte[] bytes = this.username.getBytes(StandardCharsets.UTF_8);
      byteBuf.writeShort(bytes.length);
      byteBuf.writeBytes(bytes);
    }
    if (StringUtil.isNullOrEmpty(this.password)) {
      byteBuf.writeShort(0);
    } else {
      byte[] bytes = this.password.getBytes(StandardCharsets.UTF_8);
      byteBuf.writeShort(bytes.length);
      byteBuf.writeBytes(bytes);
    }
  }

  @Override
  public void decode(ByteBuf byteBuf) {
    short len = byteBuf.readShort();
    if (len > 0) {
      this.username = byteBuf.readCharSequence(len, StandardCharsets.UTF_8).toString();
    }
    len = byteBuf.readShort();
    if (len > 0) {
      this.password = byteBuf.readCharSequence(len, StandardCharsets.UTF_8).toString();
    }
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((username == null) ? 0 : username.hashCode());
    result = prime * result + ((password == null) ? 0 : password.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Login other = (Login) obj;
    if (username == null) {
      if (other.username != null) return false;
    } else if (!username.equals(other.username)) return false;
    if (password == null) {
      if (other.password != null) return false;
    } else if (!password.equals(other.password)) return false;
    return true;
  }

  @Override
  public String toString() {
    return "Login [username=" + username + ", password=" + password + "]";
  }
}
