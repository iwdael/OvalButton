

package com.absurd.ovelbutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.absurd.ovalbutton.OvalButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    OvalButton btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (OvalButton) findViewById(R.id.btn);
        btn.setStatus(true);
    }

    @Override
    public void onClick(View view) {
        btn.setStatusBySliding(true);
    }
}
