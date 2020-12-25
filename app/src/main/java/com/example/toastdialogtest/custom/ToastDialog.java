package com.example.toastdialogtest.custom;

import android.app.Dialog;
import android.content.Context;
import android.text.Layout;
import android.view.Gravity;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.toastdialogtest.R;

import java.util.List;

public class ToastDialog extends Dialog{
    public ToastDialog(@NonNull Context context) {
        //传入0,使用默认的主题样式
        this(context,0);
    }

    public ToastDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }


    protected ToastDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }


    //使用建造者模式提供初始化
    public static class Builder{
        private Context mContext;
        private String message;
        private View contentView;
        private int dialogPosition;
        public Builder(Context context){
            this.mContext=context;
        }
        public Builder setMessage(String message){
            this.message=message;
            return this;
        }
        public Builder setContentView(View contentView){
            this.contentView=contentView;
            return this;
        }

        /**
         *
         * @param GravitPostiion 查看Gravity静态类的位置
         * @return
         */
        public Builder setPosition(int GravitPostiion){
            this.dialogPosition=GravitPostiion;
            return this;
        }
        public ToastDialog build(){
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // instantiate the dialog with the custom Theme
            final ToastDialog dialog = new ToastDialog(mContext);
            Window window = dialog.getWindow();
            WindowManager.LayoutParams lp = window.getAttributes();
            if (dialogPosition!=-1){
                window.setGravity(dialogPosition);
            }

            View layout = inflater.inflate(R.layout.ite_dialog_custome, null);
            dialog.addContentView(layout, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            // set the content message
            if (message != null) {
                ((TextView) layout.findViewById(R.id.tv_message)).setText(message);
            }
            dialog.setContentView(layout);
            return dialog;
        }

    }






    @Override
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> data, @Nullable Menu menu, int deviceId) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
