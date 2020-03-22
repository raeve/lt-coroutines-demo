package xyz.raeve

class MainUseCase(private val repository: MainRepository = MainRepository.create()) : MainService {
  override fun requestData() = repository.getPhotos()
}