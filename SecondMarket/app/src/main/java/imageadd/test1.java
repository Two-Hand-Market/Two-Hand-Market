package imageadd;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.demo.secondmarket.R;


public class test1 extends Activity {

    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);

        iv = (ImageView) findViewById(R.id.image_show);

        findViewById(R.id.add_image_btn).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                showImagePickDialog();
            }
        });
    }

    public void showImagePickDialog() {
        String title = "获取图片方式";
        String[] choices = new String[]{"拍照", "从手机中选择"};

        new AlertDialog.Builder(this)
                .setTitle(title)
                .setItems(choices, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        switch (which) {
                            case 0:
                                ImageUtils.openCameraImage(test1.this);
                                break;
                            case 1:
                                ImageUtils.openLocalImage(test1.this);
                                break;
                        }
                    }
                })
                .setNegativeButton("返回", null)
                .show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED) {
            return;
        }

        switch (requestCode) {
            // 拍照获取图片
            case ImageUtils.GET_IMAGE_BY_CAMERA:
                // uri传入与否影响图片获取方式,以下二选一
                // 方式一,自定义Uri(ImageUtils.imageUriFromCamera),用于保存拍照后图片地址
                if(ImageUtils.imageUriFromCamera != null) {
                    // 可以直接显示图片,或者进行其他处理(如压缩或裁剪等)
//				iv.setImageURI(ImageUtils.imageUriFromCamera);
                    // 对图片进行裁剪
                    ImageUtils.cropImage(this, ImageUtils.imageUriFromCamera);
                    break;
                }

                break;
            // 手机相册获取图片
            case ImageUtils.GET_IMAGE_FROM_PHONE:
                if(data != null && data.getData() != null) {
                    // 可以直接显示图片,或者进行其他处理(如压缩或裁剪等)
                    // iv.setImageURI(data.getData());

                    // 对图片进行裁剪
                    ImageUtils.cropImage(this, data.getData());
                }
                break;
            // 裁剪图片后结果
            case ImageUtils.CROP_IMAGE:
                if(ImageUtils.cropImageUri != null) {
                    // 可以直接显示图片,或者进行其他处理(如压缩等)
                    iv.setImageURI(ImageUtils.cropImageUri);
                }
                break;
            default:
                break;
        }
    }
}
