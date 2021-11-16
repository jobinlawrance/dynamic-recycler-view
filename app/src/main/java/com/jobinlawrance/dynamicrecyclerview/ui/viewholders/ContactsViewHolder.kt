package com.jobinlawrance.dynamicrecyclerview.ui.viewholders

import androidx.recyclerview.widget.LinearLayoutManager
import com.jobinlawrance.dynamicrecyclerview.databinding.ViewholderContactsBinding
import com.jobinlawrance.dynamicrecyclerview.ui.ContactsAdapter
import com.jobinlawrance.dynamicrecyclerview.ui.models.ContactListUI


/**
 * Created by Jobin Lawrance on 15/11/21
 */
class ContactsViewHolder(private val binding: ViewholderContactsBinding) :
    BaseViewHolder<ContactListUI>(binding) {
    override fun bind(item: ContactListUI) = with(binding) {
        rvContacts.adapter = ContactsAdapter(item.contacts)
        rvContacts.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }
}