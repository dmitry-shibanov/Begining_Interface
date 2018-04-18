package com.example.a123.aninterface;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ToolAboutFragment extends Fragment {

    private static final String ARG_TOOL_TYPE = "toolType";

    private ToolType mToolType;

    public static ToolAboutFragment newInstance(ToolType toolType) {
        final ToolAboutFragment fragment = new ToolAboutFragment();
        final Bundle args = new Bundle();
        args.putString(ARG_TOOL_TYPE, toolType.name());
        fragment.setArguments(args);
        return fragment;
    }

    public ToolAboutFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Bundle args = getArguments();
        if (args == null) {
            throw new IllegalStateException("Аргументы не установлены");
        }
        mToolType = ToolType.valueOf(args.getString(ARG_TOOL_TYPE));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.content_main, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.title);
        textView.setText(mToolType.getToolNameResourceId());
        textView = (TextView) rootView.findViewById(R.id.description);
        textView.setText(mToolType.getToolDescriptionResourceId());

        return rootView;
    }
}