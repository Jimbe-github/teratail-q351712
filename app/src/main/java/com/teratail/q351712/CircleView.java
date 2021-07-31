package com.teratail.q351712;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.View;

public class CircleView extends View {
  private Paint paint;

  public CircleView(Context context, AttributeSet attrs) {
    super(context, attrs);
    paint = new Paint();
  }

  public CircleView(Context context) {
    super(context);
    paint = new Paint();
  }

  public void setColor(int color){
    paint.setColor(0xff000000 | color);
    invalidate();
  }

  @Override
  protected void onDraw(Canvas canvas) {
    paint.setAntiAlias(true);
    canvas.drawCircle(canvas.getHeight() / 2, canvas.getHeight() / 2, (canvas.getWidth() / 2) - 2, paint);
  }
}