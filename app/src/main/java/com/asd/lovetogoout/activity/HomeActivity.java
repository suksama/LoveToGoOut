package com.asd.lovetogoout.activity;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.asd.lovetogoout.MyApplication;
import com.asd.lovetogoout.R;
import com.asd.lovetogoout.fragment.NoteFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class HomeActivity extends FragmentActivity implements
		OnCheckedChangeListener {
	private Fragment mTab_note;
	private Fragment mTab_plan;
	private Fragment mTab_shoot;
	private Fragment mTab_strategy;
	private Fragment mTab_my;

	private RadioGroup group;
	private RelativeLayout layout_search_background;
	private SearchView button_left;// 标题栏左边的按钮
	private ImageButton button_right;// 标题栏右边的按钮
	private TextView title;
	private String SkipFlag = "firstType";
	private long exitTime;
	private BottomBar bb_bar;
	private RelativeLayout rl_actionbar_home;
	private FragmentManager manager;
	private FragmentTransaction transaction;

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode==KeyEvent.KEYCODE_BACK){
			exit();
			return false;
		}
		return super.onKeyDown(keyCode, event);
	}
	
	private void exit() {
		if(System.currentTimeMillis()-exitTime>5000){
			Toast.makeText(this, "再按一次退出应用", Toast.LENGTH_LONG).show();
			exitTime=System.currentTimeMillis();
		}else{
			MyApplication.getInstance().exit();
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_home);
		initView();
		initClickEvent();
		manager = getSupportFragmentManager();
		transaction = manager.beginTransaction();
		mTab_note = new NoteFragment();
		transaction.add(R.id.fl_content,mTab_note);
		transaction.commit();
		// Intent intent = getIntent();
		// String SkipFlag = intent.getStringExtra("SkipFlag");
		// Log.e("SkipFlag", SkipFlag);

		SharedPreferences pre = getSharedPreferences("Userinfo", MODE_PRIVATE);
		String loginid = pre.getString("loginid", "");
		/*if (loginid.length() < 1) {
			Toast.makeText(getApplicationContext(), "启动时未登录",
					Toast.LENGTH_SHORT).show();
			onCheckedChanged(group, R.id.first);
		} else {
			Toast.makeText(getApplicationContext(), "启动时已登录",
					Toast.LENGTH_SHORT).show();
			onCheckedChanged(group, R.id.first);
		}*/
		// if (loginid.length() > 1) {
		// Intent intent = getIntent();
		// //获取传递过来的值
		// String SkipFlag = intent.getStringExtra("SkipFlag");
		// Log.e("skipflag", SkipFlag);
		//
		// }
	}

	private void initView() {
		//group = (RadioGroup) findViewById(R.id.radiogroup);
		button_left = (SearchView) findViewById(R.id.img_left);
		title = (TextView) findViewById(R.id.id_top);
		button_right = (ImageButton) findViewById(R.id.img_right);
		//layout_search_background=(RelativeLayout) findViewById(R.id.layout_seach_background);
		bb_bar = (BottomBar)findViewById(R.id.bb_bar);
		rl_actionbar_home = (RelativeLayout)findViewById(R.id.rl_actionbar_home);
	}

	private void initClickEvent() {
		bb_bar.setOnTabSelectListener(new OnTabSelectListener() {
			@Override
			public void onTabSelected(int tabId) {
				switch (tabId){
					case R.id.tab_note:
						rl_actionbar_home.setBackgroundResource(R.color.color1);
						hideFragment(transaction);
						if(mTab_note == null){
							mTab_note = new NoteFragment();
							transaction.add(R.id.fl_content,mTab_note);
						}else{
							transaction.show(mTab_note);
						}
						break;
					case R.id.tab_plan:
						rl_actionbar_home.setBackgroundResource(R.color.color2);
						hideFragment(transaction);
						if(mTab_plan == null){

							transaction.add(R.id.fl_content,mTab_plan);
						}else{
							transaction.show(mTab_plan);
						}
						break;
					case R.id.tab_shoot:
						rl_actionbar_home.setBackgroundResource(R.color.color3);
						hideFragment(transaction);
						if(mTab_shoot == null){

							transaction.add(R.id.fl_content,mTab_shoot);
						}else{
							transaction.show(mTab_shoot);
						}
						break;
					case R.id.tab_strategy:
						rl_actionbar_home.setBackgroundResource(R.color.color4);
						hideFragment(transaction);
						if(mTab_strategy == null){

							transaction.add(R.id.fl_content,mTab_strategy);
						}else{
							transaction.show(mTab_strategy);
						}
						break;
					case R.id.tab_my:
						rl_actionbar_home.setBackgroundResource(R.color.color5);
						hideFragment(transaction);
						if(mTab_my == null) {

							transaction.add(R.id.fl_content, mTab_my);
						}else{
							transaction.show(mTab_my);
						}

						break;
				}
			}
		});
//		group.setOnCheckedChangeListener(this);
	}

	/*	@SuppressLint("ResourceAsColor")
        @Oveide
        /*public void onCheckedChanged(RadioGroup group, int checkedId) {
            // TODO Auto-generated method stub
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction transaction = fm.beginTransaction();

            hideFragment(transaction);

            switch (checkedId) {

            case R.id.first: {
                // 第一个为首页
                if (mTab01 == null) {
                    mTab01 = new NoteFragment();
                    transaction.add(R.id.id_content, mTab01);
                } else {
                    transaction.show(mTab01);
                }

                title.setText("首页");// 设置标题

                button_right.setVisibility(View.GONE);// 设置按钮可见
                button_right.setBackgroundResource(R.drawable.search_a);// 设置按钮的图片
                button_left.setVisibility(View.GONE);
    //			button_left.setOnSearchClickListener(new OnClickListener() {
    //
    //				@SuppressLint("ResourceAsColor")
    //				@Override
    //				public void onClick(View v) {
    //					// TODO Auto-generated method stub
    //					title.setVisibility(View.GONE);
    //
    //				}
    //			});
    //			button_left.setOnCloseListener(new OnCloseListener() {
    //
    //				@Override
    //				public boolean onClose() {
    //					// TODO Auto-generated method stub
    //					title.setVisibility(View.VISIBLE);
    //					return false;
    //				}
    //			});
    //			button_left.setOnQueryTextListener(new OnQueryTextListener() {
    //
    //				@Override
    //				public boolean onQueryTextSubmit(String query) {
    //					// TODO Auto-generated method stub
    //					int id = button_left.getContext().getResources().getIdentifier("android:id/search_src_text", null, null);
    //					TextView textView = (TextView) button_left.findViewById(id);
    //					textView.setTextColor(R.color.white);
    //					return false;
    //				}
    //
    //				@Override
    //				public boolean onQueryTextChange(String newText) {
    //					// TODO Auto-generated method stub
    //
    //					return false;
    //				}
    //			});

                break;
            }
            case R.id.second: {
                // 第二个为行程
                if (mTab02 == null) {
                    String url="";
                    *//*RequestQueue rq=Volley.newRequestQueue(this);
				VolleyNetRequest.getrouteID(this, url, rq);
				VolleyNetRequest.isexist="true";
				if (VolleyNetRequest.isexist.equals("true")) {
					mTab02=new TripPlanningFragment2();
				}else{
					mTab02 = new JourneyFragment();
				}*//*
				if (mTab02 == null) {
					//mTab02=new TripPlanningFragment2();
				}else{
					//mTab02 = new JourneyFragment();
				}
				
				transaction.add(R.id.id_content, mTab02);
			} else {
				transaction.show(mTab02);

			}
			title.setText("行程");
			button_left.setVisibility(View.GONE);
			button_right.setVisibility(View.GONE);
			break;
		}
		case R.id.third: {
			// 第三个为攻略
			if (mTab03 == null) {
				//mTab03 = new YlmFragment();
				transaction.add(R.id.id_content, mTab03);
			} else {
				transaction.show(mTab03);
			}
			title.setText("攻略");
			break;
		}
		case R.id.fourth: {
			// 第四个为个人中心
			SharedPreferences pre = getSharedPreferences("Userinfo",
					MODE_PRIVATE);
			String username = pre.getString("nickname", "");
			
			*//*if (username.length() < 1) {
				Toast.makeText(getApplicationContext(), "未登录",
						Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(this, LoginStartActivity.class);
				startActivityForResult(intent, 1);
			} else {
				if (mTab04 == null) {
					mTab04 = new UserCenterFragment();
					transaction.add(R.id.id_content, mTab04);
				} else {
//					transaction.show(mTab04);
					mTab04 = new UserCenterFragment();
					transaction.add(R.id.id_content, mTab04);
				}
			}
			title.setText("个人中心");
			button_left.setVisibility(View.GONE);// 设置按钮不可见
			button_right.setVisibility(View.GONE);
			button_right.setBackgroundResource(R.drawable.setting_a);*//*
			break;
		}
		case R.id.main: {
			SharedPreferences pre = getSharedPreferences("Userinfo",0);
			int u_id = pre.getInt("u_id", 0);
			*//*if (u_id==0) {
				Toast.makeText(HomeActivity.this, "请登录", Toast.LENGTH_LONG).show();
			}else{
				Intent intent = new Intent();
				intent.putExtra("u_Id", u_id);
				intent.setClass(this, CreateNoteActivity.class);
				MyApplication app=MyApplication.getInstance();
				app.addActivity(this);
				startActivity(intent);
			}*//*
		}
		default:
			break;

		}
		transaction.commit();
	}
*/
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		/*int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}*/
		return super.onOptionsItemSelected(item);
	}

	private void hideFragment(FragmentTransaction bFragmentTransaction) {
		if (mTab_note != null) {
			bFragmentTransaction.hide(mTab_note);
		}
		if (mTab_plan != null) {
			bFragmentTransaction.hide(mTab_plan);
		}
		if (mTab_shoot != null) {
			bFragmentTransaction.hide(mTab_shoot);
		}
		if (mTab_strategy != null) {
			bFragmentTransaction.hide(mTab_strategy);
		}
		if (mTab_my != null) {
			bFragmentTransaction.hide(mTab_my);
		}
		transaction.commit();

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		/*if (resultCode == 11) {
			String name = data.getStringExtra("name");
			Log.i("我是老王", "name=" + name);
			onCheckedChanged(group, R.id.fourth);
		}if (resultCode == 22) {
			String name = data.getStringExtra("name");
			Log.i("我是老张", "name=" + name);
			onCheckedChanged(group, R.id.first);
		}if(requestCode==33){
			onCheckedChanged(group, R.id.second);
		}*/
	}
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
	}

	@Override
	public void onCheckedChanged(RadioGroup radioGroup, int i) {

	}
}
