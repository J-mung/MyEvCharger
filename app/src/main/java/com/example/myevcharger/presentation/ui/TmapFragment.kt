package com.example.myevcharger.presentation.ui

import android.content.Context
import android.graphics.PointF
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.example.myevcharger.R
import com.example.myevcharger.databinding.FragmentTmapBinding
import com.example.myevcharger.presentation.MainActivity
import com.example.myevcharger.presentation.MainViewModel
import com.example.myevcharger.presentation.base.BaseFragment
import com.skt.tmap.TMapPoint
import com.skt.tmap.TMapView
import com.skt.tmap.TMapView.OnClickListenerCallback
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class TmapFragment : BaseFragment<FragmentTmapBinding>(R.layout.fragment_tmap) {
    private val mainViewModel: MainViewModel by activityViewModels()
    lateinit var mainActivity : MainActivity

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val container: FrameLayout = view.findViewById(R.id.tmapViewContainer)
        val tMapView = TMapView(mainActivity)
        container.addView(tMapView)
        tMapView.setSKTMapApiKey("l7xxceab1fa78f224a10afff3c2ad8e55890")
        tMapView.setOnMapReadyListener {

        }

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        mainActivity = context as MainActivity
    }
}