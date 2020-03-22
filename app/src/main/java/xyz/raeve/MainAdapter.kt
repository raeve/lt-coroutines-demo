package xyz.raeve

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import coil.api.load

class MainAdapter : RecyclerView.Adapter<MainAdapter.ImageViewHolder>() {
  var list = listOf<PicsumPhoto>()

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
    ImageViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_photo, parent, false))


  override fun getItemCount(): Int = list.size

  override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
    (holder.itemView as ImageView).load(list[position].downloadUrl) {
      crossfade(true)
      placeholder(R.drawable.gradient)
    }
  }

  inner class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view)
}