# CircleNumberProgressBar
一个可以显示数字进度的圆形进度条

## 效果图

![](https://github.com/AlarmZeng/CircleNumberProgressBar/blob/master/screenshots/screenshots2.gif)
![](https://github.com/AlarmZeng/CircleNumberProgressBar/blob/master/screenshots/screenshots1.png)

## 使用

### 设置布局文件和默认样式

* 直接在布局文件中声明

		<com.zht.circlenumberprogressbar.widget.CircleNumberProgressBar
	        android:id="@+id/cnpb_progress_second"
	        android:layout_width="wrap_content"
	        android:layout_height="wrap_content"
	        app:cnpb_circle_radius="80dp"
	        app:cnpb_reach_color="@color/colorAccent"
	        app:cnpb_text_color="@color/colorAccent"
	        app:cnpb_text_size="20sp" />

* 在styles文件中设置

		<style name="AppTheme" parent="Theme.AppCompat.Light.DarkActionBar">
	        <!-- Customize your theme here. -->
	        ...
	        <item name="styleCircleNumberProgressBar">@style/CircleNumberProgressBarTheme</item>
	    </style>
	
	    <style name="CircleNumberProgressBarTheme" parent="CircleNumberProgressBar.Style">
	        <item name="cnpb_text_color">#FF303F9F</item>
			...
	    </style>

### 属性

		<declare-styleable name="CircleNumberProgressBar">
        
	        <!-- 圆的半径 -->
	        <attr name="cnpb_circle_radius" format="dimension"/>
	
	        <!-- 进度条的宽度 -->
	        <attr name="cnpb_bar_width" format="dimension" />
	        
	        <!-- 达到的进度颜色 -->
	        <attr name="cnpb_reach_color" format="color" />
	        
	        <!-- 未达到的进度颜色 -->
	        <attr name="cnpb_unreach_color" format="color" />
	        
	        <!-- 文字大小 -->
	        <attr name="cnpb_text_size" format="dimension" />
	
	        <!-- 文字颜色 -->
	        <attr name="cnpb_text_color" format="color" />
	
	        <!-- 文字是否显示 -->
	        <attr name="cnpb_text_visibility" format="enum">
	            <enum name="invisible" value="0"/>
	            <enum name="visible" value="1"/>
	        </attr>
	
	        <!-- 单位 -->
	        <attr name="cnpb_unit" format="string"/>
	
	        <!-- 单位是否显示 -->
	        <attr name="cnpb_unit_visibility" format="enum">
	            <enum name="invisible" value="0"/>
	            <enum name="visible" value="1"/>
	        </attr>
	
	    </declare-styleable>

### Activity使用

		public class MainActivity extends AppCompatActivity {

	    private CircleNumberProgressBar progressBarFirst;
	
	    private CircleNumberProgressBar progressBarSecond;
	
	    private static final int PROGRESS_UPDATE = 1;
	
	    private Handler handler = new Handler() {
	
	        @Override
	        public void handleMessage(Message msg) {
	
	            int progress = progressBarFirst.getProgress();
	            progress += 1;
	
	            if (progress >= 100) {
	                handler.removeMessages(PROGRESS_UPDATE);
	            }
	
	            progressBarFirst.setProgress(progress);
	            handler.sendEmptyMessageDelayed(PROGRESS_UPDATE, 500);
	        }
	    };
	
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_main);
	        progressBarFirst = (CircleNumberProgressBar) findViewById(R.id.cnpb_progress_first);
	        progressBarSecond = (CircleNumberProgressBar) findViewById(R.id.cnpb_progress_second);
	
	        handler.sendEmptyMessage(PROGRESS_UPDATE);
	        progressBarSecond.setProgress(80);
	//        progressBarFirst.setProgress(80);
	    }
	}

### 详细文章

对**CiecleNumberProgressBar**的详细介绍可以查看文章[CircleNumberProgressBar]()
