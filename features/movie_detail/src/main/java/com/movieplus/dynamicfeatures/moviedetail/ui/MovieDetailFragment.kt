package com.movieplus.dynamicfeatures.moviedetail.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.movieplus.app.MoviePlusApp
import com.movieplus.commons.ui.base.ViewBindingFragment
import com.movieplus.dynamicfeatures.moviedetail.databinding.FragmentMovieDetailBinding
import com.movieplus.dynamicfeatures.moviedetail.di.DaggerMovieDetailComponent

class MovieDetailFragment : ViewBindingFragment<MovieDetailViewModel, FragmentMovieDetailBinding>(MovieDetailViewModel::class) {

    override fun initViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentMovieDetailBinding.inflate(inflater, container, false)

    override fun initDI() {
        DaggerMovieDetailComponent
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