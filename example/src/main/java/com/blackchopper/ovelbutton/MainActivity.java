

package com.blackchopper.ovelbutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.blackchopper.ovalbutton.OvalButton;

/**
 * author  : Black Chopper
 * e-mail  : 4884280@qq.com
 * github  : http://github.com/BlackChopper
 * project : OvalButton
 */
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
