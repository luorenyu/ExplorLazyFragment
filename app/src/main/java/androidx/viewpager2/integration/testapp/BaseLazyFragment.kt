package androidx.viewpager2.integration.testapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseLazyFragment : Fragment() {
    private var cacheView: View? = null
    private var loaded: Boolean = false


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (cacheView == null) {
            cacheView = inflater.inflate(layoutId(), container, false)
        }
        return cacheView
    }


    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        lazyLoad()
    }

    override fun onResume() {
        super.onResume()
        lazyLoad()

    }

    private fun lazyLoad() {
        if (userVisibleHint && !loaded && cacheView != null) {
            initView()
            initData()
            loaded = true
        }
    }

    abstract fun layoutId(): Int

    abstract fun initData()

    abstract fun initView()
}