package com.example.vladi.myapplication

import android.app.Activity
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class MyAdapter(private val activity: Activity,
                    private val dataSource: ArrayList<Recor>) : BaseAdapter() {

    private class ViewHolder(row: View?) {
        var Tnum: TextView? = null
        var Tname: TextView? = null
        var Tball: TextView? = null
        var TformOb: TextView? = null

        init {
            this.Tnum = row?.findViewById<TextView>(R.id.Tnum)
            this.Tname = row?.findViewById<TextView>(R.id.Tname)
            this.Tball = row?.findViewById<TextView>(R.id.Tball)
            this.TformOb = row?.findViewById<TextView>(R.id.TformOb)
        }
    }



    //4
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Get view for row item

        val rowView: View?
        val viewHolder: ViewHolder
        if (convertView == null) {
            val inflater = activity?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            rowView = inflater.inflate(R.layout.my_item, null)
            viewHolder = ViewHolder(rowView)
            rowView?.tag = viewHolder
        } else {
            rowView = convertView
            viewHolder = rowView.tag as ViewHolder
        }


        //val rowView = inflater.inflate(R.layout.my_item, parent, false)


        val rec = dataSource[position]
        viewHolder.Tnum?.text = rec.idR
        viewHolder.Tname?.text = rec.nameR
        viewHolder.Tball?.text = rec.ballsR.toString()
        viewHolder.TformOb?.text = rec.formObR.toString()

        return rowView as View
    }


    override fun getItem(i: Int): Recor {
        return dataSource[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getCount(): Int {
        return dataSource.size
    }


}
