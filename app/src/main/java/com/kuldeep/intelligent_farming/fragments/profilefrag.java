package com.kuldeep.intelligent_farming.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import com.kuldeep.intelligent_farming.Pojo_classes.farmerPojo;
import com.kuldeep.intelligent_farming.R;

import static android.content.ContentValues.TAG;
import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link profilefrag.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link profilefrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class profilefrag extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private EditText pusername,pmobile,pemail;
    private RadioGroup pradioSexGroup;
    private RadioButton pradiomale,pradiofemale;


    private OnFragmentInteractionListener mListener;

    public profilefrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment profilefrag.
     */
    // TODO: Rename and change types and number of parameters
    public static profilefrag newInstance(String param1, String param2) {
        profilefrag fragment = new profilefrag();
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
        return inflater.inflate(R.layout.fragment_profilefrag, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        pusername=(EditText)view.findViewById(R.id.p_username);
        pmobile=(EditText)view.findViewById(R.id.p_mobile);
        pemail=(EditText)view.findViewById(R.id.p_email);

        pradioSexGroup = (RadioGroup)view.findViewById(R.id.radioSex);
        pradiomale = (RadioButton)view.findViewById(R.id.radioMale);
        pradiofemale = (RadioButton)view.findViewById(R.id.radioFemale);

        SharedPreferences sharedPref = getContext().getSharedPreferences("farmingSharedPreference", MODE_PRIVATE);


        pusername.setText(sharedPref.getString("name","farmer name"));
        pmobile.setText(sharedPref.getString("mobile","9999999999"));
        pemail.setText(sharedPref.getString("email","farmer_email@gmail.com"));
        if(((sharedPref.getString("name","farmer name")).equals("Male")))
            pradiomale.setChecked(true);
        else
            pradiofemale.setChecked(true);

       /* FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();


        mDatabase = FirebaseDatabase.getInstance().getReference("farmer");

        mDatabase.child(firebaseUser.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Log.d(TAG, dataSnapshot.toString());

                farmerPojo fp = dataSnapshot.getValue(farmerPojo.class);
                if(fp!=null)
                {
                    pusername.setText(fp.getFname());
                    pmobile.setText(fp.getMobile());
                    pemail.setText(fp.getEmail());
                    pdob.setText(fp.getDob());
                    ppin.setText(fp.getPincode());
                }
                else
                    Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

*/



    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
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
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
