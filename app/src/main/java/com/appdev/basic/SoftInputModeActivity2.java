package com.appdev.basic;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class SoftInputModeActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_softinput_activity2);

    }

    public void ToSoft3(View view) {
        Intent intent = new Intent(this, SoftInputModeActivity3.class);
        startActivity(intent);
    }
}
