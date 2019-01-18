package com.example.vladi.myapplication


import android.app.Fragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.CalendarView
import android.widget.CalendarView.OnDateChangeListener
import kotlinx.android.synthetic.main.calendar_fragment.*
import java.lang.StringBuilder


/**
 * A simple [Fragment] subclass.
 */
class CalendarFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater!!.inflate(R.layout.calendar_fragment, container, false)

        val cV1 = view.findViewById<CalendarView>(R.id.calendarView1)
        // Inflate the layout for this fragment
        cV1.setOnDateChangeListener(OnDateChangeListener { view, year, month, dayOfMonth ->

            val mYear = year
            val mMonth = month
            val mDay = dayOfMonth
            val sb = StringBuilder()
            sb.append(mDay).append(".").append(mMonth+1).append(".").append(mYear)
            var s = sb.toString()

            Log.d("dd", s);
            if(s == "20.6.2019")
                s = s+'\n' + '\n'+ "Начало приема документов"
            else if(s == "26.7.2019")
                s = s +'\n' + '\n' + "Завершение приема документов"
            else if(s == "3.8.2019")
                s = s +'\n' + '\n' + "Приказы о зачислении (80%)"
            else if(s == "8.8.2019")
                s = s +'\n' + '\n' + "Приказы о зачислении (100%)"
            dateText.text = s
        })
        return view


    }


}// Required empty public constructor
