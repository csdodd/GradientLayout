GradientLayout
===============
[![Android
Arsenal](https://img.shields.io/badge/Android%20Arsenal-GradientLayout-green.svg?style=true)](https://android-arsenal.com/details/1/3732)

A library which extends Android layouts to allow for the easy configuring of gradient backgrounds.

<img src="https://raw.githubusercontent.com/csdodd/GradientLayout/master/demo.gif" width="350">

Gradle
------
```groovy
dependencies {
    compile 'net.colindodd:gradientlayout:1.1'
}
```

Usage
-----
```xml
<net.colindodd.gradientlayout.GradientRelativeLayout
    xmlns:gl="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    gl:start_color="@color/purple"
    gl:end_color="@color/blue"
    gl:orientation="TOP_BOTTOM">

</net.colindodd.gradientlayout.GradientRelativeLayout>

```

```java
    final GradientLinearLayout layout = (GradientLinearLayout) view.findViewById(R.id.root);
    layout.setStartColor(Color.rgb(255,87,34))
          .setEndColor(Color.rgb(255,193,7))
          .setOrientation(GradientDrawable.Orientation.TR_BL);

```

Or just provide a single color and the layout will generate a gradient for you:
```java
    final GradientLinearLayout layout = (GradientLinearLayout) view.findViewById(R.id.root);
    layout.setEndColor(Color.rgb(123,31,162));

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
