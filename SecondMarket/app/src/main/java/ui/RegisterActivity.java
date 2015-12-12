package ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.demo.secondmarket.R;

/**
 * Created by Administrator on 2015/11/20 0020.
 */
public class RegisterActivity extends Activity {
   /* public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.register_layout);
    }
    //返回到主界面
    public void return_back(View view){
        Intent intent=new Intent(RegisterActivity.this,MainActivity.class);
        startActivity(intent);
    }*/

    private EditText edname1;
    private EditText edpassword1;
    private Button btregister1;
    SQLiteDatabase db;

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        db.close();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        edname1 = (EditText) findViewById(R.id.edname1);
        edpassword1 = (EditText) findViewById(R.id.edpassword1);
        btregister1 = (Button) findViewById(R.id.btregister1);

        btregister1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String name = edname1.getText().toString();
                String password = edpassword1.getText().toString();
                if (!(name.equals("") || password.equals(""))) {
                    if (addUser(name, password)) {
                        DialogInterface.OnClickListener ss = new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                // TODO Auto-generated method stub
                                // 跳转到登录界面
                                Intent in = new Intent();
                                in.setClass(RegisterActivity.this, LoginActivity.class);
                                startActivity(in);
                                // 销毁当前activity
                                RegisterActivity.this.onDestroy();
                            }
                        };
                        new AlertDialog.Builder(RegisterActivity.this)
                                .setTitle("注册成功").setMessage("注册成功")
                                .setPositiveButton("确定", ss).show();
                    } else {
                        String result = checkIfexist(name);
                        new AlertDialog.Builder(RegisterActivity.this)
                                .setTitle("注册失败").setMessage(result)
                                .setPositiveButton("确定", null).show();
                    }
                } else {
                    new AlertDialog.Builder(RegisterActivity.this)
                            .setTitle("注册失败").setMessage("帐号密码不能为空")
                            .setPositiveButton("确定", null).show();
                }

            }
        });

    }

    // 添加用户
    public Boolean addUser(String name, String password) {
        String str = "insert into tb_user values(?,?) ";
        LoginActivity main = new LoginActivity();
        db = SQLiteDatabase.openOrCreateDatabase(this.getFilesDir().toString()
                + "/test.dbs", null);
        main.db = db;

//检查账号是否已经存在
        String sql="select * from tb_user where name=?";
        Cursor cursor = db.rawQuery(sql, new String []{name});
        if(cursor.getCount()>0)return false;


        try {
            db.execSQL(str, new String[] {name,password});
            return true;
        } catch (Exception e) {
            main.createDb();
        }
        return false;
    }

    //检查账号是否已经存在
    public String checkIfexist(String name){
        LoginActivity main = new LoginActivity();
        db = SQLiteDatabase.openOrCreateDatabase(this.getFilesDir().toString() + "/test.dbs", null);
        main.db = db;
        String sql="select * from tb_user where name=?";
        Cursor cursor = db.rawQuery(sql, new String []{name});
        if(cursor.getCount()>0)return "该账号已存在";
        return "注册失败";
    }

}
