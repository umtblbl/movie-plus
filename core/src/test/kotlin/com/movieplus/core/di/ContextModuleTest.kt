package com.movieplus.core.di

import android.app.Application
import com.movieplus.core.di.module.ContextModule
import com.movieplus.core.util.NetworkHeader
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class ContextModuleTest {

    @MockK(relaxed = true)
    lateinit var application: Application
    private lateinit var contextModule: ContextModule
    private lateinit var networkHeader: NetworkHeader

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        contextModule = ContextModule(application, networkHeader)
    }

    @Test
    fun verifyProvidedContext() {
        Assert.assertEquals(application, contextModule.provideContext())
    }
}
