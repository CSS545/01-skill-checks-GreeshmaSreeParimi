package com.example.basic_storage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Drawable drawable;
    private Button loadImageBtn;
    private RelativeLayout layout;
    private SwitchMaterial themeSwitch;
    private TextView themeName;

    private UserSettings settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadImageBtn = (Button) findViewById(R.id.load_image);
        loadImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadImage();
            }
        });

        layout = (RelativeLayout) findViewById(R.id.layout_Id);
        themeSwitch = findViewById(R.id.change_theme);
        themeName = findViewById(R.id.theme_name);

        settings = (UserSettings) getApplication();
        loadSharedPreferences();
        changeLayoutTheme();

    }

    private void changeLayoutTheme() {
       themeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
               if(checked){
                   settings.setCustomTheme(UserSettings.DARK_THEME);
               }else{
                   settings.setCustomTheme(UserSettings.LIGHT_THEME);
               }
               SharedPreferences.Editor editor = getSharedPreferences(UserSettings.PREFERENCES,MODE_PRIVATE).edit();
               editor.putString(UserSettings.CUSTOM_THEME,settings.getCustomTheme());
               editor.apply();
               updateLayout();

           }
       });
    }

    private void updateLayout() {
        final int black = ContextCompat.getColor(this,R.color.black);
        final int white = ContextCompat.getColor(this,R.color.white);
        if(settings.getCustomTheme().equals(UserSettings.DARK_THEME)){
            themeName.setTextColor(white);
            themeName.setText("Change To Light Theme");
            layout.setBackgroundColor(black);
            themeSwitch.setChecked(true);
        }else {
            themeName.setTextColor(black);
            themeName.setText("Change To Dark theme");
            layout.setBackgroundColor(white);
            themeSwitch.setChecked(false);
        }
    }

    private void loadSharedPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences(UserSettings.PREFERENCES,MODE_PRIVATE);
        String theme = sharedPreferences.getString(UserSettings.CUSTOM_THEME,UserSettings.LIGHT_THEME);
        settings.setCustomTheme(theme);
        updateLayout();
    }

    public void loadImage(){
        imageView = findViewById(R.id.imageView1);
        drawable = getResources().getDrawable(R.drawable.mountains);
        imageView.setImageDrawable(drawable);
    }
}