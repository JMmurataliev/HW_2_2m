package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    boolean isFingerImage = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        CardView cardView = findViewById(R.id.card_view);
        TextView textView = findViewById(R.id.text_view);
        ImageView imageView = findViewById(R.id.image_view);


        findViewById(R.id.button_one).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cardView.getAlpha() == 1){
                    cardView.animate().alpha(0).setDuration(1000);
                    textView.setText("Old World");
                }else {
                    cardView.animate().alpha(1F);
                    textView.setText("New World");

                    if (isFingerImage){
                        imageView.setImageResource(R.drawable.ic_mountain);
                        isFingerImage = false;
                    }else {
                        imageView.setImageResource(R.drawable.ic_fingers);
                    }
                    isFingerImage = true;
                }


            }
        });
        LinearLayout container = findViewById(R.id.container);

        findViewById(R.id.button_big).setOnClickListener(view -> {

            if(container.getVisibility() == View.VISIBLE){
             container.setVisibility(View.GONE);
            }

            container.setVisibility(View.GONE);


        });

        EditText editText = findViewById(R.id.edit_text);


        findViewById(R.id.btn_oval).setOnClickListener(view -> {
            Toast.makeText(MainActivity.this, editText.getText(), Toast.LENGTH_SHORT).show();

        });



    }
}