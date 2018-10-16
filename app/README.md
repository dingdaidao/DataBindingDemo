#DataBinding的用法
- 是时候抛弃ButterKnife，拥抱DataBinding了。
		1.ButterKnife对组件化方案支持不如DataBinding
		2.ButterKnife只支持View绑定，不支持数据绑定
		3.DataBinding是Google出品。
**就算只看第三条，你也知道选哪个了吧 （手动滑稽）下面还有更多DataBinding的优点**


##启用DataBinding
``` java
android {
	dataBinding {
		enabled true
		}
}
```
***注意：1.如在lib中也使用DataBinding也需要在build文件中添加 ***


##DataBinding 的基本使用
###数据绑定
我们创建一个User类，User有两个属性：name和age。
``` java
public class User {
    private String name;
    private int age;
    public User() {
        this.name = "小花";
        this.age = 18;
    }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}
```
也可以这样写
``` java
public class User {
    public String name;
    public int age;
}
```
然后我们想把User这个对象的两个属性绑定在xml控件中，我们创建一个activity_main.xml文件.因为age属性是int类型，而textView.setText()不允许使用int，所以，我们可以在后面拼上字符标志``` `` ```。
``` xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">
    <data>
        <variable
            name="user"
            type="com.example.ding.databindingdemo.User" />
    </data>
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent">
        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@{user.name}" />
        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@{user.age+`岁`}" />
    </LinearLayout>
</layout>
```
然后我们在Activity中获取xml对应的DataBinding对象，并对其进行赋值
``` java
    private ActivityMainBinding mBinding;//这个对象是根据activity_main.xml命名规则自动生成的，继承自ViewDataBindig了；类
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        mBinding.setVariable(BR.user,new User());
        //或者
        mBinding.setUser(new User());
        mBinding.executePendingBindings();
    }
```
fragment这样绑定``` DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false);```

是不是很简单？这还简单的，看的我头皮发麻，两眼发晕，我不需要绑定什么数据，我就想跟ButterKnife用法一样。好，下面就满足你
###控件绑定
我们在xml中为每个你需要拿到的控件命名ID
```xml
		<Button
            android:id="@+id/main_btn"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content" />
```
那我们应该怎么拿到对应的控件呢？就是我们的```ViewDataBinding```的子类，生成的```ActivityMainBinding```中```Button mBinding.mainBtn```(生成规则遵循Java驼峰命名)，这样我们就可以拿到这个按钮了,之后的事情就不用我说了把。
##方法绑定
```xml
		<Button
            android:id="@+id/main_btn"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:onClick="onClick"/>
```
以前我们可以这样写点击事件，然后在activity中定义```  public void onClick(View view) { }```方法，然后在这里面对点击事件进行处理。现在，我们可以对这个点击事件做任何方法的跳转。传入类，``` mBinding.setVariable(BR.act,this);```然后传入类方法```android:onClick="@{()->类对象.类方法(参数para)}"```
```xml
		<variable
            name="act"
            type="com.example.ding.databindingdemo.MainActivity"/>
        <Button
            android:id="@+id/main_btn"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:onClick="@{()->act.getName(user.name)}"/>
```
我们在activity中定义的方法```  public void getName(String name){ //todo }```。当然，你也可以导入其他类。例如定义```MyHandlers```
``` java
public class MyHandlers {
    public void getName(String name) { ... }
}
```
布局文件就要这样写。
```xml
	<variable
            name="handler"
            type="com.example.ding.databindingdemo.MyHandlers"/>
        <Button
            android:id="@+id/main_btn"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:onClick="@{()->handler.getName(user.name)}"/>
```
注意：要在```Activity```中传入```MyHandlers```实例，不然会报空指针。
##自定义方法Binding adapters
有些控件不能直接传数据就能展示，例如```ImageView```,```RecyclerView```之类。我们可以用```BindingAdapter```注解来自定义方法，xml中使用方式：
```xml
<ImageView
       android:layout_width="wrap_content"
       android:layout_height="wrap_content"
       bind:imageUrl="@{user.pic}" />
```
新建一个java类，类名随意。类方法需为```static```，```@BindingAdapter```注解标记该方法，```value```传```Stirng[]```,xml中使用的atts与里面的命名规则一致。```requireAll```是否必须传。然后在```setImageUrl```方法中获取view和url参数，然后进行展示。当然url也可以替换为src或者bitmap
``` java
public class ImageBindingAdapter {
    @BindingAdapter(value = {"bind:imageUrl"},requireAll = true)
    public static void setImageUrl(ImageView view,String url){
        Glide.with(view.getContext()).load(url).into(view);
    }
   @BindingAdapter(value = {"bind:imageSrc"},requireAll = true)
    public static void setImageSrc(ImageView view,int src){
        view.setImageResource(src);
    }
    @BindingAdapter(value = {"bind:imageBitmap"},requireAll = true)
    public static void setImageBitmap(ImageView view,Bitmap bitmap){
        view.setImageBitmap(bitmap);
    }
}
```
##双向绑定
双向绑定使用```@={}```就可以实现了。没错，就是这么简单。例如，```EditText```中双向绑定了```user.job```这个属性，当```editText```中内容发生更改时，绑定的数据```user.job```也会更新，通过```mBinding.getUser().job```就可以拿到最新的数据了。
##表达式
- 数学运算符： + - / * %
- 字符串拼接： +
- 逻辑运算符： && ||
- 二进制： & | ^
- 一元运算符： +
- 位运算符： >> >>> <<
- 比较： == > < >= <=
- instanceof
- ()<
- 数据类型： character, String, numeric, null
- 类型转换（ClassCast）
- 方法回调（Method calls）
- 数据属性
- 数组：[]
- 三元操作符：？