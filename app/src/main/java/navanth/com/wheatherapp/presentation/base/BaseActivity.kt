package navanth.com.wheatherapp.presentation.base

import android.app.ProgressDialog
import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import navanth.com.wheatherapp.utils.Utility

abstract class BaseActivity : DaggerAppCompatActivity() {

    lateinit var mProgressDialog: ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        mProgressDialog = Utility.getProgressDialogInstance(this)
    }

    fun showProgressDialog() {
        mProgressDialog!!.show()
    }

    fun hideProgressDialog() {
        mProgressDialog!!.dismiss()
    }

    abstract fun getLayoutId(): Int

}