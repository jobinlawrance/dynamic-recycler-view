package com.jobinlawrance.dynamicrecyclerview.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jobinlawrance.dynamicrecyclerview.databinding.ViewholderContactItemBinding
import com.jobinlawrance.dynamicrecyclerview.ui.models.ContactUI
import com.jobinlawrance.dynamicrecyclerview.ui.viewholders.ContactItemViewHolder


/**
 * Created by Jobin Lawrance on 15/11/21
 */

class ContactsAdapter(private val contacts: List<ContactUI>) :
    RecyclerView.Adapter<ContactItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ViewholderContactItemBinding.inflate(inflater, parent, false)
        return ContactItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactItemViewHolder, position: Int) {
        holder.bind(contacts[position])
    }

    override fun getItemCount(): Int = contacts.size
}