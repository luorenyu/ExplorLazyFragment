package androidx.viewpager2.integration.testapp

import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import com.bumptech.glide.Glide

class LazyFragment : BaseLazyFragment() {
    companion object {
        fun create(position: Int, tag: String): LazyFragment {
            val fragment = LazyFragment()
            fragment.arguments = bundleOf(Pair("p", position.toString()), Pair("TAG", tag))
            return fragment
        }
    }

    private var tvNum: TextView? = null
    private var ivPic: ImageView? = null

    override fun layoutId(): Int {
        return R.layout.fragment_lazy
    }

    override fun initData() {
        val position = arguments?.getString("p").toString()

        tvNum?.text = position
        val url = if (position.toInt() >= 5) {
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1588358271534&di=8214ee327f017ad4f22e50106f75d993&imgtype=0&src=http%3A%2F%2Fattachments.gfan.com%2Fforum%2Fattachments2%2Fday_110317%2F1103171814794ace68f8b856a8.jpg"
        } else {
            "https://5b0988e595225.cdn.sohucs.com/images/20181006/082c026e3c574b6487ef5230bada0221.jpeg"
        }
        ivPic?.let {
            Glide.with(it)
                .load(url)
                .into(it)
        }
    }

    override fun initView() {
        tvNum = view?.findViewById<TextView>(R.id.text)
        ivPic = view?.findViewById<ImageView>(R.id.image)
    }
}