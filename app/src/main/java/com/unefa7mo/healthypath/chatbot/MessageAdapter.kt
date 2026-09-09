package com.unefa7mo.healthypath.chatbot

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.unefa7mo.healthypath.databinding.ItemMessageModelBinding
import com.unefa7mo.healthypath.databinding.ItemMessageUserBinding

class MessageAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var messages: List<MessageModel> = emptyList()

    companion object {
        private const val TYPE_USER = 0
        private const val TYPE_MODEL = 1
    }

    class UserViewHolder(val binding: ItemMessageUserBinding) : RecyclerView.ViewHolder(binding.root)

    class ModelViewHolder(val binding: ItemMessageModelBinding) : RecyclerView.ViewHolder(binding.root)

    fun submit(newMessages: List<MessageModel>) {
        messages = newMessages
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int =
        if (messages[position].role == "user") TYPE_USER else TYPE_MODEL

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return if (viewType == TYPE_USER) {
            UserViewHolder(ItemMessageUserBinding.inflate(inflater, parent, false))
        } else {
            ModelViewHolder(ItemMessageModelBinding.inflate(inflater, parent, false))
        }
    }

    override fun getItemCount(): Int = messages.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val message = messages[position]
        when (holder) {
            is UserViewHolder -> holder.binding.messageText.text = message.message
            is ModelViewHolder -> holder.binding.messageText.text = message.message
        }
    }
}