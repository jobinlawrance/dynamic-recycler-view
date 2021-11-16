package com.jobinlawrance.dynamicrecyclerview.ui.viewholders

import com.bumptech.glide.Glide
import com.jobinlawrance.dynamicrecyclerview.databinding.ViewholderContactItemBinding
import com.jobinlawrance.dynamicrecyclerview.ui.models.ContactUI


/**
 * Created by Jobin Lawrance on 15/11/21
 */
class ContactItemViewHolder(private val binding: ViewholderContactItemBinding) :
    BaseViewHolder<ContactUI>(binding) {
    override fun bind(item: ContactUI) = with(binding) {
        Glide.with(context)
            .load(item.avatar)
            .circleCrop()
            .into(ivAvatar)

        tvName.text = item.name
        tvCity.text = item.city
    }
}