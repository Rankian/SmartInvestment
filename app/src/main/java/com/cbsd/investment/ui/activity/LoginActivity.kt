package com.cbsd.investment.ui.activity

import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.os.PersistableBundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.cbsd.investment.R
import com.gyf.immersionbar.ImmersionBar
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        initData()
        initListener()
    }



    fun initView() {
        ImmersionBar.with(this)
            .statusBarDarkFont(true, 0.2f)
            .navigationBarColor(R.color.colorBlack)
            .init()
        setContentView(R.layout.activity_login)
    }

   fun initData() {

    }

     fun initListener() {
        loginbutton.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }

}