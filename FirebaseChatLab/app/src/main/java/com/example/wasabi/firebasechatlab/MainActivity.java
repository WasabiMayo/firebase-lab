package com.example.wasabi.firebasechatlab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.firebase.ui.FirebaseListAdapter;

import java.util.LinkedList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private EditText mEditText;
    private Button mSendButton;
    private LinkedList<MessageObj> mMessageList;

    String username;

    Firebase mRootElementRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRootElementRef = new Firebase("https://fbaselabclaire.firebaseio.com/");

        mListView = (ListView)findViewById(R.id.listview);
        mEditText = (EditText)findViewById(R.id.edit_text);
        mSendButton = (Button)findViewById(R.id.send_button);
        mMessageList = new LinkedList<>();

        Random random = new Random();
        username = "user" + String.valueOf(random.nextInt(1000));

        FirebaseListAdapter<MessageObj> adapter = new FirebaseListAdapter<MessageObj>(this, MessageObj.class, R.layout.chat_list_item, mRootElementRef) {
            @Override
            protected void populateView(View view, MessageObj messageObj, int i) {
                TextView usernameTextView = (TextView) view.findViewById(R.id.textView1);
                TextView messageTextView = (TextView) view.findViewById(R.id.textView2);
                usernameTextView.setText(messageObj.getUsername());
                messageTextView.setText(messageObj.getMessage());
            }
        };

        mListView.setAdapter(adapter);

        mSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MessageObj obj = new MessageObj(username, mEditText.getText().toString());
                mRootElementRef.push().setValue(obj);
            }
        });


    }
}
