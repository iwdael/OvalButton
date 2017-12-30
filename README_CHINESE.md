# OvalButton  [![](https://jitpack.io/v/aliletter/ovalbutton.svg)](https://jitpack.io/#aliletter/ovalbutton)
OvalButton是一个椭圆形的IOS风格的开关控件，支持自定义宽高比例，色彩等。
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
    <com.absurd.ovalbutton.OvalButton
        android:layout_width="300dp"
        android:layout_height="200dp"
        app:aspectRatio="2.0"
        app:circleColor="#ffffff"
        app:circleLineColor="#bababa"
        app:pressedColor="#4fd262"
        app:unPressColor="#d3d3d3" />
```
 




## 如何配置
将本仓库引入你的项目:
### Step 1. 添加JitPack仓库到Build文件
合并以下代码到项目根目录下的build.gradle文件的repositories尾。[点击查看详情](https://github.com/aliletter/CarouselBanner/blob/master/root_build.gradle.png)

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
### Step 2. 添加依赖
合并以下代码到需要使用的application Module的dependencies尾。[点击查看详情](https://github.com/aliletter/CarouselBanner/blob/master/application_build.gradle.png)
```Java
	dependencies {
	  ...
          compile 'com.github.aliletter:ovalbutton:v1.1.0'
	}
```	
<br><br>
![Text Image](https://github.com/aliletter/OvalButton/blob/master/ovalbutton.gif)
<br><br><br>
## 感谢浏览
如果你有任何疑问，请加入QQ群，我将竭诚为你解答。欢迎Star和Fork本仓库，当然也欢迎你关注我。
<br>
![Image Text](https://github.com/aliletter/CarouselBanner/blob/master/qq_group.png)
