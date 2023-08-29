package com.movieplus.commons.ui.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

interface BaseFragmentType<VM : ViewModel, Binding : ViewBinding> {

    val binding: Binding
    val viewModel: VM
    fun initView()
    fun initViewBinding(inflater: LayoutInflater, container: ViewGroup?): Binding
    fun observeEvents()
}
