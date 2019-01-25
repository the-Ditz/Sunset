package com.tutorial.bnr.ditzlern.sunset

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class SunsetActivity : SingleFragmentActivity() {

    override fun createFragment() = SunsetFragment.newInstance()
}
