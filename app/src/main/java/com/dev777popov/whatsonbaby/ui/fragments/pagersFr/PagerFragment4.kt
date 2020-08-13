package com.dev777popov.whatsonbaby.ui.fragments.pagersFr

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import android.text.InputType
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.dev777popov.whatsonbaby.R
import kotlinx.android.synthetic.main.activity_view_pager.*
import kotlinx.android.synthetic.main.fragment_pager4.*
import java.lang.StringBuilder
import java.text.SimpleDateFormat
import java.util.*
import javax.xml.datatype.DatatypeConstants.MONTHS


class PagerFragment4 : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pager4, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createDatePicker()
        imageMale.setOnClickListener { selectGender(imageMale) }
        imageFemale.setOnClickListener { selectGender(imageFemale) }
    }


    @SuppressLint("SimpleDateFormat")
    private fun createDatePicker() {
        textDateChild.setText(SimpleDateFormat("dd/MM/yyyy").format(System.currentTimeMillis()))
        textDateChild.inputType = InputType.TYPE_NULL
        textDateChild.setOnClickListener {
            openDatePicker()
        }
    }


    @SuppressLint("SetTextI18n", "SimpleDateFormat")
    private fun openDatePicker() {
        val myFormat = "dd/MM/yyyy"
        val sdf = SimpleDateFormat(myFormat)
        val cal = Calendar.getInstance()
        val date = sdf.parse(textDateChild.text.toString())
        cal.time = date

        val dateSetListener =
            DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                textDateChild.setText(sdf.format(cal.time))
            }
        context?.let {
            DatePickerDialog(
                it, dateSetListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
    }

    private fun selectGender(selectImage: ImageView) {
        imageMale.setImageDrawable(context?.getDrawable(R.drawable.ic_male))
        imageFemale.setImageDrawable(context?.getDrawable(R.drawable.ic_female))
        if (selectImage == imageMale) {
            imageMale.setImageDrawable(context?.getDrawable(R.drawable.ic_male_set))
        } else {
            imageFemale.setImageDrawable(context?.getDrawable(R.drawable.ic_female_set))
        }
    }

    companion object {

        fun newInstance(param1: String, param2: String) =
            PagerFragment4().apply {

            }
    }
}