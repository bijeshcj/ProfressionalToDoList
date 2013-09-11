package com.todo.components;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.profressionaltodolist.R;

/**
 * Created by Bijesh on 11/9/13.
 */
public class LineGraphView extends View {
    private static final String TAG = LineGraphView.class.getCanonicalName();

    private Paint rectanglePaint;
    private float bearing;

    public LineGraphView(Context context){
        super(context);
        initLineGraphView();
    }

    public LineGraphView(Context context,AttributeSet arSet){
        super(context,arSet);
        initLineGraphView();
    }

    public LineGraphView(Context context,AttributeSet arSet,int defaultStyle){
        super(context,arSet,defaultStyle);
        initLineGraphView();
    }

    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);

        int px = getMeasuredWidth() / 2;
        int py = getMeasuredHeight() / 2;

        Log.d(TAG, "$$$ px " + px + " py " + py);

        canvas.drawRect(50,50,90,90,rectanglePaint);
//        canvas.drawText("Test",50,60,rectanglePaint);
        canvas.save();

    }

    private void initLineGraphView(){
         setFocusable(true);

         Resources res = getResources();

         rectanglePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
         rectanglePaint.setColor(res.getColor(R.color.background_color));
         rectanglePaint.setStrokeWidth(1);
         rectanglePaint.setStyle(Paint.Style.FILL_AND_STROKE);


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int measureWidth = measure(widthMeasureSpec);
        int measureHeight = measure(heightMeasureSpec);

        int d = StrictMath.min(measureWidth,measureHeight);
        setMeasuredDimension(d,d);
    }
    private int measure(int measureSpec){
        int result = 0;

        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        if(specMode == MeasureSpec.UNSPECIFIED){
            result = 200;
        }else{
            result = specSize;
        }

        return result;
    }

    public float getBearing() {
        return bearing;
    }

    public void setBearing(float bearing) {
        this.bearing = bearing;
    }
}
