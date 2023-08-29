package com.movieplus.dynamicfeatures.movieplayer.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.movieplus.app.MoviePlusApp
import com.movieplus.commons.ui.base.ViewBindingFragment
import com.movieplus.dynamicfeatures.movieplayer.databinding.FragmentMoviePlayerBinding
import com.movieplus.dynamicfeatures.movieplayer.di.DaggerMoviePlayerComponent

class MoviePlayerFragment : ViewBindingFragment<MoviePlayerViewModel, FragmentMoviePlayerBinding>(MoviePlayerViewModel::class) {

    override fun initViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentMoviePlayerBinding.inflate(inflater, container, false)

    override fun initDI() {
        DaggerMoviePlayerComponent
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