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
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2

class ViewPager2FragmentActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewpager2)
        findViewById<ViewPager2>(R.id.view_pager).apply {
            adapter = Adapter(this@ViewPager2FragmentActivity)
//            offscreenPageLimit=2
        }
    }

    class Adapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {

        override fun getItemCount(): Int {
            return 10
        }

        override fun createFragment(position: Int): Fragment =
//            LifeCycleFragment.create(position, "ViewPager2")
            LazyFragment.create(position, "ViewPager2")

    }


}