package com.app.mviarch.components.mvi.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.mviarch.components.mvi.ui.ViewIntent

abstract class BaseViewModel<I : ViewIntent, A : ViewAction, S : ViewState> : ViewModel() {

	protected val _state = MutableLiveData<S>()
	val state: LiveData<S> = _state

	final fun sendIntent(intent: I) {
		handleAction(intentToAction(intent))
	}

	protected abstract fun intentToAction(intent: I): A
	protected abstract fun handleAction(action: A)
}