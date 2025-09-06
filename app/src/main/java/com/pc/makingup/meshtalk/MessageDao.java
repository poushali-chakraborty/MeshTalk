package com.pc.makingup.meshtalk;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MessageDao {
    @Insert
    void insert(Message message);

    @Query("SELECT * FROM Message WHERE (sender=:user OR receiver=:user) ORDER BY timestamp")
    List<Message> getMessages(String user);
}