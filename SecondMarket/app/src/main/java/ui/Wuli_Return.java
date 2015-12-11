package ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;

/**
 * Created by Administrator on 2015/11/30 0030.
 */
public class Wuli_Return extends Activity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public void creatdialog(){
        AlertDialog.Builder b=new AlertDialog.Builder(Wuli_Return.this);
        b.setMessage("确认退出？");
        b.setTitle("提示");
        b.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                    Wuli_Return.this.finish();
            }
        });

        b.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        b.create().show();
    }

    public boolean onKeyDown(int keyCode,KeyEvent event){
        if(keyCode==KeyEvent.KEYCODE_BACK && event.getRepeatCount()==0){
            creatdialog();
        }
        return false;
    }
}
