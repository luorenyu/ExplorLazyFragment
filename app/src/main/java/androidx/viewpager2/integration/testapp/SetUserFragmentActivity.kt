package androidx.viewpager2.integration.testapp

import android.app.Activity
import android.content.Context
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.integration.testapp.R


class SetUserFragmentActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewpager)
        findViewById<ViewPager>(R.id.view_pager).apply {
            adapter = Adapter(supportFragmentManager)
        }
    }

    class Adapter(fa: FragmentManager) : FragmentPagerAdapter(fa) {

        override fun getCount(): Int {
            return 10
        }

        override fun getItem(position: Int): Fragment =
//            LifeCycleFragment.create(position, "SetUse")
            LazyFragment.create(position, "SetUse")
    }

}