package com.teratail.q351712;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    TextView output0 = findViewById(R.id.output0);
    TextView output1 = findViewById(R.id.output1);
    TextView output2 = findViewById(R.id.output2);
    CircleView circle0 = findViewById(R.id.circle0);
    CircleView circle1 = findViewById(R.id.circle1);
    CircleView circle2 = findViewById(R.id.circle2);

    NumberPicker redinput = findViewById(R.id.redinput);
    NumberPicker greeninput = findViewById(R.id.greeninput);
    NumberPicker blueinput = findViewById(R.id.blueinput);

    NumberPicker.OnValueChangeListener onValueChangeListener = (numberPicker, i, i1) -> {
      try {
        int rgb = Color.rgb(redinput.getValue(), greeninput.getValue(), blueinput.getValue());
        output0.setText(String.format("%06X", rgb));
        circle0.setColor(rgb);

        NamedColor nc1 = NamedColor.getApproximateColor(rgb, NamedColor.MSEComparator);
        output1.setText(nc1 == null ? "(不明)" : nc1.getName());
        circle1.setColor(nc1.getColor().toArgb());

        NamedColor nc2 = NamedColor.getApproximateColor(rgb, NamedColor.TRComparator);
        output2.setText(nc2 == null ? "(不明)" : nc2.getName());
        circle2.setColor(nc2.getColor().toArgb());

      } catch(NumberFormatException e) {
        output0.setText("(エラー)");
      }
    };

    redinput.setMinValue(0);
    redinput.setMaxValue(255);
    redinput.setFormatter(i -> String.format("%02X", i));
    redinput.setOnValueChangedListener(onValueChangeListener);

    greeninput.setMinValue(0);
    greeninput.setMaxValue(255);
    greeninput.setFormatter(i -> String.format("%02X", i));
    greeninput.setOnValueChangedListener(onValueChangeListener);

    blueinput.setMinValue(0);
    blueinput.setMaxValue(255);
    blueinput.setFormatter(i -> String.format("%02X", i));
    blueinput.setOnValueChangedListener(onValueChangeListener);

    onValueChangeListener.onValueChange(null, 0, 0);
  }
}