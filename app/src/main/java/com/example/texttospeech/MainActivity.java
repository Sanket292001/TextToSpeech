package com.example.texttospeech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.InputMethodSubtype;
import android.widget.*;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText inputEditText;
    TextView languageTextView;
    Button playBtn;
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//      Initialization
        inputEditText = (EditText) findViewById(R.id.input_text_view);
        playBtn = (Button) findViewById(R.id.play_button);
        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                System.out.println("Initiated..!");
                textToSpeech.speak("Welcome to TextToSpeech Project..!",TextToSpeech.QUEUE_FLUSH,null);
            }

        });


        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inputEditText.length() == 0){
                    textToSpeech.speak("Please type something first..!".toString(),TextToSpeech.QUEUE_FLUSH,null);
                }else{
                    textToSpeech.speak(inputEditText.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);
                }

            }
        });
    }
}