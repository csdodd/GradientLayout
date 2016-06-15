GradientLayout
===============
A library which extends Android layouts to allow for the easy configuring of gradient backgrounds.

<img src="https://raw.githubusercontent.com/csdodd/GradientLayout/master/demo.gif" width="350">

Gradle
------
```groovy
dependencies {
    compile 'net.colindodd:gradientlayout:1.0'
}
```

Usage
-----
```xml
<net.colindodd.gradientlayout.GradientRelativeLayout
    xmlns:gl="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    gl:start_color="@android:color/holo_purple"
    gl:end_color="#AAFF0000"
    gl:orientation="TOP_BOTTOM">

</net.colindodd.gradientlayout.GradientRelativeLayout>

```

```java
    final GradientLinearLayout layout = (GradientLinearLayout) view.findViewById(R.id.root);
    layout.setGradientBackgroundConfig(Color.parseColor("#7B1FA2"), Color.parseColor("#009688"), GradientDrawable.Orientation.BL_TR);

```

Orientation is the same as [GradientDrawable.Orientation](https://developer.android.com/reference/android/graphics/drawable/GradientDrawable.Orientation.html)

The following classes are included:
 - GradientAbsoluteLayout
 - GradientFrameLayout
 - GradientGridLayout
 - GradientLinearLayout
 - GradientRelativeLayout
 - GradientTableLayout

License
-------

    Copyright 2016 Colin Dodd

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
