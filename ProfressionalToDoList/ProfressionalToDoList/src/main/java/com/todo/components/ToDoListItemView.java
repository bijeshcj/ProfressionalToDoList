package com.todo.components;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

import com.profressionaltodolist.R;

/**
 * Created by npcompete on 29/7/13.
 */
public class ToDoListItemView extends TextView {

    private Paint marginPaint;
    private Paint linePaint;
    private int paperColor;
    private float margin;

    public  ToDoListItemView(Context context){
        super(context);
        init();
    }
    public ToDoListItemView(Context context,AttributeSet attrs){
        super(context,attrs);
        init();
    }
    public ToDoListItemView(Context context,AttributeSet attrs,int ds){
        super(context,attrs,ds);
        init();
    }
    private void init(){
        Resources res = getResources();

        marginPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        marginPaint.setColor(res.getColor(R.color.notepad_margin));

        linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        linePaint.setColor(res.getColor(R.color.notepad_lines));

        paperColor = res.getColor(R.color.notepad_paper);
        margin = res.getDimension(R.dimen.notepad_margin);
    }

    @Override
    protected void onDraw(Canvas canvas) {

//      Color the paper
        canvas.drawColor(paperColor);

//      Draw ruled lines
        canvas.drawLine(0,0,getMeasuredHeight(),0,linePaint);
        canvas.drawLine(0,getMeasuredHeight(),getMeasuredWidth(),getMeasuredHeight(),linePaint);

//      Draw margin
        canvas.drawLine(margin,0,margin,getMeasuredHeight(),marginPaint);

        canvas.save();
        canvas.translate(margin,0);

        super.onDraw(canvas);
        canvas.restore();
    }
}
