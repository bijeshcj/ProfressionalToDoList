package com.todo.components;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by npcompete on 26/8/13.
 */
public class CompassView extends View {

    private float bearing;


    public CompassView(Context context){
        super(context);
        initCompassView();
    }
    public CompassView(Context context,AttributeSet attrSet){
        super(context,attrSet);
        initCompassView();
    }
    public CompassView(Context context,AttributeSet attrSet,int defaultStyle){
        super(context,attrSet,defaultStyle);
        initCompassView();
    }
    protected void initCompassView(){
        setFocusable(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

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
