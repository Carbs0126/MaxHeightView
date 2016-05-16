package cn.carbs.android.maxheightview.library;

/**
 * Created by Carbs.Wang on 2016/5/12.
 */
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.WindowManager;
import android.widget.FrameLayout;

/**
 * 一个可控制其内部子view最大高度的ViewGroup，可在xml文件中使用。
 *
 * 使用方法：
 * 在xml文件中添加MaxHeightView，并添加app:mhv_HeightRatio="float in[0,1]"或者app:mhv_HeightDimen="dimen"。
 *  mhv_HeightRatio属性指定了view最大高度与整个屏幕的高度的比值，如0.7则是最大高度不超过屏幕高度*o.7，其值赋给mMaxRatio。
 *  mhv_HeightDimen属性指定了view最大高度的精确值，其值赋给mMaxDimen。
 *
 * 解析流程：
 *  1.如果没有设定mhv_HeightDimen和mhv_HeightRatio，则最大高度=DEFAULT_MAX_RATIO_WITHOUT_ARGU * 屏幕高度。
 *  2.如果没有设定mhv_HeightDimen，只设定了mhv_HeightRatio，则最大高度=mhv_HeightRatio*屏幕高度。
 *  3.如果设定了mhv_HeightDimen，而没有设定mhv_HeightRatio，则最大高度=mhv_HeightDimen。
 *  4.如果同时设定了mhv_HeightDimen和mhv_HeightRatio，则最大高度=两者计算值的最小值。
 *
 * A ViewGroup which can limit the max height of its child view, used on android platform
 *
 *  How to use:
 *  you can add MaxHeightView in xml layout file,and add attr app:mhv_HeightRatio="float in[0,1]" or app:mhv_HeightDimen="dimen".
 *  mhv_HeightRatio refers to the max height ratio compare to the device screen height.
 *  mhv_HeightDimen refers to the max height dimension.
 *
 *  Analytical procedure:
 *  1.if neighter mhv_HeightDimen nor mhv_HeightRatio set, the max height will be
 *    DEFAULT_MAX_RATIO_WITHOUT_ARGU * device screen height.
 *  2.if you just set mhv_HeightRatio, then the max height will be mhv_HeightRatio * device screen height.
 *  3.if you just set mhv_HeightDimen, then the max height will be mhv_HeightDimen.
 *  4.if you set both mhv_HeightDimen and mhv_HeightRatio, then the max height will be the minume size.
 * @author Carbs.Wang
 */
public class MaxHeightView extends FrameLayout {

    private static final float DEFAULT_MAX_RATIO_WITHOUT_ARGU = 0.6f;
    private static final float DEFAULT_MAX_RATIO = 0f;
    private static final float DEFAULT_MAX_DIMEN = 0f;

    private float mMaxRatio = DEFAULT_MAX_RATIO;
    private float mMaxDimen = DEFAULT_MAX_DIMEN;
    private float mMaxHeight = 0;

    public MaxHeightView(Context context) {
        super(context);
        init();
    }

    public MaxHeightView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttrs(context, attrs);
        init();
    }

    public MaxHeightView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initAttrs(context, attrs);
        init();
    }

    private void initAttrs(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.MaxHeightView);

        final int count = a.getIndexCount();
        for (int i = 0; i < count; ++i) {
            int attr = a.getIndex(i);
            if(attr == R.styleable.MaxHeightView_mhv_HeightRatio){
                mMaxRatio = a.getFloat(attr, DEFAULT_MAX_RATIO);
            }else if(attr == R.styleable.MaxHeightView_mhv_HeightDimen){
                mMaxDimen = a.getDimension(attr, DEFAULT_MAX_DIMEN);
            }
        }
        a.recycle();
    }

    private void init(){
        if(mMaxDimen <= 0 && mMaxRatio <= 0){
            mMaxHeight = DEFAULT_MAX_RATIO_WITHOUT_ARGU * (float) getScreenHeight(getContext());
        } else if (mMaxDimen <= 0 && mMaxRatio > 0) {
            mMaxHeight = mMaxRatio * (float) getScreenHeight(getContext());
        } else if(mMaxDimen > 0 && mMaxRatio <= 0) {
            mMaxHeight = mMaxDimen;
        } else{
            mMaxHeight = Math.min(mMaxDimen, mMaxRatio * (float) getScreenHeight(getContext()));
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        if (heightMode == MeasureSpec.EXACTLY) {
            heightSize = heightSize <= mMaxHeight ? heightSize
                    : (int) mMaxHeight;
        }

        if (heightMode == MeasureSpec.UNSPECIFIED) {
            heightSize = heightSize <= mMaxHeight ? heightSize
                    : (int) mMaxHeight;
        }
        if (heightMode == MeasureSpec.AT_MOST) {
            heightSize = heightSize <= mMaxHeight ? heightSize
                    : (int) mMaxHeight;
        }
        int maxHeightMeasureSpec = MeasureSpec.makeMeasureSpec(heightSize,
                heightMode);
        super.onMeasure(widthMeasureSpec, maxHeightMeasureSpec);
    }

    /**
     * 获取屏幕高度
     *
     * @param context
     */
    private int getScreenHeight(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        return wm.getDefaultDisplay().getHeight();
    }

}