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
	 compile 'com.github.BlackBoxVision:datetimepicker-edittext:v0.0.1'
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
	<version>v0.0.1</version>
</dependency>
```

**SBT**

- Add it in your build.sbt at the end of resolvers:
```sbt
  resolvers += "jitpack" at "https://jitpack.io"
```

- Add the dependency:
```sbt
  libraryDependencies += "com.github.BlackBoxVision" % "datetimepicker-edittext" % "v0.0.1"
```
