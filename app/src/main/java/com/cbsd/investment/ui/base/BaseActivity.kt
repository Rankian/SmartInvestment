package com.cbsd.investment.ui.base


import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.cbsd.investment.R
import com.gyf.immersionbar.ImmersionBar
import kotlinx.android.synthetic.main.include_title.*

abstract  class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ImmersionBar.with(this)
            .statusBarDarkFont(true, 0.2f)
            .navigationBarColor(R.color.white)
            .statusBarColor(R.color.white)
            .fitsSystemWindows(true)
            .init()
        setContentView(setLayoutView())
        initView()
        initData()
        initListener()

    }

    protected abstract fun setLayoutView(): Int
    protected abstract fun initView()
    protected abstract fun initData()
    protected abstract fun initListener()


    protected open fun setTitleText(title: String?) {

        tv_include_title_text.text = title

    }

    protected open fun backFinish() {

        iv_include_title_back.setOnClickListener(View.OnClickListener {

            finish()
        })

    }

    open fun forward(cls: Class<*>?) {
        startActivity(Intent(this, cls))
    }


}