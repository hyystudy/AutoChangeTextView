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
public class AutoChangeHeightTextView extends TextView {


        public AutoChangeHeightTextView(Context context) {
            super(context);
        }

        public AutoChangeHeightTextView(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            int measuredHeight = getMeasuredHeight();
            Log.e("xxx", "meas" + measuredHeight);
            float bestTextSize = getBestTextSize(measuredHeight);
            setText(getText());

        }
        public float getTextHeight(Paint paint, String text, float textSize){
            paint.setTextSize(textSize);
            Paint.FontMetrics fontMetrics = paint.getFontMetrics();
            float height = fontMetrics.bottom - fontMetrics.top;
            return height;
        }

        public  float getBestTextSize(int maxWidth){
            String text = (String) this.getText();
            float textSize = this.getTextSize();
            TextPaint paint = this.getPaint();
            float textHeight = getTextHeight(paint, text, textSize);
            while (textHeight>maxWidth){
                textSize -= 1;
                textHeight = getTextHeight(paint, text, textSize);
                Log.e("xxx","textSize"+textSize);
            }
            return textSize;
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
        }

}
