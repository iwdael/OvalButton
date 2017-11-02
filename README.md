# OvalButton  [![](https://jitpack.io/v/aliletter/ovalbutton.svg)](https://jitpack.io/#aliletter/ovalbutton)
OvalButton is an oval switch component that mimics the IOS operating system off the switch components and is equipped with similar animation effects.
# How to
To get a Git project into your build:
## Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
## Step 2. Add the dependency

	dependencies {
          compile 'com.github.aliletter:ovalbutton:v1.0.5'
          
	}
 
# Instruction
## Layout 
Add this component to the layout you need.
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
## Activity
Get a reference to the component in the activity, and set the TAG and listener.
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
![](https://github.com/mr-absurd/OvalButton/blob/master/Screenshots/Screenshot_2017-10-02-14-57-28.png)
![](https://github.com/mr-absurd/OvalButton/blob/master/Screenshots/Screenshot_2017-10-02-14-57-32.png)
