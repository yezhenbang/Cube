package b.bon.mycube.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

import b.bon.mycube.R;

public class BackActivity extends Activity  {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        final Button back = (Button) findViewById(R.id.back);
        final  ImageButton history=( ImageButton) findViewById(R.id.history);
        final  ImageButton three=( ImageButton)findViewById(R.id.three);
        final  ImageButton high=( ImageButton)findViewById(R.id.high);
        final  ImageButton game=( ImageButton)findViewById(R.id.game) ;


        back.setOnClickListener(new OnClickListener(){
        @Override
        public void onClick (View v){
            Intent intent = new Intent(BackActivity.this, MainActivity.class);
            startActivity(intent);
            BackActivity.this.finish();
        }
        });

    }

}