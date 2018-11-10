# OvalButton
[![](https://img.shields.io/badge/platform-android-orange.svg)](https://github.com/hacknife) [![](https://img.shields.io/badge/language-java-yellow.svg)](https://github.com/hacknife) [![](https://img.shields.io/badge/Jcenter-1.1.3-brightgreen.svg)](https://github.com/hacknife) [![](https://img.shields.io/badge/build-passing-brightgreen.svg)](https://github.com/hacknife) [![](https://img.shields.io/badge/license-apache--2.0-green.svg)](https://github.com/hacknife) [![](https://img.shields.io/badge/api-19+-green.svg)](https://github.com/hacknife)<br/><br/>
OvalButton是一个椭圆形的IOS风格的开关控件，支持自定义宽高比例，色彩等。[English](https://github.com/hacknife/OvalButton/blob/master/README_ENGLISH.md)
<br><br>![Text Image](https://github.com/hacknife/OvalButton/blob/master/ovalbutton.gif)
<br><br>
## 使用说明
### 代码示例
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
    <com.hacknife.ovalbutton.OvalButton
        android:layout_width="300dp"
        android:layout_height="200dp"
        app:aspectRatio="2.0"
        app:circleColor="#ffffff"
        app:circleLineColor="#bababa"
        app:pressedColor="#4fd262"
        app:unPressColor="#d3d3d3" />
```
 




## 快速引入项目

合并以下代码到需要使用的application Module的dependencies尾。
```Java
	dependencies {
	  ...
          compile 'com.hacknife:ovalbutton:1.1.3'
	}
```	


<br><br><br>
## 感谢浏览
如果你有任何疑问，请加入QQ群，我将竭诚为你解答。欢迎Star和Fork本仓库，当然也欢迎你关注我。
<br>
![Image Text](https://github.com/hacknife/CarouselBanner/blob/master/qq_group.png)
