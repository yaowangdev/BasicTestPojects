package com.appdev.basic;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class SoftInputModeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_softinput_activity1);
//        final View et = findViewById(R.id.et_editText);
//        final InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//        getWindow().getDecorView().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                if(imm!=null){
//                    et.requestFocus();
//                    imm.showSoftInput(et,0);
//                }
//            }
//        },100);
    }

    public void ToSoft2(View view) {
        Intent intent = new Intent(this, SoftInputModeActivity2.class);
        startActivity(intent);
    }
}
