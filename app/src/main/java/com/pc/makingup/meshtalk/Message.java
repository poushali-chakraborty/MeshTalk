package com.pc.makingup.meshtalk;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Message {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String sender;
    public String receiver;
    public String text;
    public long timestamp;
}
