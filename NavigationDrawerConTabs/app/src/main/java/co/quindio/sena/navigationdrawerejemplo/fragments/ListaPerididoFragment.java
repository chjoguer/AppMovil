package co.quindio.sena.navigationdrawerejemplo.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import co.quindio.sena.navigationdrawerejemplo.R;
import co.quindio.sena.navigationdrawerejemplo.adapters.PersonajesAdapter;
import co.quindio.sena.navigationdrawerejemplo.clases.Mascota;
import co.quindio.sena.navigationdrawerejemplo.clases.PersonajeVo;

public class ListaPerididoFragment extends  Fragment{

        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private static final String ARG_PARAM1 = "param1";
        private static final String ARG_PARAM2 = "param2";

        // TODO: Rename and change types of parameters
        private String mParam1;
        private String mParam2;

        private ListaPerididoFragment.OnFragmentInteractionListener mListener;

        RecyclerView recyclerPerdido;
        ArrayList<Mascota> listaPerdido;

        public ListaPerididoFragment() {
            // Required empty public constructor
        }

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ListaPerididoFragment.
         */
        // TODO: Rename and change types and number of parameters
        public static ListaPerididoFragment newInstance(String param1, String param2) {
            ListaPerididoFragment fragment = new ListaPerididoFragment();
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
            View vista=inflater.inflate(R.layout.fragment_lista_peridido, container, false);

            listaPerdido=new ArrayList<>();
            recyclerPerdido= (RecyclerView) vista.findViewById(R.id.recyclerId);
            recyclerPerdido.setLayoutManager(new LinearLayoutManager(getContext()));

            llenarLista();

            PersonajesAdapter adapter=new PersonajesAdapter(listaPerdido);
            recyclerPerdido.setAdapter(adapter);

            return vista;
        }

        private void llenarLista() {
            /*Aqui debe de hacerce el get*/
            listaPerdido.add(new Mascota("Vaquita", "Perrita doberman de color blanco con machas de color negro 4 meses de edad", R.drawable.perro1));
            listaPerdido.add(new Mascota("Pelusa", "Perro snowser de 2 anios de edad de color totalmente negro con machas de color cafe en la cara", R.drawable.perro2));
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
            if (context instanceof ListaPerididoFragment.OnFragmentInteractionListener) {
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
