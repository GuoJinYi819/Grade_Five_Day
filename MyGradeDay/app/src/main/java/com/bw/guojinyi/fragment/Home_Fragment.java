package com.bw.guojinyi.fragment;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bw.guojinyi.R;
import com.bw.guojinyi.base.BaseFragment;
import com.bw.guojinyi.bean.BannerBean;
import com.bw.guojinyi.bean.ResultBean;
import com.bw.guojinyi.mvp.BannerPresenterImpl;
import com.bw.guojinyi.mvp.IBannerContract;
import com.stx.xhb.xbanner.XBanner;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: MyGradeDay
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/2/21 13:43
 * @Description: 用途：完成特定功能
 */
public class Home_Fragment extends BaseFragment<BannerPresenterImpl> implements IBannerContract.IBannerView {

   
    private XBanner xbanner;

    @Override
    protected int initLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        xbanner = view.findViewById(R.id.home_xbanner);
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

    @Override
    protected void initData() {
        presenter.getData();
        presenter.getData();
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected BannerPresenterImpl initPresenter() {
        return new BannerPresenterImpl();
    }

    @Override
    public void onSuccess(BannerBean bannerBean) {
            //xbanner
        final ArrayList<String> strings = new ArrayList<>();
        final List<ResultBean> result = bannerBean.getResult();
        for (int i = 0; i < result.size(); i++) {
            strings.add(result.get(i).getImageUrl());
        }

        xbanner.setData(strings,null);
        xbanner.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                Glide.with(getContext())
                        .load(strings.get(position))
                        .into((ImageView) view);
            }
        });
        xbanner.setmAutoPalyTime(2000);

//        RetrofitUtil retrofitUtil =  RetrofitUtil.getInstance();
//        ApiService service = retrofitUtil.createService();
//        final Observable<DataBean> getgoods = service.getgoods();
//        getgoods.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<DataBean>() {
//                    @Override
//                    public void accept(DataBean bannerBean) throws Exception {
//
//                    }
//                });

    }

    @Override
    public void onFailed(String error) {

    }
}
