package com.pc.makingup.meshtalk;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    EditText nicknameInput;
    Button saveNickButton;
    RecyclerView neighborRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nicknameInput = findViewById(R.id.etNickname);
        saveNickButton = findViewById(R.id.btnSaveNick);
        neighborRecyclerView = findViewById(R.id.rvNeighbors);

        // Load saved nickname
        nicknameInput.setText(Prefs.getNickname(this));

        saveNickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nickname = nicknameInput.getText().toString();
                Prefs.setNickname(MainActivity.this, nickname);
            }
        });
    }
}