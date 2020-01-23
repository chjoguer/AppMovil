package co.quindio.sena.navigationdrawerejemplo.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import co.quindio.sena.navigationdrawerejemplo.R;
import co.quindio.sena.navigationdrawerejemplo.adapters.PersonajesAdapter;
import co.quindio.sena.navigationdrawerejemplo.clases.Mascota;
import co.quindio.sena.navigationdrawerejemplo.clases.PersonajeVo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ListaAdoptadoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ListaAdoptadoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListaAdoptadoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button entry;

    private OnFragmentInteractionListener mListener;

    RecyclerView recyclerPersonajes;
    ArrayList<Mascota> listaPersonaje;

    public ListaAdoptadoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListaAdoptadoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListaAdoptadoFragment newInstance(String param1, String param2) {
        ListaAdoptadoFragment fragment = new ListaAdoptadoFragment();
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

    private void getPosts(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8787/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GetMascotas jsonPlaceHolderApi = retrofit.create(GetMascotas.class);

        Call<List<Mascota>> call = jsonPlaceHolderApi.getMascotas();

        call.enqueue(new Callback<List<Mascota>>() {
            @Override
            public void onResponse(Call<List<Mascota>> call, Response<List<Mascota>> response) {

                if(!response.isSuccessful()){
                    return;
                }

                List<Mascota> postsList = response.body();

                for(Mascota post: postsList){
                    String content = "";
                    content += post.getNombre();

                    listaPersonaje.add(new Mascota(post.getNombre(),post.getDescripcion(),R.drawable.perro4));
                 //   Toast.makeText(getContext(),"Codigo: "+post.getNombre(),Toast.LENGTH_SHORT).show();

                }
                PersonajesAdapter adapter=new PersonajesAdapter(listaPersonaje);
                adapter.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getContext(),"Abriendo prefil del dueño",Toast.LENGTH_SHORT).show();

                        //setContentView(R.layout.facebook);
                        //FACEBOOK
                        Uri uri = Uri.parse("https://www.facebook.com/groups/2205041203140120/");
                        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                        try{
                            startActivity(intent);
                        }catch(Exception e){
                            e.printStackTrace();
                        }



                        Log.v("EditText", "whatsaap!!");


                    }
                });
                recyclerPersonajes.setAdapter(adapter);


            }

            @Override
            public void onFailure(Call<List<Mascota>> call, Throwable t) {
                Toast.makeText(getContext(),t.getMessage(),Toast.LENGTH_SHORT).show();


            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista=inflater.inflate(R.layout.fragment_lista_personajes, container, false);

        listaPersonaje=new ArrayList<>();
        recyclerPersonajes= (RecyclerView) vista.findViewById(R.id.recyclerId);
        recyclerPersonajes.setLayoutManager(new LinearLayoutManager(getContext()));


        //llenarLista();
        getPosts();



        return vista;
    }

    private void llenarLista(String nombre) {
        listaPersonaje.add(new Mascota(nombre,"Perrita en adopción jugetona le gusta morder las medias para que jueguen con ella",R.drawable.perro1));
        //listaPersonaje.add(new Mascota(nombre,"Perro en adopción muy bien educado ideal para cuidar la casa",R.drawable.perro2));
       // listaPersonaje.add(new Mascota(nombre,"Perro para la compañía de niñios demasiado cariñoso y juguetón",R.drawable.perro3));
     //   listaPersonaje.add(new Mascota(nombre,"Perrita dormilona le gusta llamar la atención llorando cuando no la miran",R.drawable.perro4));
   //     listaPersonaje.add(new Mascota(nombre,"Perrita en adopción muy cariñosa siempre le gusta pasar con los dueños ",R.drawable.pug));

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
