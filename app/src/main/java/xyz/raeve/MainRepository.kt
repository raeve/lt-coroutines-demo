package xyz.raeve

interface MainRepository {
  fun getPhotos(): List<PicsumPhoto>

  companion object {
    fun create(): MainRepository = MainRepositoryNetwork()
  }
}