# OvalButton  [![](https://jitpack.io/v/aliletter/ovalbutton.svg)](https://jitpack.io/#aliletter/ovalbutton)
OvalButton is an oval IOS-style switch controls, support for custom aspect ratio, color and so on.[中文文档](https://github.com/aliletter/OvalButton/blob/master/README_CHINESE.md)
## Instruction
### Code Sample
```Java        
        ovalButton= (OvalButton) findViewById(R.id.btn_oval);
        //TAG
        ovalButton.setTag(1);
        //Sets the switch status of the component
        ovalButton.setStatus(true);
        ovalButton.setOnButtonListener(new OnOvalButtonListener() {
            @Override
            public void onClick(boolean status, int tag) {
                
            }
        });
```
```Java
    <com.absurd.ovalbutton.OvalButton
        android:layout_width="300dp"
        android:layout_height="200dp"
        app:aspectRatio="2.0"
        app:circleColor="#ffffff"
        app:circleLineColor="#bababa"
        app:pressedColor="#4fd262"
        app:unPressColor="#d3d3d3" />
```

## How to
To get a Git project into your build:
### Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories.[click here for details](https://github.com/aliletter/CarouselBanner/blob/master/root_build.gradle.png)

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
### Step 2. Add the dependency
Add it in your application module build.gradle at the end of dependencies where you want to use.   [click here for details](https://github.com/aliletter/CarouselBanner/blob/master/application_build.gradle.png)
```Java
	dependencies {
	  ...
          compile 'com.github.aliletter:ovalbutton:v1.1.0'
	}
```	
<br><br>
![Text Image](https://github.com/aliletter/OvalButton/blob/master/ovalbutton.gif)
<br><br><br>
## Thank you for your browsing
If you have any questions, please join the QQ group. I will do my best to answer it for you. Welcome to star and fork this repository, alse follow me.
<br>
![Image Text](https://github.com/aliletter/CarouselBanner/blob/master/qq_group.png)

