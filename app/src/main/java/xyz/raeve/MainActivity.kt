package xyz.raeve

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {

  private val presenter: MainPresenter by lazy {
    MainPresenter(this)
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
    if (item.itemId == R.id.menuRefresh) presenter.retrieveData()
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
}
