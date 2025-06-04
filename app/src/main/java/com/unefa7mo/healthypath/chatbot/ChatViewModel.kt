package com.unefa7mo.healthypath.chatbot

import androidx.lifecycle.ViewModel
import com.google.ai.client.generativeai.GenerativeModel
import androidx.lifecycle.viewModelScope
import com.google.ai.client.generativeai.type.content
import kotlinx.coroutines.launch

class ChatViewModel: ViewModel() {

    val messageList by lazy {

        mutableListOf<MessageModel>()
    }

    val generativeModel: GenerativeModel= GenerativeModel(

                modelName = "gemini-pro",
      apiKey = Constants().apiKey
    )

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


              val response = chat.sendMessage(question)
              messageList.add(MessageModel(response.text.toString(), "model"))
          }catch (e: Exception){
              messageList.add(MessageModel("Error: "+e.message.toString(), "model"))
          }

        }


    }
}