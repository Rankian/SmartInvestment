package com.cbsd.investment.ui.activity


import android.view.View
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import com.cbsd.investment.R
import com.cbsd.investment.ui.base.BaseActivity
import com.cbsd.investment.ui.fragment.HomeFragment
import com.cbsd.investment.ui.fragment.JobFragment
import com.cbsd.investment.ui.fragment.MeFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.include_title.*
import java.util.*

class MainActivity : BaseActivity() {
    private val fragments: MutableList<Fragment> =
        ArrayList()

    override fun setLayoutView(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        iv_include_title_back.visibility= View.GONE
        setTitleText("智慧招商")
        fragments.add(HomeFragment())
        fragments.add(JobFragment())
        fragments.add(MeFragment())

        val fm =
            supportFragmentManager.beginTransaction()
        for (i in fragments.indices) {
            fm.add(R.id.nav_host_fragment, fragments[i])
        }
        fm.commit()

        homeBottomRg.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group: RadioGroup, checkedId: Int ->
            for (i in 0 until group.childCount) {
                if (group.getChildAt(i).id == checkedId) {
                    when (i) {
                        0 -> switchFragment(0)
                        1 -> switchFragment(1)
                        2 -> switchFragment(2)
                    }
                }
            }
        })
        homeBottomRg.check(homeBottomRg.getChildAt(0).getId())


    }

    override fun initData() {

    }

    override fun initListener() {

    }
    private fun switchFragment(index: Int) {
        val fm =
            supportFragmentManager.beginTransaction()
        fm.hide(fragments[0]).hide(fragments[1]).hide(fragments[2])
        fm.show(fragments[index]).commit()
    }
}