package com.movieplus.dynamicfeatures.moviedetail.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.movieplus.app.MoviePlusApp
import com.movieplus.commons.ui.base.ViewBindingFragment
import com.movieplus.commons.ui.extension.imageUrl
import com.movieplus.core.Configs
import com.movieplus.dynamicfeatures.moviedetail.databinding.FragmentMovieDetailBinding
import com.movieplus.dynamicfeatures.moviedetail.di.DaggerMovieDetailComponent
import com.movieplus.dynamicfeatures.moviedetail.ui.MovieDetailFragmentDirections

class MovieDetailFragment :
    ViewBindingFragment<MovieDetailViewModel, FragmentMovieDetailBinding>(MovieDetailViewModel::class) {

    private val args: MovieDetailFragmentArgs by navArgs()

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
        with(binding) {
            textViewTitle.text = args.title
            textViewOverview.text = args.overView
            textViewDate.text = args.date
            imageViewPoster.imageUrl("${Configs.Network.IMAGE_URL}${args.posterPath}")
            textViewRate.text = args.vote
            imageViewPlay.setOnClickListener {
                findNavController().navigate(
                    MovieDetailFragmentDirections.actionMovieListToMoviePlay()
                )
            }
        }
    }

    //region private functions

    //endregion
}