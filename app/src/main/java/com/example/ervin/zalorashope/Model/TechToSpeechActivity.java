package com.example.ervin.zalorashope.Model;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ervin.zalorashope.R;

import java.util.Locale;

public class TechToSpeechActivity extends AppCompatActivity {
    TextToSpeech toSpeech;
    int result;
    EditText editText;
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tech_to_speech);
        editText = (EditText) findViewById(R.id.editText);
        toSpeech = new TextToSpeech(TechToSpeechActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS){
                    result = toSpeech.setLanguage(Locale.ENGLISH);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Feature not supported in your device", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void TTS(View view) {
        switch (view.getId())
            {
                case R.id.buttonSpeech:
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED)
            {
                Toast.makeText(getApplicationContext(), "Feature not supported in your device", Toast.LENGTH_SHORT).show();
            }
            else
            {
                text = editText.getText().toString();
                toSpeech.speak(text,TextToSpeech.QUEUE_FLUSH,null);
            }
            break;
            case R.id.buttonStop:
                if (toSpeech!=null)
                {
                    toSpeech.stop();
                }
            break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (toSpeech!=null)
        {
            toSpeech.stop();
            toSpeech.shutdown();
        }
    }
}
