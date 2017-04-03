package com.example.ankur.ChatarPatar.Model;

import java.util.Date;

/**
 * Created by ankur on 02-04-2017.
 */

public class ChatMessage {
    private String msgText;
    private String sender;
    private long time;

    public ChatMessage() {
    }

    public ChatMessage(String msgText, String sender) {
        this.msgText = msgText;
        this.sender = sender;
        time = new Date().getTime();
    }

    public String getMsgText() {
        return msgText;
    }

    public void setMsgText(String msgText) {
        this.msgText = msgText;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
