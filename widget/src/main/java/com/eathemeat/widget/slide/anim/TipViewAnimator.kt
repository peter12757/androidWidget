package com.eathemeat.widget.slide.anim

import androidx.transition.Transition

/**
 * @author PeterXi
 * @date 2024/6/30 9:15
 */
interface TipViewAnimator {
    /**
     * create tip view custom  show/hide transitions
     */
    fun createTransition(): Transition?
}