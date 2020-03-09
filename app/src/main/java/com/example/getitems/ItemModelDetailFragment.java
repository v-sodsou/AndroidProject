package com.example.getitems;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.getitems.models.ItemViewModel;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import androidx.fragment.app.Fragment;

/**
 * A fragment representing a single ItemModel detail screen.
 * This fragment is either contained in a {@link ItemModelListActivity}
 * in two-pane mode (on tablets) or a {@link ItemModelDetailActivity}
 * on handsets.
 */
public class ItemModelDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private ItemViewModel.ItemModel mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemModelDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = ItemViewModel.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.Name);

                // The id on the layout
                ImageView image = ((ImageView) activity.findViewById(R.id.itemmodel_URI));

                // Get the image from the drawable folder
                String uri = "@drawable/" + mItem.ImageURI;  // where myresource (without the extension) is the file
                int imageResource = getResources().getIdentifier(uri, "drawable", "com.example.getitems");
                Drawable res = getResources().getDrawable(imageResource);
                image.setImageDrawable(res);

            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.itemmodel_detail, container, false);

        // Show the item attributes as text in the layout.
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.ItemDetails_NameValue)).setText(mItem.Name);
            ((TextView) rootView.findViewById(R.id.ItemDetails_DescriptionValue)).setText(mItem.Description);
            ((TextView) rootView.findViewById(R.id.ItemDetails_RangeValue)).setText(String.valueOf(mItem.Range));
            ((TextView) rootView.findViewById(R.id.ItemDetails_ValueValue)).setText(String.valueOf(mItem.Value));
            ((TextView) rootView.findViewById(R.id.ItemDetails_DamageValue)).setText(String.valueOf(mItem.Damage));
        }

        return rootView;
    }
}