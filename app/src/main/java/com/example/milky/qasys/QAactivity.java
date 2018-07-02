package com.example.milky.qasys;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class QAactivity extends AppCompatActivity implements View.OnClickListener {

    Button send_btn;
    ListView listView;
    EditText input_box;
    List<Message> msg_list;
    MessageHelper msgAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qaactivity);
        //requestWindowFeature(Window w.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        init();
        //sendData("Welcome to ASK ME!",Message.Answer);

//        CallSystem();
    }

//    Boolean CallSystem(String msg) {
//       //默认的信息,错误处理等...与后端链接...
//    }

    private void init() {
        listView = (ListView) findViewById(R.id.msg_list_view);
        input_box = (EditText)findViewById(R.id.input_box);
        send_btn = (Button) findViewById(R.id.send_btn);
        send_btn.setOnClickListener(this);
        msg_list = new ArrayList<Message>();
        msgAdapter = new MessageHelper(getBaseContext(),R.id.msg_list_view,msg_list);
        listView.setAdapter(msgAdapter);
    }
    void sendData(String msg,int type){
        Message sendMsg = new Message(msg,type);
        msg_list.add(sendMsg);
        msgAdapter.notifyDataSetChanged();
        listView.setSelection(msg_list.size());
    }

    // 此处应该和后端链接....


    @Override
    public void onClick(View view) {
        sendData("软件开发云中各个区域的数据是否共通？",Message.Question);
        sendData("软件开发云中各个区域的数据不共通，各自独立，如：东北区创建的项目、代码仓库、任务等，在华北区看不到，反之一样。此外，各个区域中各服务的使用量、计费情况也是分开计算的。说明：软件开发云目前只支持东北区和华北区。",Message.Answer);
        String msg = input_box.getText().toString();
        if (msg.equals("")==false){
            //sendData(msg,Message.Question);
            input_box.setText("");
            InputMethodManager m = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            m.hideSoftInputFromWindow(view.getWindowToken(),0);
        }
    }
}
