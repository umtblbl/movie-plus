package com.movieplus.dynamicfeatures.movielist.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.movieplus.app.MoviePlusApp
import com.movieplus.commons.ui.adapter.RecyclerViewBasicAdapter
import com.movieplus.commons.ui.base.ViewBindingFragment
import com.movieplus.commons.ui.extension.imageUrl
import com.movieplus.commons.ui.extension.state
import com.movieplus.core.Configs
import com.movieplus.core.util.MediatorLoadType
import com.movieplus.dynamicfeatures.movielist.databinding.FragmentMovieListBinding
import com.movieplus.dynamicfeatures.movielist.databinding.ItemMovieBinding
import com.movieplus.dynamicfeatures.movielist.di.DaggerMovieListComponent
import com.movieplus.dynamicfeatures.movielist.model.MovieModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieListFragment :
    ViewBindingFragment<MovieListViewModel, FragmentMovieListBinding>(MovieListViewModel::class) {

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

    private var movieModelAdapter: RecyclerViewBasicAdapter<MovieModel>? = null
    private var topRatedAdapter: RecyclerViewBasicAdapter<MovieModel>? = null

    override fun observeEvents() {
        viewModel.errorResponse.observe(this) {}
        viewModel.popularMovieData.observe(this) {
            it?.let {
                movieModelAdapter?.list = it
            }
        }
        viewModel.topRatedData.observe(this) {
            it?.let {
                topRatedAdapter?.list = it
            }
        }
    }

    override fun initView() {
        initPopularMovieRecyclerView()
        initTopRatedRecyclerView()
        uiScope.launch {
            viewModel.popularMovie(
                loadType = MediatorLoadType.Initial
            )
            viewModel.topRated(
                loadType = MediatorLoadType.Initial
            )
            viewModel.movieGenres()
        }
    }

    //region private functions

    private fun initPopularMovieRecyclerView() {
        movieModelAdapter = RecyclerViewBasicAdapter<MovieModel>(
            viewBindingHandler = {
                ItemMovieBinding.inflate(
                    LayoutInflater.from(context),
                    binding.root,
                    false
                )
            },
            bindHandler = { viewBinding, item ->
                (viewBinding as? ItemMovieBinding)
                    ?.apply {
                        item ?: return@apply
                        textViewTitle.text = item.title
                        imageViewMovie.imageUrl("${Configs.Network.IMAGE_URL}${item.posterPath}")
                    }
            }
        ).also {
            binding.recyclerViewPopularMovie.adapter = it
        }

        binding.recyclerViewPopularMovie.state(
            isBottomHandler = {
                uiScope.launch(Dispatchers.IO) {
                    viewModel.popularMovie(
                        loadType = MediatorLoadType.Load
                    )
                }
            }
        )
    }

    private fun initTopRatedRecyclerView() {
        topRatedAdapter = RecyclerViewBasicAdapter<MovieModel>(
            viewBindingHandler = {
                ItemMovieBinding.inflate(
                    LayoutInflater.from(context),
                    binding.root,
                    false
                )
            },
            bindHandler = { viewBinding, item ->
                (viewBinding as? ItemMovieBinding)
                    ?.apply {
                        item ?: return@apply
                        textViewTitle.text = item.title
                        imageViewMovie.imageUrl("${Configs.Network.IMAGE_URL}${item.posterPath}")
                    }
            }
        ).also {
            binding.recyclerViewTopRated.adapter = it
        }

        binding.recyclerViewTopRated.state(
            isBottomHandler = {
                uiScope.launch(Dispatchers.IO) {
                    viewModel.topRated(
                        loadType = MediatorLoadType.Load
                    )
                }
            }
        )
    }

    //endregion
}