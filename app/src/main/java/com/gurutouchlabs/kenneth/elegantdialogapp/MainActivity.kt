package com.gurutouchlabs.kenneth.elegantdialogapp

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import jp.co.cyberagent.android.tabanimation.*
import kotlinx.android.synthetic.main.activity_main.*
/**
 * Created by Kenneth Waweru on 21/10/2019.
 */
class MainActivity : AppCompatActivity() {
    private var adapter: FragmentStateAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpViewPager()
        setUpTabViewPager()
        viewPager.offscreenPageLimit = 2
    }

    private fun setUpViewPager() {
        val fragments = ArrayList<Fragment>()
        fragments.add(DefaultDialogFragment())
        fragments.add(CustomDialogFragment())
        adapter = object : FragmentStateAdapter(this) {
            override fun createFragment(position: Int): Fragment {
                return fragments[position]
            }

            override fun getItemCount(): Int {
                return fragments.size
            }
        }
        viewPager.adapter = adapter
    }

    private fun setUpTabViewPager() {
        val titles = ArrayList<String>()
        titles.add(resources.getString(R.string.default_dialog))
        titles.add(resources.getString(R.string.custom_dialog))
        val color = Color.DKGRAY
        tabLayout.setupAnimationTabWithViewPager(
            viewPager,
            animationInfo(color),
            SimpleTab.TEXT
        ) { tab, _, pos ->
            tab.text = titles[pos]
        }
    }

    private fun animationInfo(color: Int): ViewIdAnimationInfoSet =
        viewIdAnimationInfo {
            animateText<Float> {
                property(View.SCALE_X)
                startValue(TAB_UNSELECTED_SCALE)
                endValue(TAB_SELECTED_SCALE)
            }
            animateText<Float> {
                property(View.SCALE_Y)
                startValue(TAB_UNSELECTED_SCALE)
                endValue(TAB_SELECTED_SCALE)
            }
            animateText<Int> {
                property(
                    getter = { currentTextColor },
                    setter = { setTextColor(it) }
                )
                startValue(color)
                endValue { ContextCompat.getColor(it.context, R.color.colorAccent) }
            }
        }

    companion object {
        private const val TAB_SELECTED_SCALE = 1f
        private const val TAB_UNSELECTED_SCALE = 0.9f
    }

}
