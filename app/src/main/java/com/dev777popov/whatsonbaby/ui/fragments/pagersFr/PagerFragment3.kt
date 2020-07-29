package com.dev777popov.whatsonbaby.ui.fragments.pagersFr

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dev777popov.whatsonbaby.R


class PagerFragment3 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pager3, container, false)
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            PagerFragment3().apply {

            }
    }
}