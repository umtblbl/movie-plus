package com.movieplus.dynamicfeatures.home.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.movieplus.app.MoviePlusApp
import com.movieplus.commons.ui.base.ViewBindingFragment
import com.movieplus.dynamicfeatures.home.databinding.FragmentHomeBinding
import com.movieplus.dynamicfeatures.home.di.DaggerHomeComponent

class HomeFragment : ViewBindingFragment<HomeViewModel, FragmentHomeBinding>(HomeViewModel::class) {

    override fun initViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentHomeBinding.inflate(inflater, container, false)

    override fun initDI() {
        DaggerHomeComponent
            .builder()
            .coreComponent(MoviePlusApp.coreComponent(requireContext()))
            .build()
            .inject(this)
    }

    override fun observeEvents() {
    }

    override fun initView() {
    }

    //region private functions

    //endregion
}
