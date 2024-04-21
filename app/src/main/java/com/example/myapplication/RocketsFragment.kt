package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.LaunchesRecyclerAdapter
import com.example.myapplication.adapter.RocketsRecyclerAdapter
import com.example.myapplication.entity.LaunchRocket
import com.example.myapplication.entity.Rocket

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RocketsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RocketsFragment : Fragment() {
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

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rockets: List<Rocket>  = listOf(
            Rocket(R.drawable.falconsat01,
                getString(R.string.rocket),
                getString(R.string.falcon_1),
                false
            ),

            Rocket(R.drawable.falcon09,
                getString(R.string.rocket),
                getString(R.string.falcon_9),
                true
            ),

            Rocket(R.drawable.demosat02,
                getString(R.string.rocket),
                getString(R.string.big_falcon),
                false
                )
        )


        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_rockets, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.rockets_fragment_recycler_view)
        recyclerView.adapter = context?.let { RocketsRecyclerAdapter(it, rockets) }
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
         * @return A new instance of fragment RocketsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RocketsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}