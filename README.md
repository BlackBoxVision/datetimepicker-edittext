# DateTimePicker EditText 
> :calendar: A set of EditTexts with built-in support for Date and TimePicker's using Fragments

[![License: MIT](https://img.shields.io/badge/License-MIT-brightgreen.svg)](https://opensource.org/licenses/MIT) [![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-DateTimePickerEditText-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/5029) [![](https://jitpack.io/v/BlackBoxVision/datetimepicker-edittext.svg)](https://jitpack.io/#BlackBoxVision/datetimepicker-edittext)

## Installation

Actually I don't have this library in **JCenter/Maven Central**, so if you want to use, follow the instructions. 

**Gradle**

- Add it in your root build.gradle at the end of repositories:
```gradle
allprojects {
    repositories {
        ...
        maven { 
	    url "https://jitpack.io" 
        }
    }
}
```

- Add the dependency:
```gradle
dependencies {
    compile 'com.github.BlackBoxVision:datetimepicker-edittext:v0.3.3'
}
```

**Maven**

- Add this line to repositories section in pom.xml:
```xml
<repositories>
    <repository>
	<id>jitpack.io</id>
	<url>https://jitpack.io</url>
    </repository>
</repositories>
```
- Add the dependency:
```xml
<dependency>
    <groupId>com.github.BlackBoxVision</groupId>
    <artifactId>datetimepicker-edittext</artifactId>
    <version>v0.3.3</version>
</dependency>
```

**SBT**

- Add it in your build.sbt at the end of resolvers:
```sbt
  resolvers += "jitpack" at "https://jitpack.io"
```

- Add the dependency:
```sbt
  libraryDependencies += "com.github.BlackBoxVision" % "datetimepicker-edittext" % "v0.3.3"
```

## Sample Usage

In your activity layout xml:

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:id="@+id/activity_main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    android:orientation="vertical"
    android:focusable="false"
    tools:context="io.blackbox_vision.sample.MainActivity">

    <io.blackbox_vision.datetimepickeredittext.view.DatePickerEditText
        android:id="@+id/datePickerEditText"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginBottom="8dp"
        android:hint="@string/select_date"/>

    <io.blackbox_vision.datetimepickeredittext.view.TimePickerEditText
        android:id="@+id/timePickerEditText"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginBottom="8dp"
        android:hint="@string/select_time"/>

    <android.support.design.widget.TextInputLayout
        android:id="@+id/dateTextInputLayout"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginBottom="8dp">

        <io.blackbox_vision.datetimepickeredittext.view.DatePickerInputEditText
            android:id="@+id/datePickerInputEditText"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="@string/select_date"
            app:minDate="01/01/1981"
            app:maxDate="01/01/2050"
            app:dateFormat="yyyy/MM/dd"/>

    </android.support.design.widget.TextInputLayout>

    <android.support.design.widget.TextInputLayout
        android:id="@+id/timeTextInputLayout"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

        <io.blackbox_vision.datetimepickeredittext.view.TimePickerInputEditText
            android:id="@+id/timePickerInputEditText"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="@string/select_time"
            app:timeFormat="HH:mm"
            app:is24HourView="true"/>

    </android.support.design.widget.TextInputLayout>
</LinearLayout>
```

The available tags are the following ones:
- **dateTimePicker:theme**: Reference to a custom theme related to the DatePicker or TimePicker dialog style
- **dateTimePicker:minDate**: String, it must be a string date in the format 'dd/MM/yyyy'
- **dateTimePicker:maxDate**: remains the same as minDate
- **dateTimePicker:dateFormat**: String, it represents the format that the date will be shown in the EditText, the default is 'dd/MM/yyyy'
- **dateTimePicker:timeFormat**: String, it represents the format that the time will be shown in the EditText, the default is 'HH:mm'
- **dateTimePicker:is24HourView**: Boolean, it tells the TimePicker how to show it

And in your Activity class

```java
public final class MainActivity extends AppCompatActivity {

    private DatePickerEditText datePickerEditText;
    private TimePickerEditText timePickerEditText;

    private DatePickerInputEditText datePickerInputEditText;
    private TimePickerInputEditText timePickerInputEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datePickerEditText = (DatePickerEditText) findViewById(R.id.datePickerEditText);
        timePickerEditText = (TimePickerEditText) findViewById(R.id.timePickerEditText);

        datePickerInputEditText = (DatePickerInputEditText) findViewById(R.id.datePickerInputEditText);
        timePickerInputEditText = (TimePickerInputEditText) findViewById(R.id.timePickerInputEditText);
	
        datePickerEditText.setManager(getSupportFragmentManager());
        timePickerEditText.setManager(getSupportFragmentManager());

        datePickerInputEditText.setManager(getSupportFragmentManager());
        timePickerInputEditText.setManager(getSupportFragmentManager());
    }
}
```

## License

Distributed under the **MIT license**. See [LICENSE](https://github.com/BlackBoxVision/datetimepicker-edittext/blob/master/LICENSE.txt) for more information.
