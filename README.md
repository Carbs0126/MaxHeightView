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
  android:layout_width="match_parent"
  android:layout_height="wrap_content"
  app:mhv_HeightRatio="0.7">

  <ScrollView
    android:layout_width="match_parent"
    android:layout_height="wrap_content">

    <LinearLayout
      android:layout_width="match_parent"
      android:layout_height="wrap_content"
      android:orientation="vertical">
        // add your content view here
    </LinearLayout>

  </ScrollView>

</cn.carbs.android.maxheightview.library.MaxHeightView>
```
## Add to project
```
compile 'cn.carbs.android:MaxHeightView:1.0.0'
```
## TODO
Not support generating a MaxHeightView by java code, but you can modify the constructor with only one argument by adding maxheight ratio or exact pixel

enjoy.

## License

    Copyright 2016 Carbs.Wang (MaxHeightView)

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.



