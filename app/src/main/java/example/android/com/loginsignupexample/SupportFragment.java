package example.android.com.loginsignupexample;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class SupportFragment extends Fragment {


    private Button bookAnAuto;
    private Button sendAnAlert;

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_support, container, false);
        return view;
    }
}