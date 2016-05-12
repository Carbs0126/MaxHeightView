package cn.carbs.android.maxheightview.example.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import cn.carbs.android.maxheightview.R;

public class ActivityMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button)this.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                DialogMaxHeight dialogMaxHeight = new DialogMaxHeight(ActivityMain.this);
                dialogMaxHeight.show();
            }
        });
    }
}
