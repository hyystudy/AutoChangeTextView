package com.hyy.jccy.autochangetextview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by hyy on 2016/4/6.
 */
public class AutoChangeWidthTextView extends TextView {


        public AutoChangeWidthTextView(Context context) {
            super(context);
        }

        public AutoChangeWidthTextView(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            int measuredWidth = getMeasuredWidth();
            Log.e("xxx", "meas" + measuredWidth);
            float bestTextSize = getBestTextSize(measuredWidth);
            setText(getText());

        }
        public int getTextWidth(Paint paint,String text,float textSize){
            Rect rect = new Rect();
            paint.setTextSize(textSize);
            paint.getTextBounds(text, 0, text.length(), rect);
            int textwidth = rect.right - rect.left;
            Log.e("xxx","text"+rect.width());
            return rect.width();
        }

        public  float getBestTextSize(int maxWidth){
            String text = (String) this.getText();
            float textSize = this.getTextSize();
            TextPaint paint = this.getPaint();
            int textWidth = getTextWidth(paint, text, textSize);
            while (textWidth>maxWidth-6){
                textSize -= 1;
                textWidth =getTextWidth(paint,text,textSize);
                Log.e("xxx","textSize"+textSize);
            }

            return textSize;
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
        }

}
