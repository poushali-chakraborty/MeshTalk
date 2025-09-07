package com.pc.makingup.meshtalk;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    RecyclerView chatRecyclerView;
    EditText messageInput;
    Button sendButton;

    ChatAdapter chatAdapter;
    List<String> messageList = new ArrayList<>();
    List<Boolean> sentFlags = new ArrayList<>(); // true = sent, false = received

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        chatRecyclerView = findViewById(R.id.rvChat);
        messageInput = findViewById(R.id.etMessage);
        sendButton = findViewById(R.id.btnSend);

        // Show neighbor name in ActionBar
        String neighborName = getIntent().getStringExtra("neighbor_name");
        if (neighborName != null) {
            setTitle(neighborName);
        }

        // Setup RecyclerView
        chatAdapter = new ChatAdapter(messageList, sentFlags);
        chatRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        chatRecyclerView.setAdapter(chatAdapter);

        sendButton.setOnClickListener(v -> {
            String message = messageInput.getText().toString().trim();
            if (!message.isEmpty()) {
                // Add sent message
                messageList.add(message);
                sentFlags.add(true); // true = sent by me
                chatAdapter.notifyItemInserted(messageList.size() - 1);
                chatRecyclerView.scrollToPosition(messageList.size() - 1);
                messageInput.setText("");

                // TODO: Send message via BLE here
            }
        });

        // TODO: Add receiving message via BLE
        // Example:
        // messageList.add("Hello from neighbor!");
        // sentFlags.add(false); // false = received
        // chatAdapter.notifyItemInserted(messageList.size() - 1);
        // chatRecyclerView.scrollToPosition(messageList.size() - 1);
    }
}
