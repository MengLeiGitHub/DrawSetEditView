# DrawSetEditView
在xml文件中，动态的设置TextView  EditView  Button等的  CompoundDrawables的 大小，
，方便调试
 
 
先来看下效果
![mahua](drawset.gif)
 
 
##接入方法

####在你项目的 build.gradle 文件里添加如下配置 
<pre><code>

dependencies {
  
    compile 'com.ml.drawseteditview:draweditview:1.0.1'
}

 </code></pre>


##使用方法：
```xml
   <!--drawableTop-->
  <com.ml.draweditview.DrawSetButton
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:drawableTop="@mipmap/ic_launcher"
        app:topHeight="10dp"
        app:topWidth="10dp"
       />


   <!--drawableLeft-->
 <com.ml.draweditview.DrawSetTextView
        android:layout_width="wrap_content"
        android:drawableLeft="@mipmap/ic_launcher"
        app:leftWidth="35dp"
        app:leftHeight="35dp"
        android:layout_height="wrap_content"
        android:text="123123123213132"/>
        
      <!--drawableRight-->
 <com.ml.draweditview.DrawSetRadioButton
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="1231"
        android:drawableRight="@mipmap/ic_launcher"
        app:rightHeight="10dp"
        app:rightWidth="20dp"/>
        
      <!--drawableBottom-->

  <com.ml.draweditview.DrawSetRadioButton
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="1231"
        android:drawableRight="@mipmap/ic_launcher"
        app:rightHeight="10dp"
        app:rightWidth="20dp"/>
        

```
####框架只提供了一下类
DrawSetButton
DrawSetEditText
DrawSetRadioButton
DrawSetTextView


####如果要在自己自定义的控件里面也想拥有该功能的话直接在控件里面加入下面的代码
（ps：但是只能在支持drawableTop,drawableBottom,drawableRight,drawableLeft等的控件中）

 
 ```java
 
    public DrawSetRadioButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		new  DrawSetUtils(this).reastView(context,attrs);
	}


	public DrawSetRadioButton(Context context, AttributeSet attrs, int checkedColor) {
		super(context, attrs,checkedColor);
		// TODO Auto-generated constructor stub
		new  DrawSetUtils(this).reastView(context,attrs);
	}
 
 ```
<font color=red size=5 face=“黑体”>注意：只有build之后，才能生效</font>
 
 
 



