package com.nide.tecom.util

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.nide.tecom.R
import timber.log.Timber

class OnScrollBottomSheetBehavior constructor(context: Context, attrs: AttributeSet) :
    BottomSheetBehavior<FrameLayout>(context, attrs) {

    private var statusBarHeight: Int = 0
    private var initialValue = -1

    init {
        val resId = context.resources.getIdentifier("status_bar_height", "dimen", "android")

        if (resId > 0) {
            statusBarHeight = context.resources.getDimensionPixelSize(resId)
        }


    }


    override fun layoutDependsOn(
        parent: CoordinatorLayout,
        child: FrameLayout,
        dependency: View
    ): Boolean {
        return dependency.id == R.id.behavior_dependency
    }


    override fun onDependentViewChanged(
        parent: CoordinatorLayout,
        child: FrameLayout,
        dependency: View
    ): Boolean {
        val dependencyLocation = IntArray(2)

//        dependency.getLocationInWindow(dependencyLocation)
//        Timber.i(" Behavior Statusbar: ${statusBarHeight}")
        if (initialValue < 0) {
            initialValue = dependency.y.toInt()
        }
        Timber.i("initvalue = $initialValue : ${dependency.y.toInt()}")

            if (dependency.y.toInt() >= initialValue) {
                Timber.i("condition true")
                if (state != STATE_EXPANDED) {
                    Timber.i("state expend")
                    state = STATE_EXPANDED
                }
            } else {
                state = STATE_HIDDEN
            }

        dependency.getLocationInWindow(dependencyLocation)


        return false

    }


}