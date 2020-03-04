package com.bw.guojinyi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.guojinyi.net.ApiService;
import com.bw.guojinyi.net.RetrofitUtil;

import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ShowActivity extends AppCompatActivity {

    private TextView tvDZ;
    private Button btnDz;
    private Button btnCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        initView();

        btnDz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvDZ.setText("新增收货地址");
            }
        });
        //创建订单
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("ordeInfo","[{'commodityId':3,'amount':1},{'commodityId':5,'amount':1}]");
                hashMap.put("totalPrice","520.55");
                hashMap.put("addressId","0");
                //请求数据
                RetrofitUtil instance = RetrofitUtil.getInstance();
                ApiService service = instance.createService();
                Observable createOrder = service.getCreateOrder(hashMap);
                createOrder.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(Object value) {
                                Toast.makeText(ShowActivity.this, "添加成功", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onError(Throwable e) {
                                Toast.makeText(ShowActivity.this, "添加失败", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onComplete() {

                            }
                        });
            }
        });


    }

    private void initView() {
        tvDZ = findViewById(R.id.tvDZ);
        btnDz = findViewById(R.id.btnDz);
        btnCreate = findViewById(R.id.btnCreate);
    }
}
