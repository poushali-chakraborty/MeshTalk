package com.pc.makingup.meshtalk;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    EditText nicknameInput;
    Button saveNickButton;
    RecyclerView neighborRecyclerView;
    NeighborAdapter neighborAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nicknameInput = findViewById(R.id.etNickname);
        saveNickButton = findViewById(R.id.btnSaveNick);
        neighborRecyclerView = findViewById(R.id.rvNeighbors);

        // Load saved nickname
        nicknameInput.setText(Prefs.getNickname(this));

        // Setup RecyclerView
        neighborRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        neighborAdapter = new NeighborAdapter(this); // uses default Alice, Bob, Charlie
        neighborRecyclerView.setAdapter(neighborAdapter);

        saveNickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nickname = nicknameInput.getText().toString().trim();
                if (nickname.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter a nickname", Toast.LENGTH_SHORT).show();
                    return;
                }
                Prefs.setNickname(MainActivity.this, nickname);
                Toast.makeText(MainActivity.this, "Nickname saved!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
