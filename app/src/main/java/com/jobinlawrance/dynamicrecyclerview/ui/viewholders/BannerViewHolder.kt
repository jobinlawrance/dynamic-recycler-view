package layout

import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.jobinlawrance.dynamicrecyclerview.databinding.ViewholderBannerBinding
import com.jobinlawrance.dynamicrecyclerview.ui.models.BannerUI
import com.jobinlawrance.dynamicrecyclerview.ui.viewholders.BaseViewHolder


/**
 * Created by Jobin Lawrance on 12/11/21
 */
class BannerViewHolder(private val binding: ViewholderBannerBinding) :
    BaseViewHolder<BannerUI>(binding) {
    companion object {
        fun createViewHolder(inflater: LayoutInflater, parent: ViewGroup): BannerViewHolder {
            val binding = ViewholderBannerBinding.inflate(inflater, parent, false)
            return BannerViewHolder(binding)
        }
    }

    override fun bind(item: BannerUI) {
        Glide.with(context)
            .load(item.imageUrl)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    Log.e("###Glide", "Load failed", e);
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    return false
                }

            })
            .centerCrop()
            .into(binding.bannerImage)
    }
}