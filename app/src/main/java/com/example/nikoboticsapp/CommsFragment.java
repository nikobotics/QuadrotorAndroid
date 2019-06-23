package com.example.nikoboticsapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CommsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CommsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CommsFragment extends Fragment {
  // TODO: Rename parameter arguments, choose names that match
  // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
  private static final String ARG_PARAM1 = "param1";
  private static final String ARG_PARAM2 = "param2";
  private static final String NO_BLUETOOTH = "bluetooth is not enabled";
  private static final String YES_BLUETOOTH = "bluetooth is enabled";
  private static final String NO_WIFI = "wifi is not enabled";
  private static final String YES_WIFI = "wifi is enabled";

  // TODO: Rename and change types of parameters
  private String mParam1;
  private String mParam2;

  private OnFragmentInteractionListener mListener;

  public CommsFragment() {
    // Required empty public constructor
  }

  /**
   * Use this factory method to create a new instance of
   * this fragment using the provided parameters.
   *
   * @param param1 Parameter 1.
   * @param param2 Parameter 2.
   * @return A new instance of fragment CommsFragment.
   */
  // TODO: Rename and change types and number of parameters
  public static CommsFragment newInstance(String param1, String param2) {
    CommsFragment fragment = new CommsFragment();
    Bundle args = new Bundle();
    args.putString(ARG_PARAM1, param1);
    args.putString(ARG_PARAM2, param2);
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
      mParam1 = getArguments().getString(ARG_PARAM1);
      mParam2 = getArguments().getString(ARG_PARAM2);
    }
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_comms, container, false);

    // TODO: make listener to change these values on settings change instead of on viewCreate
    // retrieve if bluetooth/wifi has been enabled from settings and change text accordingly
    SharedPreferences sharedPreferences =
        (SharedPreferences) PreferenceManager.getDefaultSharedPreferences(this.getContext());
    boolean bluetooth_value = sharedPreferences.getBoolean("bluetooth", false);
    boolean wifi_value = sharedPreferences.getBoolean("wifi", false);

    // change textview items
    TextView bt = view.findViewById(R.id.bluetooth_active_text);
    TextView wifi = view.findViewById(R.id.wifi_activie_text);
    bt.setText(bluetooth_value ? YES_BLUETOOTH : NO_BLUETOOTH);
    wifi.setText(wifi_value ? YES_WIFI : NO_WIFI);

    return view;
  }

  // TODO: Rename method, update argument and hook method into UI event
  public void onButtonPressed() {
    if (mListener != null) {
      mListener.onFragmentInteraction();
    }
  }

  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
    /*if (context instanceof OnFragmentInteractionListener) {
      mListener = (OnFragmentInteractionListener) context;
    } else {
      throw new RuntimeException(context.toString()
          + " must implement OnFragmentInteractionListener");
    }*/
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
    // TODO: Update argument type and name
    void onFragmentInteraction();
  }
}
