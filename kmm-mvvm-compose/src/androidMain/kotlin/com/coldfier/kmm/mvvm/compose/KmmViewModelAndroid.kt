package com.coldfier.kmm.mvvm.compose

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.coldfier.kmm.mvvm.core.BaseViewModel
import com.coldfier.kmm.mvvm.core.factory.BaseViewModelFactory
import com.coldfier.kmm.mvvm.core.store.ViewModelStore

@Composable
actual inline fun <reified T: BaseViewModel> kmmViewModelInternal(
    key: String?,
    factory: BaseViewModelFactory,
    store: ViewModelStore?
): T = viewModel(factory = factory)