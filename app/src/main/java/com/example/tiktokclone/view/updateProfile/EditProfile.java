package com.example.tiktokclone.view.updateProfile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.tiktokclone.R;

public class EditProfile extends AppCompatActivity {
    private TextView tvHeader, tvHeaderRight, descriptionForField;
    private EditText editFieldProfile;
    private ImageButton btnGoBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        init();
    }
    private void init() {
        Intent prevIntent = getIntent();
        String txtHeader = prevIntent.getStringExtra("header");
        String hint = prevIntent.getStringExtra("text");
        String des = prevIntent.getStringExtra("des");

        tvHeader = findViewById(R.id.tvTitle);
        tvHeaderRight = findViewById(R.id.tvTitleRight);
        editFieldProfile = findViewById(R.id.editFieldProfile);
        descriptionForField = findViewById(R.id.descriptionForField);
        tvHeader.setText(txtHeader);
        editFieldProfile.setText(hint);
        descriptionForField.setText(des);
        tvHeaderRight.setText("save");
        btnGoBack = findViewById(R.id.icBack);
        btnGoBack.setOnClickListener(view -> {
            finish();
        });



    }

    protected void onDestroy() {
        super.onDestroy();
        // clear text focus
    }
}