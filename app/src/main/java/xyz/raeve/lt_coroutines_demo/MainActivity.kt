package xyz.raeve.lt_coroutines_demo

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import xyz.raeve.lt_coroutines_demo.co.presentation.CoMainPresenter
import xyz.raeve.lt_coroutines_demo.rx.presentation.RxMainPresenter

class MainActivity : AppCompatActivity(), MainView {

  private val rxPresenter: Presenter by lazy {
    RxMainPresenter(this)
  }

  private val coPresenter: Presenter by lazy {
    CoMainPresenter(this)
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    recyclerView.apply {
      layoutManager = LinearLayoutManager(this@MainActivity)
      adapter = MainAdapter()
    }
  }

  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    menuInflater.inflate(R.menu.menu_main, menu)
    return super.onCreateOptionsMenu(menu)
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    when (item.itemId) {
      R.id.menuRefresh -> {
        coPresenter.clear()
        rxPresenter.clear()
        clearPhotos()
      }
      R.id.menuCo -> coPresenter.retrieveData()
      R.id.menuRx -> rxPresenter.retrieveData()
    }
    return super.onOptionsItemSelected(item)
  }

  override fun showLoading() {
    progressBar.visibility = View.VISIBLE
  }

  override fun hideLoading() {
    progressBar.visibility = View.GONE
  }

  override fun showPhotos(list: List<PicsumPhoto>) {
    (recyclerView.adapter as? MainAdapter)?.let {
      it.list = list
      it.notifyDataSetChanged()
    }
  }

  override fun showMillis(millis: Long) {
    Toast.makeText(this, "Duration: $millis ms", Toast.LENGTH_SHORT).show()
  }

  private fun clearPhotos() {
    (recyclerView.adapter as? MainAdapter)?.let {
      it.list = emptyList()
      it.notifyDataSetChanged()
    }
  }
}
