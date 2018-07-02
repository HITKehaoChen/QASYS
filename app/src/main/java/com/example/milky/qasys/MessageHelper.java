package com.example.milky.qasys;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class MessageHelper extends ArrayAdapter<Message> {

    public MessageHelper( Context context, int resource, List<Message> objects ) {
        super(context, resource,objects);
    }
    Drawable drawable = null;
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Message msg = getItem(position);
        ViewHolder viewHolder;
        if (convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_chat,null);
            viewHolder.leftLayout = (LinearLayout) convertView.findViewById(R.id.left_layout);
            viewHolder.rightLayout = (LinearLayout) convertView.findViewById(R.id.right_layout);
            viewHolder.left_msg = (TextView)convertView.findViewById(R.id.left_msg);
            viewHolder.right_msg = (TextView)convertView.findViewById(R.id.right_msg);
            viewHolder.left_msg.setMovementMethod(LinkMovementMethod.getInstance());
            viewHolder.right_msg.setMovementMethod(LinkMovementMethod.getInstance());
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if (msg.getChatObj() == Message.Answer){
            viewHolder.leftLayout.setVisibility(View.VISIBLE);
            viewHolder.rightLayout.setVisibility(View.GONE);
            viewHolder.left_msg.setText("软件开发云中各个区域的数据不共通，各自独立，如：东北区创建的项目、代码仓库、任务等，在华北区看不到，反之一样。此外，各个区域中各服务的使用量、计费情况也是分开计算的。说明：软件开发云目前只支持东北区和华北区。");//来自后端
        }else{
            viewHolder.leftLayout.setVisibility(View.GONE);
            viewHolder.rightLayout.setVisibility(View.VISIBLE);
            viewHolder.right_msg.setText("软件开发云中各个区域的数据是否共通？");//同上 未完工...
        }
        return convertView;
    }

}
