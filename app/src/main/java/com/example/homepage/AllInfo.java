package com.example.homepage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class AllInfo extends AppCompatActivity {

    private TextView nam1;
    private TextView val1;
    private TextView cap;
    private TextView cap_val;
    private TextView reg;
    private TextView reg_val;
    private TextView subreg;
    private TextView subreg_val;
    private TextView pop;
    private TextView pop_val;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_info);
        nam1 = findViewById(R.id.name1);
        val1 = findViewById(R.id.name1_val);
        cap = findViewById(R.id.cap);
        cap_val = findViewById(R.id.cap_val);
        reg = findViewById(R.id.reg);
        reg_val = findViewById(R.id.reg_val);
        subreg = findViewById(R.id.subreg);
        subreg_val = findViewById(R.id.subreg_val);
        pop = findViewById(R.id.pop);
        pop_val = findViewById(R.id.pop_val);
        nam1.setText("Country");
        final String name_val = getIntent().getStringExtra("nam");
        val1.setText(name_val);
        final String cap = getIntent().getStringExtra("cap");
        cap_val.setText(cap);
        final String reg = getIntent().getStringExtra("reg");
        reg_val.setText(reg);
        final String subreg = getIntent().getStringExtra("subreg");
        subreg_val.setText(subreg);
        final String pop = getIntent().getStringExtra("pop1");
        pop_val.setText(pop);
    }
}