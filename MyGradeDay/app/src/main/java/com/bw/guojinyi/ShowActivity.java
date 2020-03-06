package com.bw.guojinyi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bw.guojinyi.bean.PayBean;
import com.bw.guojinyi.net.ApiService;
import com.bw.guojinyi.net.RetrofitUtil;

import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ShowActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        Button btnZF = findViewById( R.id.btnZF );

        btnZF.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HashMap<String, String> param = new HashMap<>();
                param.put( "orderId","2020030421045648528055" );
                param.put( "payType","1" );

                RetrofitUtil instance = RetrofitUtil.getInstance();
                ApiService service = instance.createService();
                Observable<PayBean> pay = service.getPay( param );
                pay.subscribeOn( Schedulers.io() )
                        .observeOn( AndroidSchedulers.mainThread() )
                        .subscribe( new Observer<PayBean>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(PayBean value) {
                                Toast.makeText( ShowActivity.this, "支付成功", Toast.LENGTH_SHORT ).show();
                            }

                            @Override
                            public void onError(Throwable e) {
                                Toast.makeText( ShowActivity.this, "支付失败", Toast.LENGTH_SHORT ).show();
                            }

                            @Override
                            public void onComplete() {

                            }
                        } );
            }
        } );
    }

}
