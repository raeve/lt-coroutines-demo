package xyz.raeve.lt_coroutines_demo

import com.google.gson.annotations.SerializedName

/**
 * In our demo we will display photos inside a recycler view using this dto provided by:
 * https://picsum.photos/v2/list
 */
data class PicsumPhoto(
  @SerializedName("author") val author: String = "",
  @SerializedName("download_url") val downloadUrl: String = "",
  @SerializedName("height") val height: Int = 0,
  @SerializedName("id") val id: String = "",
  @SerializedName("url") val url: String = "",
  @SerializedName("width") val width: Int = 0
)