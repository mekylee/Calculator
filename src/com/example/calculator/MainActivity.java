package com.example.calculator;

import com.example.calculator.R.id;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener{
    private Button button_sin;
    private Button button_cos;
    private Button button_tan;
    private Button button_pai;
    private Button button_negation;
    private Button button_ln;
    private Button button_log;
    private Button button_e;
    private Button button_index;
    private Button button_delete;
    private Button button_7;
    private Button button_8;
    private Button button_9;
    private Button button_10;
    private Button button_1;
    private Button button_2;
    private Button button_3;
    private Button button_4;
    private Button button_5;
    private Button button_6;
    private Button button_0;
    private Button button_digit;
    private Button button_divide;
    private Button button_multi;
    private Button button_sub;
    private Button button_plus;
    private Button button_equal;
    private Button button_right;
    private Button button_left;
    private EditText editext;
    boolean clear_flag; //清空标识
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		editext=(EditText)findViewById(R.id.edittext1);
		
		button_0 =(Button) findViewById(R.id.button_0);
		button_1=(Button) findViewById(R.id.button_1);
		button_2=(Button) findViewById(R.id.button_2);
		button_3=(Button) findViewById(R.id.button_3);
		button_4=(Button) findViewById(R.id.button_4);
		button_5=(Button) findViewById(R.id.button_5);
		button_6=(Button) findViewById(R.id.button_6);
		button_7=(Button) findViewById(R.id.button_7);
		button_8=(Button) findViewById(R.id.button_8);
		button_9=(Button) findViewById(R.id.button_9);
		button_plus=(Button) findViewById(R.id.button_plus);
		button_sub=(Button) findViewById(R.id.button_sub);
		button_multi=(Button) findViewById(R.id.button_mul);
		button_divide=(Button) findViewById(R.id.button_divi);
		button_equal=(Button) findViewById(R.id.button_equal);
		button_digit=(Button) findViewById(R.id.button_digit);
		button_right=(Button) findViewById(R.id.button_right);
		button_left=(Button) findViewById(R.id.button_left);
		button_negation=(Button) findViewById(R.id.button_negation);
		button_sin=(Button) findViewById(R.id.button_sin);
		button_cos=(Button) findViewById(R.id.button_cos);
		button_tan=(Button) findViewById(R.id.button_tan);
		button_pai=(Button) findViewById(R.id.button_pai);
		button_ln=(Button) findViewById(R.id.button_ln);
		button_log=(Button) findViewById(R.id.button_log);
		button_e=(Button) findViewById(R.id.button_e);
		button_delete=(Button) findViewById(R.id.button_delete);
		
		
		button_0.setOnClickListener(this);
		button_1.setOnClickListener(this);
		button_2.setOnClickListener(this);
		button_3.setOnClickListener(this);
		button_4.setOnClickListener(this);
		button_5.setOnClickListener(this);
		button_7.setOnClickListener(this);
		button_6.setOnClickListener(this);
		button_8.setOnClickListener(this);
		button_9.setOnClickListener(this);
		button_sin.setOnClickListener(this);
		button_cos.setOnClickListener(this);
		button_tan.setOnClickListener(this);
		button_pai.setOnClickListener(this);
		button_negation.setOnClickListener(this);
		button_sub.setOnClickListener(this);
		button_plus.setOnClickListener(this);
		button_multi.setOnClickListener(this);
		button_divide.setOnClickListener(this);
		button_right.setOnClickListener(this);
		button_left.setOnClickListener(this);
		button_digit.setOnClickListener(this);
		button_e.setOnClickListener(this);
		button_delete.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	
	 //实现各个按钮的业务逻辑
	@Override
	public void onClick(View v) {
		//取显示屏的内容
		String str=editext.getText().toString();
		
		switch(v.getId()){
		case R.id.button_0:
		case R.id.button_1:
		case R.id.button_2:
		case R.id.button_3:
		case R.id.button_4:
		case R.id.button_5:
		case R.id.button_6:
		case R.id.button_7:
		case R.id.button_8:
		case R.id.button_9:
		case R.id.button_digit:
			if(clear_flag){
				clear_flag=false;
				str="";
				editext.setText("");
			}
			editext.setText(str+((Button)v).getText());    //点数字按钮或小数点按钮，把按钮的文字添加到输入框中
			break;
		case R.id.button_plus:
		case R.id.button_sub:
		case R.id.button_mul:
		case R.id.button_divi:
			if(clear_flag){
				clear_flag=false;
				str="";
				editext.setText("");
			}
			editext.setText(str+" "+((Button)v).getText()+" ");    //点加减乘除按钮时，把按钮的文字添加到输入框中
			break;
		case R.id.button_delete: 
			if(clear_flag){
				clear_flag=false;
				editext.setText("");
			}else  if(str!=null&&str.equals("")){   //当输入的不为空时，将text置空
				editext.setText(str.substring(0,str.length()-1));  //不需要清空是，删除一个个地删除
			}
		case R.id.button_equal:
		   clear_flag=false;
			getResult();
			break;
			
        default:
				break;
				
		}
		
	}
	    //单独来计算最后的结果
		private void getResult(){
			String exp=editext.getText().toString();  //取出文本框的内容
			if(exp==null||exp.equals("")){
			   return;
			}
			if(exp.contains("")){
				return ;
			}
			if(clear_flag=true){
				clear_flag=false;
				return;
			}
			clear_flag=true;   //当点击“=”时，清空
			String first=exp.substring(0,exp.indexOf(" "));  //找到运算符前面的字符
			String op=exp.substring(exp.indexOf(" ")+1, exp.indexOf(" ")+2);  //找到运算符
			String last=exp.substring(exp.indexOf(" ")+3);  //找到运算符后面的字符
		   double result = 0;
			if(!first.equals("")&&!last.equals("")){
				double d1=Double.parseDouble(first);
				double d2=Double.parseDouble(last);
		
				if(op.equals("+")){
					result=d1+d2;
				}else if(op.equals("-")){
					result=d1-d2;
				}else if(op.equals("×")){
					result=d1*d2;
				}else if(op.equals("÷")){
					if(d2==0){
						result=0;
					}else{
					result=d1/d2;
					}
				}
				if(!first.contains(".")&&!last.contains(".")&&!op.equals("÷")){
					int r=(int)result;
					editext.setText(r+"");
				}else{
					editext.setText(result+"");
				}
			}else if(!first.equals("")&&last.equals("")){
				editext.setText(result+"");
			}else if(first.equals("")&&!last.equals("")){   //运算符的前一个字符为空，后一个字符为非空
				double d2=Double.parseDouble(last);
				if(op.equals("+")){
					result=d2;
				}else if(op.equals("-")){
					result=0;
				}else if(op.equals("×")){
					result=0;
				}else if(op.equals("÷")){
					if(d2==0){
						result=0;
					}else{
					result=0/d2;
					}
		
		         }
            }else {                  //运算符的都为空
            	editext.setText("");
            }
		}
		
}
