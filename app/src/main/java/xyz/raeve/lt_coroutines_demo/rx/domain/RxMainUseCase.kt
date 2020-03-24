package xyz.raeve.lt_coroutines_demo.rx.domain

class RxMainUseCase(private val repository: RxMainRepository = RxMainRepository.create()) :
  RxMainService {
  override fun requestData() = repository.getPhotos()
}