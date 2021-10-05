package com.example.chatuisapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chatuisapp.models.Chat
import com.example.chatuisapp.adapters.ChatAdapter
import com.example.chatuisapp.R
import kotlinx.android.synthetic.main.activity_list_of_chats.*
import java.util.*

class ListOfChatsActivity : AppCompatActivity() {
    private var user = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_of_chats)

        intent.getStringExtra("user")?.let { user = it }

        if (user.isNotEmpty()){
            initViews()
        }
    }

    private fun initViews(){
        newChatButton.setOnClickListener { newChat() }

        listChatsRecyclerView.layoutManager = LinearLayoutManager(this)
        listChatsRecyclerView.adapter =
            ChatAdapter { chat ->
                chatSelected(chat)
            }
    }

    private fun chatSelected(chat: Chat){
        val intent = Intent(this, ChatActivity::class.java)
        intent.putExtra("chatId", chat.id)
        intent.putExtra("user", user)
        startActivity(intent)
    }

    private fun newChat(){
        val chatId = UUID.randomUUID().toString()

        val intent = Intent(this, ChatActivity::class.java)
        intent.putExtra("chatId", chatId)
        intent.putExtra("user", user)
        startActivity(intent)
    }
}