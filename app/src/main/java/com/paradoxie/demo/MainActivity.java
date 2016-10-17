package com.paradoxie.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.paradoxie.demo.dao.AdvertDao;
import com.paradoxie.demo.db.DbCore;
import com.paradoxie.demo.entity.Advert;

import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mAdd, mDelete, mUpdate, mFind,mButton;
    private TextView mContext;
    private Advert mAdvert;
    private AdvertDao mAdvertDao;
    private DbCore dbcore;

    private Random mRandom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = (TextView) findViewById(R.id.textView);
        mAdd = (Button) findViewById(R.id.button);
        mDelete = (Button) findViewById(R.id.button2);
        mUpdate = (Button) findViewById(R.id.button3);
        mFind = (Button) findViewById(R.id.button4);
        mButton = (Button) findViewById(R.id.buttonToActivity);
        mAdd.setOnClickListener(this);
        mDelete.setOnClickListener(this);
        mUpdate.setOnClickListener(this);
        mFind.setOnClickListener(this);
        mButton.setOnClickListener(this);

        mAdvertDao = dbcore.getDaoSession().getAdvertDao();//实例化mAdvertDao

        mRandom = new Random();//随机主键
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                addDate();
                break;
            case R.id.button2:
                deleteDate();
                break;
            case R.id.button3:
                updateDate();
                break;
            case R.id.button4:
                findDate();
                break;
            case R.id.buttonToActivity:
                startActivity(new Intent(MainActivity.this,PlayerActivity.class));
                break;
        }
    }

    //增加一个条目到数据库
    private void addDate() {
        mAdvert = new Advert((long) 1, "图片", "2次", "20s");
        mAdvertDao.insert(mAdvert);//添加一个,添加一次过后就必须删除操作，删除上面这个，因为主键必须唯一，否则会报错
        mContext.setText(mAdvert.getClassify() + "类型的广告");

        mAdvert = new Advert((long) mRandom.nextLong(), "图片", "2次", "20s");
        mAdvertDao.insert(mAdvert);//添加一个

    }

    //删除
    private void deleteDate() {
        mAdvert = mAdvertDao.load((long) 1);
        if (mAdvert != null) {//查到存在才删
            Toast.makeText(MainActivity.this, mAdvert.getClassify() + "类型的广告删除成成功", Toast.LENGTH_LONG).show();
            mAdvertDao.deleteByKey((long) 1);
        } else {
            Toast.makeText(MainActivity.this, "主键为1的广告类型不存在哇", Toast.LENGTH_LONG).show();
        }
    }

    //更新
    private void updateDate() {
        mAdvert = new Advert((long) 1, "图片", "5次", "50s");
        mAdvertDao.update(mAdvert);
    }

    //查找
    private void findDate() {
        List<Advert> list = mAdvertDao.loadAll();
        String id = "";
        for (int i = 0; i < list.size(); i++) {
            id += list.get(i).getId() + ",";
        }
        mContext.setText("数据库啊：" + id);
    }
}
