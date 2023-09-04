package com.movieplus.dynamicfeatures.movielist.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.movieplus.app.MoviePlusApp
import com.movieplus.commons.ui.base.ViewBindingFragment
import com.movieplus.dynamicfeatures.movielist.databinding.FragmentMovieListBinding
import com.movieplus.dynamicfeatures.movielist.di.DaggerMovieListComponent
import kotlinx.coroutines.launch

class MovieListFragment : ViewBindingFragment<MovieListViewModel, FragmentMovieListBinding>(MovieListViewModel::class) {

    override fun initViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentMovieListBinding.inflate(inflater, container, false)

    override fun initDI() {
        DaggerMovieListComponent
            .builder()
            .coreComponent(MoviePlusApp.coreComponent(requireContext()))
            .build()
            .inject(this)
    }

    override fun observeEvents() {
    }

    override fun initView() {
        uiScope.launch {
            val response = viewModel.popularMovie()
            println("ümit")
        }
    }

    //region private functions

    //endregion
}