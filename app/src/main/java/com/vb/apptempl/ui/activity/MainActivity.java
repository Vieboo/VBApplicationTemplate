package com.vb.apptempl.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.core.listener.PauseOnScrollListener;
import com.vb.apptempl.R;
import com.vb.apptempl.ui.base.BaseActivity;
import com.vb.imageloader.ImageLoaderHelper;
import com.vb.titlebar.TitleBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Vieboo on 2017/2/9 0009.
 */
public class MainActivity extends BaseActivity {

    List<String> array = new ArrayList<>();

    @BindView(R.id.titleBar)
    TitleBar titleBar;
    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.list_view)
    ListView listView;


    @Override
    protected void initData(Bundle savedInstanceState) {
        closeSlideFinish();
        array.add("http://img0.zealer.com/be/67/37/dd870207161ac11b3780fbe508.jpg?imageView2/2/w/746/h/0");
        array.add("http://img0.zealer.com/3d/e6/9f/2fecefcd16f015c115fc52c519.jpg?imageView2/2/w/746/h/0");
        array.add("http://img0.zealer.com/b1/de/e6/6473f9221bfcfd34ebc70189cf.jpg?imageView2/2/w/746/h/0");
        array.add("http://img0.zealer.com/cd/2e/fe/43953a35b8bd9228f713b303fe.jpg?imageView2/2/w/746/h/0");
        array.add("http://img0.zealer.com/0a/f3/ce/a2be65c8130392c54f2ddcbb3a.jpg?imageView2/2/w/746/h/0");
        array.add("http://img0.zealer.com/7b/fe/a8/b772760802ad22caf7a64f712e.jpg?imageView2/2/w/746/h/0");
        array.add("http://img0.zealer.com/c1/29/b5/f26aafee5cd4ff54dd80ed2a82.jpg?imageView2/2/w/746/h/0");
        array.add("http://img0.zealer.com/e5/9e/8e/fa9b78d9aa683f6ee7557a6f63.jpg?imageView2/2/w/746/h/0");
        array.add("http://img0.zealer.com/2c/6a/65/f9220ea3ca11966494bf33baac.jpg?imageView2/2/w/746/h/0");
        array.add("http://img0.zealer.com/76/35/ae/c80f0b398b566a925a6fb96ea3.jpg?imageView2/2/w/746/h/0");
        array.add("http://img0.zealer.com/a8/d4/b5/6ddb07bdfacde08d3540976e87.jpg?imageView2/2/w/746/h/0");
        array.add("http://img0.zealer.com/ba/91/07/d0d962834aa745e02a4a1e054f.jpg?imageView2/2/w/746/h/0");
        array.add("http://img0.zealer.com/7d/97/95/0ea9343372b26ab7fde4e69fb4.jpg?imageView2/2/w/746/h/0");
        array.add("http://img0.zealer.com/fd/43/39/637073fb151120932781e4252b.jpg?imageView2/2/w/746/h/0");
        array.add("http://img0.zealer.com/c7/89/06/11c5a2b84073d1a396675ed1f7.jpg?imageView2/2/w/746/h/0");
        array.add("http://img0.zealer.com/9b/89/80/25123c7e1f9bd1b5741889787f.jpg?imageView2/2/w/746/h/0");
        array.add("http://img0.zealer.com/4f/3b/6f/66a0edc3a9ed169a19317ee694.jpg?imageView2/2/w/746/h/0");
        array.add("http://img0.zealer.com/69/08/ad/d6d6e1f94b3c46badd85c30f5b.jpg?imageView2/2/w/746/h/0");
        array.add("http://img0.zealer.com/fa/a1/87/745d12724ad777c8c5bd44c492.jpg?imageView2/2/w/746/h/0");
        array.add("https://p.pstatp.com/large/f0100061e59d7c5aa48");
        array.add("https://p.pstatp.com/large/f750004441e875992b2");
        array.add("https://p.pstatp.com/large/f0100061e921df783b7");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initTitleBar() {
        titleBar.setTitle("天空之城");
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            listView.setOnScrollListener(new PauseOnScrollListener(ImageLoader.getInstance(), true, true));
        }
    };

    @Override
    protected void initViewEvent(Bundle savedInstanceState) {

        handler.sendEmptyMessageDelayed(0, 500);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listView.setAdapter(new MyAdapter());

                String assetsUrl = ImageDownloader.Scheme.ASSETS.wrap("dva.jpg");
//                ImageLoaderHelper.setUrlDrawable(img, "https://www.hupucdn.com/uploads/hupu/focus/focus-large-2106_2017-02-13.jpg", R.mipmap.ic_launcher);
                ImageLoaderHelper.setUrlDrawable(img, assetsUrl, R.mipmap.ic_launcher);
//                Toast.makeText(mActivity, ImageLoaderHelper.isLocalFile(mActivity, "http://avatar.csdn.net/9/C/1/1_qq_22770457.jpg") + "",
//                        Toast.LENGTH_SHORT).show();
//                Toast.makeText(mActivity, ImageLoaderHelper.getCachedBitmap("http://static.oschina.net/uploads/img/201208/13122559_L8G0.png") + "",
//                        Toast.LENGTH_SHORT).show();
            }
        });

    }


    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return array.size();
        }

        @Override
        public Object getItem(int position) {
            return array.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if(null == convertView) {
                holder = new ViewHolder();
                convertView = LayoutInflater.from(mActivity).inflate(R.layout.layout_item, null, false);
                holder.item_iv = (ImageView) convertView.findViewById(R.id.item_iv);
                convertView.setTag(holder);
            }else {
                holder = (ViewHolder) convertView.getTag();
            }
            ImageLoaderHelper.setUrlDrawable(holder.item_iv, array.get(position), R.mipmap.ic_launcher);
            return convertView;
        }

        class ViewHolder {
            ImageView item_iv;
        }
    }

}
