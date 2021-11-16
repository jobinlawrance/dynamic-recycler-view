package com.jobinlawrance.dynamicrecyclerview.ui.viewholders

import com.jobinlawrance.dynamicrecyclerview.databinding.ViewholderQuoteBinding
import com.jobinlawrance.dynamicrecyclerview.ui.models.QuoteUI


/**
 * Created by Jobin Lawrance on 15/11/21
 */
class QuoteViewHolder(private val binding: ViewholderQuoteBinding) :
    BaseViewHolder<QuoteUI>(binding) {

    override fun bind(item: QuoteUI) = with(binding) {
        quote.text = "\"${item.quote}\""
        author.text = " - ${item.author}"
    }
}