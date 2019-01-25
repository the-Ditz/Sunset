package com.tutorial.bnr.ditzlern.sunset

import android.animation.AnimatorSet
import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.os.Bundle

import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.view.animation.AccelerateInterpolator

private const val SUNSET_DURATION = 3000L

class SunsetFragment : Fragment() {

    private lateinit var sceneView: View
    private lateinit var sunView: View
    private lateinit var skyView: View
    private val blueSkyColor: Int by lazy {
        ContextCompat.getColor(requireContext(), R.color.blue_sky)
    }
    private val sunsetSkyColor: Int by lazy {
        ContextCompat.getColor(requireContext(), R.color.sunset_sky)
    }
    private val nightSkyColor: Int by lazy {
        ContextCompat.getColor(requireContext(), R.color.night_sky)
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_sunset, container, false)

        sceneView = view
        sunView = view.findViewById(R.id.sun)
        skyView = view.findViewById(R.id.sky)

        sceneView.setOnClickListener{
            startAnimation()
        }

        return view
    }

    companion object {
        fun newInstance() = SunsetFragment()
    }

    private fun startAnimation(){
        val sunYStart = sunView.top.toFloat()
        val sunYEnd = skyView.height.toFloat()

        val heightAnimator = ObjectAnimator
                .ofFloat(sunView, "y", sunYStart, sunYEnd)
                .setDuration(SUNSET_DURATION)

        heightAnimator.interpolator = AccelerateInterpolator()

        val sunsetSkyAnimator = ObjectAnimator
                .ofInt(skyView, "backgroundColor", blueSkyColor, sunsetSkyColor)
                .setDuration(SUNSET_DURATION)
        sunsetSkyAnimator.setEvaluator(ArgbEvaluator())

        val nightSkyAnimator = ObjectAnimator
                .ofInt(skyView, "backgroundColor", sunsetSkyColor, nightSkyColor)
                .setDuration(SUNSET_DURATION)
        nightSkyAnimator.setEvaluator(ArgbEvaluator())


        val animatorSet = AnimatorSet()
        animatorSet.play(heightAnimator)
                .with(sunsetSkyAnimator)
                .before(nightSkyAnimator)
        animatorSet.start()
    }
}