package jp.techacademy.chiku.takahiro.taskappver02;
//ListViewにデータを表示させる仕組み
//SimpleAdapterというデフォルトで使えるAdapterもある
//今回はリストの各行のViewを返す部分を自分で記述するため、自分でAdapterを作る

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class TaskAdapter extends BaseAdapter {
    //他のxmlリソースのViewを取り扱うための仕組みであるLayoutInflaterをメンバ変数として定義
    private LayoutInflater mLayoutInflater = null;
    private List<Task> mTaskList;

    public TaskAdapter(Context context) {
        //システムレベルのサービスを取得するためのメソッド
        //レイアウトのためのサービスとアラームのためのサービスを取得する
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    public void setTaskList(List<Task> taskList) {
        mTaskList = taskList;
    }

    @Override
    public int getCount() {
        return mTaskList.size();
    }

    @Override
    public Object getItem(int position) {
        return mTaskList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mTaskList.get(position).getId();
    }

    //カテゴリのgetterを付けてみる
    //getCategoryではなくgetに変更してみる
    //public String getCategory(String category){
    //    return mTaskList.get(category);
    //}

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.list_view, null);
        }

        TextView textView1 = (TextView) convertView.findViewById(R.id.text1);
        TextView textView2 = (TextView) convertView.findViewById(R.id.text2);
        TextView textView3 = (TextView) convertView.findViewById(R.id.text3);

        // 後でTaskクラスから情報を取得するように変更する
        //ここに,getCategory()を入れれば表示されるようになるのか、、、？
        textView1.setText(mTaskList.get(position).getTitle());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.JAPANESE);
        Date date = mTaskList.get(position).getDate();
        textView2.setText(simpleDateFormat.format(date));

        textView3.setText(mTaskList.get(position).getCategory());

        return convertView;
    }
}