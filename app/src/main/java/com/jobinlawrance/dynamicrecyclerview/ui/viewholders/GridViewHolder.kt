package com.jobinlawrance.dynamicrecyclerview.ui.viewholders

import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jobinlawrance.dynamicrecyclerview.databinding.ViewholderGridBinding
import com.jobinlawrance.dynamicrecyclerview.ui.models.GridUI


/**
 * Created by Jobin Lawrance on 12/11/21
 */
class GridViewHolder(private val binding: ViewholderGridBinding): BaseViewHolder<GridUI>(binding) {
    override fun bind(item: GridUI) {
        val urls = item.imageUrls
        attachImage(binding.imageOne, urls[0])
        attachImage(binding.imageTwo, urls[1])
        attachImage(binding.imageThree, urls[2])
        attachImage(binding.imageFour, urls[3])
    }

    private fun attachImage(imageView: ImageView, url: String) {
        Glide.with(context)
            .load(url)
            .centerCrop()
            .into(imageView)
    }
}