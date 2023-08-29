package com.movieplus.commons.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.movieplus.commons.di.ViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import javax.inject.Inject
import kotlin.reflect.KClass
import androidx.viewbinding.ViewBinding

abstract class ViewBindingFragment<VM : ViewModel, Binding : ViewBinding>(
    private val clazz: KClass<VM>
) : Fragment(), BaseFragmentType<VM, Binding> {

    @Inject
    internal lateinit var viewModelFactory: ViewModelFactory

    override val viewModel by lazy { ViewModelProvider(this, viewModelFactory).get(clazz.java) }

    override lateinit var binding: Binding

    private val job = Job()
    val uiScope = CoroutineScope(Dispatchers.Main + job)

    abstract override fun initViewBinding(inflater: LayoutInflater, container: ViewGroup?): Binding
    abstract fun initDI()
    abstract override fun observeEvents()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = initViewBinding(inflater, container)
        initDI()
        observeEvents()
        initView()
        return binding.root
    }

    override fun onDestroy() {
        job.cancel()
        super.onDestroy()
    }
}
