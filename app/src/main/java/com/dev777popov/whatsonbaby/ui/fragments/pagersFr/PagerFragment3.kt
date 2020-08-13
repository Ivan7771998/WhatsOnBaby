package com.dev777popov.whatsonbaby.ui.fragments.pagersFr

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dev777popov.whatsonbaby.App
import com.dev777popov.whatsonbaby.App.Companion.getInstance
import com.dev777popov.whatsonbaby.App.Companion.sharedPref
import com.dev777popov.whatsonbaby.R
import com.dev777popov.whatsonbaby.SharedPref
import kotlinx.android.synthetic.main.fragment_pager3.*


class PagerFragment3 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pager3, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textNameChildText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                sharedPref?.setNameChild(textNameChildText.text.toString())
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

        })
        textNameMomText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                sharedPref?.setNameMom(textNameMomText.text.toString())
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            PagerFragment3().apply {

            }
    }

}