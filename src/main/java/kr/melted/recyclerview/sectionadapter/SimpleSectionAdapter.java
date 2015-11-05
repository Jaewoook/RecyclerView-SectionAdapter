package kr.melted.recyclerview.sectionadapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by globalsmartkr on 2015. 11. 5..
 */
public class SimpleSectionAdapter<SECTION extends RecyclerView.ViewHolder, ITEM extends RecyclerView.ViewHolder>
        extends SectionAdapter<SimpleSectionAdapter.SimpleViewHolder, SimpleSectionAdapter.SimpleViewHolder> {


    private int itemLayoutRes, sectionLayoutRes;

    public SimpleSectionAdapter(int itemLayoutRes, int sectionLayoutRes) {
        this.itemLayoutRes = itemLayoutRes;
        this.sectionLayoutRes = sectionLayoutRes;
    }

    @Override
    public RecyclerView.ViewHolder onCreateSectionHolder(LayoutInflater inflater, ViewGroup parent) {
        return null;
    }

    @Override
    public RecyclerView.ViewHolder onCreateItemHolder(LayoutInflater inflater, ViewGroup parent) {
        return null;
    }

    @Override
    public boolean isSectionHeaderView() {
        return false;
    }

    @Override
    public void onBindItemView(SimpleViewHolder holder, int position) {

    }

    @Override
    public void onBindSectionHeaderView(SimpleViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void setItemLayoutResource(int resource) {
        this.itemLayoutRes = resource;
    }

    public void setSectionLayoutResource(int resource) {
        this.sectionLayoutRes = resource;
    }

    public class SimpleViewHolder extends RecyclerView.ViewHolder {
        public SimpleViewHolder(View itemView) {
            super(itemView);
        }

        public void aaa() {

        }
    }
}
