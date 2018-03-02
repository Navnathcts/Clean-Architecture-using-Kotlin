package navanth.com.wheatherapp.presentation.base

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

abstract class BaseActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
//        setUpToolBar();
    }

//    fun setUpToolBar() {
//        setSupportActionBar(toolbar)
//    }
//
//    /**
//     * This will show title of activity
//     */
//    fun showTitle(title: String?) {
//        toolbar!!.setTitle(title)
//    }
//
//    /**
//     * This will show back button if needed.
//     */
//    fun showBackButton(showBackButton: Boolean) {
//        supportActionBar!!.setDisplayHomeAsUpEnabled(showBackButton)
//        supportActionBar!!.setDisplayShowHomeEnabled(showBackButton)
//        toolbar
//        toolbar!!.setNavigationOnClickListener({ view -> onBackPressed() })
//    }

    abstract fun getLayoutId(): Int

}