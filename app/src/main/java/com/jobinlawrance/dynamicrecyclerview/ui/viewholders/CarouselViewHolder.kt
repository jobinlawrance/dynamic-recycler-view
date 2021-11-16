package com.jobinlawrance.dynamicrecyclerview.ui.viewholders

import android.view.View
import androidx.constraintlayout.helper.widget.Carousel
import com.jobinlawrance.dynamicrecyclerview.databinding.ViewholderCarouselBinding
import com.jobinlawrance.dynamicrecyclerview.ui.models.CarouselUI


/**
 * Created by Jobin Lawrance on 15/11/21
 */
class CarouselViewHolder(private val binding: ViewholderCarouselBinding) :
    BaseViewHolder<CarouselUI>(binding) {
    override fun bind(item: CarouselUI) {
        binding.carousel.setAdapter(object : Carousel.Adapter {
            override fun count(): Int = 4

            override fun populate(view: View, index: Int) {
                // need to implement this to populate the view at the given index
            }

            override fun onNewItem(index: Int) {
                // called when an item is set
            }
        })
    }
}