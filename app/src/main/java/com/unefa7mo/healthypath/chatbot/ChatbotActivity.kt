package com.unefa7mo.healthypath.chatbot

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.unefa7mo.healthypath.databinding.ActivityChatbotBinding
import kotlinx.coroutines.launch


class ChatbotActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChatbotBinding
    private val chatViewModel: ChatViewModel by viewModels()
    private lateinit var messageAdapter: MessageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatbotBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        observeMessages()

        binding.imgback.setOnClickListener { finish() }
        binding.imgbtnsend.setOnClickListener { sendMessage() }
        binding.edittextmessage.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEND) {
                sendMessage()
                true
            } else {
                false
            }
        }
    }

    private fun setupRecyclerView() {
        messageAdapter = MessageAdapter()
        binding.recyclerMessages.layoutManager = LinearLayoutManager(this).apply {
            stackFromEnd = true
        }
        binding.recyclerMessages.adapter = messageAdapter
    }

    private fun observeMessages() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                chatViewModel.messages.collect { messages ->
                    binding.emptyState.isVisible = messages.isEmpty()
                    messageAdapter.submit(messages)
                    scrollToLastMessage()
                }
            }
        }
    }

    private fun sendMessage() {
        val text = binding.edittextmessage.text?.toString()?.trim().orEmpty()
        if (text.isEmpty()) return

        chatViewModel.sendMessage(text)
        binding.edittextmessage.text?.clear()
        hideKeyboard()
    }

    private fun scrollToLastMessage() {
        binding.recyclerMessages.post {
            if (messageAdapter.itemCount > 0) {
                binding.recyclerMessages.scrollToPosition(messageAdapter.itemCount - 1)
            }
        }
    }

    private fun hideKeyboard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.edittextmessage.windowToken, 0)
    }
}