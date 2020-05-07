package androidx.viewpager2.integration.testapp

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

class LifeCycleFragment : Fragment() {
    companion object {
        fun create(position: Int, tag: String): LifeCycleFragment {
            val fragment = LifeCycleFragment()
            fragment.arguments = bundleOf(Pair("p", position), Pair("TAG", tag))
            return fragment
        }
    }

    var position: String = ""
    private var mTag: String = ""


    override fun onAttach(context: Context) {
        if (position == "") {
            position = arguments?.getInt("p").toString()
            mTag = arguments?.getString("TAG").toString()
        }
        super.onAttach(context)
        Log.d(mTag, "Fragment${position}onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(mTag, "Fragment${position}onCreate")
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d(mTag, "Fragment${position}onActivityCreated")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(mTag, "Fragment${position}onViewCreated")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(mTag, "Fragment${position}onCreateView")
        val tv = TextView(activity).apply {
            text = position
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            textSize = 100f
            typeface = Typeface.DEFAULT_BOLD
            gravity = Gravity.CENTER
        }
        container?.addView(tv)
        return tv
    }


    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        position = arguments?.getInt("p").toString()
        mTag = arguments?.getString("TAG").toString()
        Log.d(mTag, "Fragment${position}isVisibleToUser:$isVisibleToUser")
    }

    override fun onStart() {
        super.onStart()
        Log.d(mTag, "Fragment${position}onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(mTag, "Fragment${position}onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(mTag, "Fragment${position}onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(mTag, "Fragment${position}onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(mTag, "Fragment${position}onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(mTag, "Fragment${position}onDestroy")
    }
}