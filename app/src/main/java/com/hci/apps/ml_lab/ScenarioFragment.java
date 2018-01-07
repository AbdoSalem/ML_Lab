package com.hci.apps.ml_lab;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ScenarioFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ScenarioFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ScenarioFragment extends Fragment {

    private static final String ARG_SCENARIO_ID = "ARG_SCENARIO_ID";
    private static final String ARG_GESTURE = "ARG_GESTURE";
    private static final String TAG = ScenarioFragment.class.getSimpleName();


    private int scenarioID;
    private int gestureEnabled;

    private OnFragmentInteractionListener mListener;

    public ScenarioFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param scenarioID Parameter 1.
     * @param gestureEnabled Parameter 2.
     * @return A new instance of fragment ScenarioFragment.
     */

    public static ScenarioFragment newInstance(int scenarioID, int gestureEnabled) {
        ScenarioFragment fragment = new ScenarioFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SCENARIO_ID, scenarioID);
        args.putInt(ARG_GESTURE, gestureEnabled);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            scenarioID = getArguments().getInt(ARG_SCENARIO_ID);
            gestureEnabled = getArguments().getInt(ARG_GESTURE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_scenario, container, false);
        TextView scenarioDescription = (TextView)view.findViewById(R.id.tv_scenario_description);
        Log.d(TAG,"senario Id is "+scenarioID +" ::  gesture enabled is "+ gestureEnabled);
        scenarioDescription.setText(getResources().getStringArray(R.array.scenario_descriptions)[scenarioID *2+gestureEnabled]);
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {

        void onFragmentInteraction(Uri uri);
    }
}
