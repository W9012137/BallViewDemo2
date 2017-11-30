package chencheng.bwie.com.ballviewdemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by dell on 2017/11/30.
 */

public class BallView extends View {
    private Paint paint;
    private Context context;
    private int x=100;
    private int y=100;
    int dou=50;
    public BallView(Context context) {
        super(context);
        this.context=context;
    }

    public BallView(Context context,AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
    }

    public BallView(Context context,AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray arr=context.obtainStyledAttributes(attrs,R.styleable.BallView);
        dou= (int) arr.getDimension(R.styleable.BallView_ball_size,50);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint=new Paint();
        //抗锯齿
        paint.setAntiAlias(true);
        //判断是否是空心
        paint.setStyle(Paint.Style.FILL);
        //设置颜色
        paint.setColor(Color.RED);
        //画圆
        canvas.drawCircle(x,y,dou,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            //判断
            case MotionEvent.ACTION_DOWN:
                x= (int) event.getX();
                y= (int) event.getY();
                Log.i("TAG","按下时："+"x坐标"+x+"y坐标"+y);
                break;
            case MotionEvent.ACTION_MOVE:
                x= (int) event.getX();
                y= (int) event.getY();
                Log.i("TAG","移动时："+"x坐标"+x+"y坐标"+y);
                break;
            case MotionEvent.ACTION_UP:
                x= (int) event.getX();
                y= (int) event.getY();
                Log.i("TAG","抬起时："+"x坐标"+x+"y坐标"+y);
                break;
        }
        //刷新
        postInvalidate();
        return true;
    }
}
