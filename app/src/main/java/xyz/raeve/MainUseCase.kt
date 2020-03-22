package xyz.raeve

import java.util.*

class MainUseCase: MainService {
  override fun requestData() = UUID.randomUUID().toString()
}