package co.quindio.sena.navigationdrawerejemplo.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

import co.quindio.sena.navigationdrawerejemplo.R;
import co.quindio.sena.navigationdrawerejemplo.clases.Mascota;

import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MascotaPerdidaFormularioFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MascotaPerdidaFormularioFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MascotaPerdidaFormularioFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ArrayList<Mascota> mascotasPerdidas;
    ImageView foto_gallery;
    private static final int PICK_IMAGE = 100;
    Uri imageUri;
    private OnFragmentInteractionListener mListener;

    public MascotaPerdidaFormularioFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MascotaPerdidaFormularioFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MascotaPerdidaFormularioFragment newInstance(String param1, String param2) {
        MascotaPerdidaFormularioFragment fragment = new MascotaPerdidaFormularioFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    private void openGallery(){
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    public void registratMascotaPerdida(View view){
        Button mButton = (Button)view.findViewById(R.id.registar);
        final EditText nombre   = (EditText)view.findViewById(R.id.nombre);
        final EditText raza   = (EditText)view.findViewById(R.id.raza);
        final EditText enAdopcion   = (EditText)view.findViewById(R.id.perdido);
        final EditText descripcion   = (EditText)view.findViewById(R.id.descripcion);
        final ImageView imgFile   = (ImageView) view.findViewById(R.id.image);

        mButton.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        Log.v("EditText", nombre.getText().toString());
                        Log.v("EditText", raza.getText().toString());
                        Log.v("EditText", enAdopcion.getText().toString());
                        Log.v("EditText", descripcion.getText().toString());

                        mascotasPerdidas.add(new Mascota(nombre.getText().toString(),descripcion.getText().toString(),imgFile.getId()));
                        Log.v("EditText", mascotasPerdidas.toString());
                        Toast.makeText(getContext(),"Se ha registrado correctamente...",Toast.LENGTH_SHORT).show();

                    }
                });

    }
    public void limpiarRegistro(View view){
        Button limpiar = (Button)view.findViewById(R.id.limpiar);
        final EditText nombre   = (EditText)view.findViewById(R.id.nombre);
        final EditText raza   = (EditText)view.findViewById(R.id.raza);
        final EditText enAdopcion   = (EditText)view.findViewById(R.id.perdido);
        final EditText descripcion   = (EditText)view.findViewById(R.id.descripcion);
        final ImageView imgFile   = (ImageView) view.findViewById(R.id.image);
        limpiar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        nombre.setText("Nombre");
                        raza.setText("Raza");
                        enAdopcion.setText("Esta Perdido");
                        descripcion.setText("Descripción");
                        imgFile.setImageResource(R.drawable.ic_menu_gallery);
                    }
                });


        }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
         mascotasPerdidas= new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_perdidaform, container, false);
        foto_gallery = (ImageView) view.findViewById(R.id.image);
        foto_gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });
        registratMascotaPerdida(view);
        limpiarRegistro(view);

        return view;
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
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode == RESULT_OK && requestCode == PICK_IMAGE){
            imageUri = data.getData();
            foto_gallery.setImageURI(imageUri);
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
