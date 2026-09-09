package com.unefa7mo.healthypath.chatbot

import androidx.lifecycle.ViewModel
import com.google.ai.client.generativeai.GenerativeModel
import androidx.lifecycle.viewModelScope
import com.unefa7mo.healthypath.BuildConfig

import com.google.ai.client.generativeai.type.content
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ChatViewModel: ViewModel() {

    val messageList by lazy {

        mutableListOf<MessageModel>()
    }

    private val _messages = MutableStateFlow<List<MessageModel>>(emptyList())
    val messages: StateFlow<List<MessageModel>> = _messages.asStateFlow()

    val generativeModel: GenerativeModel= GenerativeModel(modelName = "gemini-pro", apiKey = BuildConfig.API_KEY)

    fun sendMessage(question: String){
        viewModelScope.launch {
          try {
              val chat = generativeModel.startChat(
                  history = messageList.map {
                      content(it.role){text(it.message) }
                  }.toList()
              )
              messageList.add(MessageModel(question, "user"))
              messageList.add(MessageModel("Escribiendo...", "model"))
              _messages.value = messageList.toList()

              val response = chat.sendMessage(question)
              messageList.removeAt(messageList.lastIndex)
              messageList.add(MessageModel(response.text.toString(), "model"))
              _messages.value = messageList.toList()
          }catch (e: Exception){
              if (messageList.lastOrNull()?.message == "Escribiendo...") {
                  messageList.removeAt(messageList.lastIndex)
              }
              messageList.add(MessageModel("Error: "+e.message.toString(), "model"))
              _messages.value = messageList.toList()
          }

        }


    }
}