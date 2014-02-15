package com.mikehelmick.proc;

import java.io.Serializable;

/**
 * Message that is sent 
 */
public final class Message implements Serializable {

  private static final long serialVersionUID = -7079069657584794688L;
 
  private final Clock clock;
  private final Long sender;
  private final Long receiver;
  private final String message;
  
  Message(Clock clock, Long sender, Long receiver, String message) {
    this.clock = clock;
    this.sender = sender;
    this.receiver = receiver;
    this.message = message;
  }

  public Clock getClock() {
    return clock;
  }

  public String getMessage() {
    return message;
  }

  public Long getSender() {
    return sender;
  }

  public Long getReceiver() {
    return receiver;
  }
  
  @Override
  public String toString() {
    StringBuilder b = new StringBuilder();
    b.append(sender);
    b.append("->");
    b.append(receiver);
    b.append(" @ ");
    b.append(clock);
    b.append(" :: ");
    b.append(message);
    return b.toString();
  }
  
  public static final class MessageBuilder {
    private Clock clock;
    private Long sender;
    private Long receiver;
    private String message;    

    public MessageBuilder() {
    }
    
    public static MessageBuilder create() {
      return new MessageBuilder();
    }
    
    public MessageBuilder setClock(Clock clock) {
      this.clock = clock;
      return this;
    }
    
    public MessageBuilder setMessage(String message) {
      this.message = message;
      return this;
    }
    
    MessageBuilder setSender(Long sender) {
      this.sender = sender;
      return this;
    }
    
    MessageBuilder setReceiver(Long receiver) {
      this.receiver = receiver;
      return this;
    }
    
    Message build() {
      return new Message(clock, sender, receiver, message);
    }
  }
}