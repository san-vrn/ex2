package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.LaunchesRecyclerAdapter
import com.example.myapplication.entity.LaunchRocket

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LaunchesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LaunchesFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rockets: List<LaunchRocket>  = listOf(
            LaunchRocket(
                R.drawable.crs,
                getString(R.string.launch),
                getString(R.string.starlink_2),
                getString(R.string.CCAES_SLC_40),
                getString(R.string.date)
            ),
            LaunchRocket(
                R.drawable.falcon9,
                getString(R.string.launch),
                getString(R.string.demosat),
                getString(R.string.CCAES_SLC_40),
                getString(R.string.date)
            ),
            LaunchRocket(R.drawable.demosat02,
                getString(R.string.launch),
                getString(R.string.falcon_9_test),
                getString(R.string.CCAES_SLC_40),
                getString(R.string.date)
                ),
            LaunchRocket(R.drawable.crs,
                getString(R.string.launch),
                getString(R.string.crs2),
                getString(R.string.CCAES_SLC_40),
                getString(R.string.date))
        )
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_launches, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.launches_recycler_view)
        recyclerView.adapter = context?.let { LaunchesRecyclerAdapter(it, rockets) }
        recyclerView.layoutManager = LinearLayoutManager(context)
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LaunchesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LaunchesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}