package com.tutorial.bnr.ditzlern.sunset

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class SunsetFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_sunset, container, false)
        return view
    }

    companion object {
        fun newInstance() = SunsetFragment()
    }
}