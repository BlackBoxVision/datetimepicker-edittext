#DateTimePicker EditText [![](https://jitpack.io/v/BlackBoxVision/datetimepicker-edittext.svg)](https://jitpack.io/#BlackBoxVision/datetimepicker-edittext)
:calendar: A set of EditTexts with built-in support for Date and TimePicker's using Fragments

##Installation

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
	 compile 'com.github.BlackBoxVision:datetimepicker-edittext:v0.1.0'
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
	<version>v0.1.0</version>
</dependency>
```

**SBT**

- Add it in your build.sbt at the end of resolvers:
```sbt
  resolvers += "jitpack" at "https://jitpack.io"
```

- Add the dependency:
```sbt
  libraryDependencies += "com.github.BlackBoxVision" % "datetimepicker-edittext" % "v0.1.0"
```

##Sample Usage

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
            app:timeFormat="HH:mm"/>

    </android.support.design.widget.TextInputLayout>

</LinearLayout>
```

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
##License

Distributed under the MIT license. See [LICENSE](https://github.com/BlackBoxVision/datetimepicker-edittext/blob/master/LICENSE.txt) for more information.
