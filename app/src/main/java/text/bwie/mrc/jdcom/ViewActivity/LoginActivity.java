package text.bwie.mrc.jdcom.ViewActivity;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import text.bwie.mrc.jdcom.Api.Api;
import text.bwie.mrc.jdcom.Bean.LoginBean.LoginBean;
import text.bwie.mrc.jdcom.MainActivity;
import text.bwie.mrc.jdcom.Model.FirstEvent;
import text.bwie.mrc.jdcom.Net.LoginHttpclient;
import text.bwie.mrc.jdcom.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 用户名/邮箱/手机号
     */
    private EditText mLoginUsername;
    /**
     * 请输入密码
     */
    private EditText mLoginUserpassword;
    /**
     * 登录
     */
    private Button mLoginButtonup;
    /**
     * 手机快速注册
     */
    private TextView mLoginRegister;
    /**
     * 忘记密码
     */
    private TextView mLoginPassworddown;
    private ImageView mLoginMqq;
    private SharedPreferences login;
    private SharedPreferences loginstatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginstatus = getSharedPreferences("loginstatus", MODE_PRIVATE);
        initView();
        //创建SharedPreferences对象
        login = getSharedPreferences("login",0);
        //传值
        boolean isLogin = login.getBoolean("isLogin",false);
        String uid = login.getString("uid","00");
         //sp.edit().putString("uid","00");
//        if(isLogin){
//            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//            startActivity(intent);
//        }

    }

    private void initView() {
        mLoginUsername = (EditText) findViewById(R.id.Login_username);
        mLoginUserpassword = (EditText) findViewById(R.id.Login_userpassword);
        mLoginButtonup = (Button) findViewById(R.id.Login_buttonup);
        mLoginButtonup.setOnClickListener(this);
        mLoginRegister = (TextView) findViewById(R.id.Login_register);
        mLoginRegister.setOnClickListener(this);
        mLoginPassworddown = (TextView) findViewById(R.id.Login_passworddown);
        mLoginPassworddown.setOnClickListener(this);
        mLoginMqq = (ImageView) findViewById(R.id.Login_mqq);
        mLoginMqq.setOnClickListener(this);
    }

    UMAuthListener authListener = new UMAuthListener() {
        /**
         * @desc 授权开始的回调
         * @param platform 平台名称
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {
        }

        /**
         * @desc 授权成功的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param data 用户资料返回
         */
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_LONG).show();
            String iconurl = data.get("iconurl");
            String name = data.get("name");
            loginstatus.edit().putBoolean("flag",true).commit();
            //使用EventBus把值传给我的
            EventBus.getDefault().post(new FirstEvent(iconurl, name));
            finish();
        }

        /**
         * @desc 授权失败的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, int action, final Throwable t) {
            Toast.makeText(LoginActivity.this, "登录失败：" + t.getMessage(), Toast.LENGTH_LONG).show();
        }

        /**
         * @desc 授权取消的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         */
        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(LoginActivity.this, "取消了", Toast.LENGTH_LONG).show();
        }
    };
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.Login_buttonup:
//获取输入内容
                String name=mLoginUsername.getText().toString().trim();
                String pwd=mLoginUserpassword.getText().toString().trim();
                Map<String,String> map=new HashMap<>();
                map.put("mobile",name);
                map.put("password",pwd);
                LoginHttpclient.getHttpClient().doPost(map, Api.LOGIN, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, final Response response) throws IOException {
                        final LoginBean rigstBean=new Gson().fromJson(response.body().string(),LoginBean.class);

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(LoginActivity.this,rigstBean.getMsg(),Toast.LENGTH_SHORT).show();
                                if(rigstBean.getMsg().equals("登录成功"))
                                {
                                    SharedPreferences.Editor editor=login.edit();
                                    editor.putBoolean("isLogin",true);
                                    editor.putString("uid","00");
                                    editor.commit();//提交保存到SharedPreferences
                                    loginstatus.edit().putBoolean("flag",true).commit();

                                    Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                                    startActivity(intent);
                                }
                            }
                        });
                    }
                });

                break;
            case R.id.Login_register:
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.Login_passworddown:
                Toast.makeText(this,"亲，现在不支持忘记密码哦，请再注册一个吧",Toast.LENGTH_SHORT).show();
                break;
            case R.id.Login_mqq:
                UMShareAPI.get(LoginActivity.this).getPlatformInfo(LoginActivity.this, SHARE_MEDIA.QQ, authListener);
                break;
        }
    }
}
