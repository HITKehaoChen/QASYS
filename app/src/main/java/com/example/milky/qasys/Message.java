package com.example.milky.qasys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Message {
    public static final int Answer = 0;
    public static final int Question = 1;
    private  String chatContent;
    private  int chatObj;
    public Message(String chatInfo,int chatObj){
        this.chatContent = chatContent;
        this.chatObj = chatObj;
    }
    public String getChatContent(){
        return chatContent;
    }
    public int getChatObj(){
        return chatObj;
    }
}
