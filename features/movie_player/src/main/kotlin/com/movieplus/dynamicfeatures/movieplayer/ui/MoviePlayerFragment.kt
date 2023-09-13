package com.movieplus.dynamicfeatures.movieplayer.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DefaultDataSource
import com.google.android.exoplayer2.util.MimeTypes
import com.movieplus.app.MoviePlusApp
import com.movieplus.commons.ui.base.ViewBindingFragment
import com.movieplus.dynamicfeatures.movieplayer.databinding.FragmentMoviePlayerBinding
import com.movieplus.dynamicfeatures.movieplayer.di.DaggerMoviePlayerComponent

class MoviePlayerFragment :
    ViewBindingFragment<MoviePlayerViewModel, FragmentMoviePlayerBinding>(MoviePlayerViewModel::class) {

    private var exoPlayer: ExoPlayer? = null
    private val sampleVideoUrl = "http://storage.googleapis.com/exoplayer-test-media-0/BigBuckBunny_320x180.mp4"
    private val playerPositionKey = "KEY_PLAYER_POSITION"
    private val playerPlayKey = "KEY_PLAYER_PLAY_WHEN_READY"

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
        preparePlayer()
    }

    //region private functions

    private fun preparePlayer() {
        exoPlayer = ExoPlayer.Builder(
            requireContext()
        ).build()
        val mediaItem = MediaItem.Builder()
            .setUri(sampleVideoUrl)
            .setMimeType(MimeTypes.APPLICATION_MP4)
            .build()
        val mediaSource = ProgressiveMediaSource.Factory(
            DefaultDataSource.Factory(requireContext())
        ).createMediaSource(mediaItem)

        exoPlayer?.apply {
            setMediaSource(mediaSource)
            playWhenReady = true
            seekTo(0, 0L)
            prepare()
        }.also {
            binding.playerView.player = it
        }
        exoPlayer?.play()
    }

    private fun releasePlayer() {
    }

    override fun onPause() {
        super.onPause()
        exoPlayer?.pause()
    }

    override fun onResume() {
        super.onResume()
        exoPlayer?.play()
    }

    override fun onDestroy() {
        super.onDestroy()
        exoPlayer?.stop()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        exoPlayer?.contentPosition?.let {
            outState.putLong(playerPositionKey, it)
        }
        exoPlayer?.playWhenReady?.let {
            outState.putBoolean(playerPlayKey, it)
        }
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        savedInstanceState?.let {
            exoPlayer?.seekTo(it.getLong(playerPositionKey))
            exoPlayer?.playWhenReady = it.getBoolean(playerPlayKey)
        }
    }

    //endregion
}
