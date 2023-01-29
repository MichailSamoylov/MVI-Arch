package com.app.mviarch.components.extension

import androidx.recyclerview.widget.RecyclerView

inline fun RecyclerView.setOnScrollListener(crossinline listenerAction: () -> Unit) {
	this.addOnScrollListener(
		object : RecyclerView.OnScrollListener() {
			override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
				super.onScrollStateChanged(recyclerView, newState)
				if (!recyclerView.canScrollVertically(1) && newState == RecyclerView.SCROLL_STATE_IDLE) {
					listenerAction()
				}
			}
		}
	)
}
