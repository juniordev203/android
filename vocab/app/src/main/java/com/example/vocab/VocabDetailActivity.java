package com.example.vocab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;

public class VocabDetailActivity extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocab_detail);

        button = findViewById(R.id.backButton);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(VocabDetailActivity.this, MainActivity.class);
            startActivity(intent);
        });
        Intent intent = getIntent();
        Vocab vocab = (Vocab) intent.getSerializableExtra("vocab");

        VocabFragment vocabFragment = new VocabFragment(vocab);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, vocabFragment);
        fragmentTransaction.commit();
    }
}