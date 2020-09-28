package id.ac.ui.cs.mobileprogramming.cahyanugraha.myWarcraft

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import junit.framework.Assert.assertEquals
import kotlinx.android.synthetic.main.activity_main.*
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.Request.method
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.runners.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class MainActivityUnitTest {
    @Mock
    lateinit var profileImageView: ImageView

    @Mock
    lateinit var profileImageShowButton: Button

    @Mock
    lateinit var profileImageCloseButton: Button


    @Test
    fun test_onClickProfileImageShowButton() {
        // Declare System Under Test
        val sut = MainActivity()

        sut.profileImageView = profileImageView
        sut.profileImageShowButton = profileImageShowButton
        sut.profileImageCloseButton = profileImageCloseButton

        sut.showImageView()

        verify(sut.profileImageView).setVisibility(View.VISIBLE)
        verify(sut.profileImageCloseButton).setVisibility(View.VISIBLE)
        verify(sut.profileImageShowButton).setVisibility(View.GONE)
    }

    @Test
    fun test_onClickProfileImageCloseButton() {
        // Declare System Under Test
        val sut = MainActivity()

        sut.profileImageView = profileImageView
        sut.profileImageShowButton = profileImageShowButton
        sut.profileImageCloseButton = profileImageCloseButton

        sut.closeImageView()

        verify(sut.profileImageView).setVisibility(View.GONE)
        verify(sut.profileImageCloseButton).setVisibility(View.GONE)
        verify(sut.profileImageShowButton).setVisibility(View.VISIBLE)
    }
}