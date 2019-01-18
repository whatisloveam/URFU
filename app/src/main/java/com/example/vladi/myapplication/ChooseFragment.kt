package com.example.vladi.myapplication


import android.app.Fragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import kotlinx.android.synthetic.main.choose_fragment.*


/**
 * A simple [Fragment] subclass.
 */
class ChooseFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater!!.inflate(R.layout.choose_fragment, container, false)
        val spinner = view.findViewById<Spinner>(R.id.form_of_study_spinner)
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            activity,
            R.array.forms_of_study,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }

        val spinner2 = view.findViewById<Spinner>(R.id.is_cash_study_spinner)
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            activity,
            R.array.is_cash_study,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner2.adapter = adapter
        }

        val spinner3 = view.findViewById<Spinner>(R.id.age_of_study_spinner)
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            activity,
            R.array.age_of_study,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner3.adapter = adapter
        }

        val sub_btn = view?.findViewById<Button>(R.id.submit_btn)
        var outAr = arrayListOf<Recor>()


        sub_btn?.setOnClickListener {

            var rus_b = rusa_b.text.toString().toInt()
            var mat_b = mata_b.text.toString().toInt()
            var inf_b = infa_b.text.toString().toInt()
            var formOb = spinner.selectedItemId
            var iscash = spinner2.selectedItemId
            var level = spinner3.selectedItemId

            var minCash = min_cash.text.toString().toInt()
            var maxCash = max_cash.text.toString().toInt()

            var sum = rus_b + mat_b + inf_b
            Log.d("kek", formOb.toString())
            var e = Recor()
            e.ballsR = 0
            e.nameR = ""
            e.idR = ""
            e.levelR = ""
            outAr.clear()
            if(rus_b < 36 || mat_b < 55 || inf_b < 55)
            {
                //ban
            }
            else
            {

                for (i in 0..10)
                {
                    var r = Recor()
                    if((MyData.formaOb[i] and (1 shl (2-formOb.toInt())) != 0) and (MyData.levelAr[i] == level.toInt()))
                    {
                        if(iscash.toInt() == 0) // budget
                        {
                            if(sum >= MyData.ballsfree[i])
                            {
                                r.cashR = 0
                                r.formObR = MyData.formaOb[i]
                                r.idR = MyData.numberAr[i]
                                r.nameR = MyData.nameAr[i]
                                r.ballsR = MyData.ballsfree[i]
                                outAr.add(r)
                                Print(r)
                                Log.d("sos", outAr.last().nameR)
                                //Log.d("sos", outAr.toString())
                            }
                        }
                        else // platka
                        {

                            r.formObR = MyData.formaOb[i]
                            r.idR = MyData.numberAr[i]
                            r.nameR = MyData.nameAr[i]

                            if(sum >= 150)
                            {
                                if((sum >= MyData.ballssaleAr[i]))
                                {
                                    if((minCash <= MyData.pricesale[i]) and (maxCash >= MyData.pricesale[i])) {
                                        r.ballsR = MyData.ballssaleAr[i]
                                        r.cashR = MyData.pricesale[i]
                                        outAr.add(r)
                                        Print(r)
                                        Log.d("sos", outAr.last().nameR)
                                    }
                                }
                                else
                                {
                                    if((minCash <= MyData.pricegatherAr[i]) and (maxCash >= MyData.pricegatherAr[i]) and (sum >= MyData.ballspayAr[i])) {
                                        r.ballsR = MyData.ballspayAr[i]
                                        r.cashR = MyData.pricegatherAr[i]
                                        outAr.add(r)
                                        Print(r)
                                        Log.d("sos", outAr.last().nameR)
                                    }
                                }
                            }
                            else
                            {
                                if(sum >= MyData.ballspayAr[i])
                                {
                                    if((minCash <= MyData.pricelessAr[i]) and (maxCash >= MyData.pricelessAr[i])) {
                                        r.ballsR = MyData.ballspayAr[i]
                                        r.cashR = MyData.pricelessAr[i]
                                        outAr.add(r)
                                        Print(r)
                                        Log.d("sos", outAr.last().nameR)
                                    }

                                }
                                else
                                {
                                    //ban
                                }
                            }
                        }

                    }
                    else
                    {
                        //ban
                    }
                }



                //    Log.d("pppp", outAr[0].nameR)
                //Log.d("pppp", outAr[1].nameR)
                //Log.d("pppp", outAr[2].nameR)
                //Log.d("pppp", outAr[3].nameR)

                var adapter = MyAdapter(activity, outAr)
                list?.adapter = adapter



            }
        }




        return view
    }
    fun Append()
    {

    }
    public fun Print(ar: Recor)
    {

        Log.d("sos", ar.idR.toString() + " " + ar.nameR.toString() + " " + ar.formObR.toString() + " " + ar.ballsR.toString())
    }

}// Required empty public constructor
