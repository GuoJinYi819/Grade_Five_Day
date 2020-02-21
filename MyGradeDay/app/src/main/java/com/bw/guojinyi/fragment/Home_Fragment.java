package com.bw.guojinyi.fragment;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bw.guojinyi.R;
import com.uuzuche.lib_zxing.activity.CodeUtils;

/**
 * ClassName: MyGradeDay
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/2/21 13:43
 * @Description: 用途：完成特定功能
 */
public class Home_Fragment extends Fragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getContext(), R.layout.fragment_home, null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ImageView imgQrCode = view.findViewById(R.id.imgQrCode);
        //生成二维码
        final String content = "郭金沂";
        Bitmap qrcode = CodeUtils.createImage(content, 300, 300, null);
        imgQrCode.setImageBitmap(qrcode);
        imgQrCode.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                //识别二维码
                CodeUtils.analyzeBitmap(content, new CodeUtils.AnalyzeCallback() {
                    @Override
                    public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
                        Toast.makeText(getContext(), "二维码的信息是："+result, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAnalyzeFailed() {
                        Toast.makeText(getContext(), "二维码的信息是："+content, Toast.LENGTH_SHORT).show();
                    }
                });
                return true;
            }
        });
    }
}
