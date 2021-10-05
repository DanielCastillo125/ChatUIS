package com.example.chatuisapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chatuisapp.adapters.MessageAdapter
import com.example.chatuisapp.R
import com.example.chatuisapp.models.Message
import kotlinx.android.synthetic.main.activity_chat.*

class ChatActivity : AppCompatActivity() {
    private var chatId = ""
    private var user = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        intent.getStringExtra("chatId")?.let { chatId = it }
        intent.getStringExtra("user")?.let { user = it }

        if(chatId.isNotEmpty() && user.isNotEmpty()) {
            initViews()
        }
    }

    private fun initViews(){
        messagesRecylerView.layoutManager = LinearLayoutManager(this)
        messagesRecylerView.adapter = MessageAdapter(user)

        sendMessageButton.setOnClickListener { sendMessage() }

    }

    private fun sendMessage(){
        messageTextField.setText("")
    }
}