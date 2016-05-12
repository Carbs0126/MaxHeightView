# MaxHeightView
## Abstract
A ViewGroup which can limit the max height of its child view, used on android platform.
MaxHeightView is a subClass of FrameLayout, you can use this view in your xml layout file to limit the child view's max height.

## Screenshot
<center>
![you can check the MaxHeightView_screenshot.png](https://github.com/Carbs0126/MaxHeightView/blob/master/MaxHeightView_screenshot.png)
</center>
## Example
in xml layout:
```
<cn.carbs.android.maxheightview.library.MaxHeightView
  android:id="@+id/maxview"
  android:layout_width="match_parent"
  android:layout_height="wrap_content"
  app:mhv_HeightRatio="0.7">

  <LinearLayout
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="vertical">
    ......
  </LinearLayout>
</cn.carbs.android.maxheightview.library.MaxHeightView>
```

## TODO
Not support generating a MaxHeightView by java code, but you can modify the constructor with only one argument by adding maxheight ratio or exact pixel

enjoy.


