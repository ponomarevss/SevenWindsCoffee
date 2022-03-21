package ru.ponomarevss.sevenwindscoffee.ui.image

import android.widget.ImageView
import ru.ponomarevss.sevenwindscoffee.model.image.IImageLoader

class GlideImageLoader: IImageLoader<ImageView> {
    override fun loadInto(url: String, container: ImageView) {
        GlideApp.with(container.context)
            .load(url)
            .into(container)
    }
}