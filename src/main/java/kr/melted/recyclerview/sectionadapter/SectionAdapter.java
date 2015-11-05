package kr.melted.recyclerview.sectionadapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * Created by globalsmartkr on 2015. 11. 4..
 */
public abstract class SectionAdapter
        <SECTION extends RecyclerView.ViewHolder, ITEM extends RecyclerView.ViewHolder>
        extends RecyclerView.Adapter {


    public static final int ITEM = 0;
    public static final int SECTION = 1;

    private ITEM itemHolder;
    private SECTION sectionHolder;

    public SectionAdapter() {
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType) {
            case ITEM:
                itemHolder = (ITEM) onCreateItemHolder(inflater, parent);
                break;
            case SECTION:
                sectionHolder = (SECTION) onCreateSectionHolder(inflater, parent);
                break;
            default:

        }
        return itemHolder != null ? itemHolder : sectionHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (isSectionHeaderView()) {
            //  get section header view
            onBindSectionHeaderView((SECTION) holder, position);
        } else {
            //  get item view
            onBindItemView((ITEM) holder, position);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return isSectionHeaderView() ? SECTION : ITEM;
    }

    /**
     * Create the section header view holder in this method.
     *
     * @param inflater an inflater instance to inflate the layout XML.
     * @param parent   an item view container.
     * @return created view holder
     */
    public abstract RecyclerView.ViewHolder onCreateSectionHolder(LayoutInflater inflater, ViewGroup parent);

    /**
     * Create the item view holder in this method.
     *
     * @param inflater an inflater instance to inflate the layout XML.
     * @param parent   an item view container.
     * @return created view holder
     */
    public abstract RecyclerView.ViewHolder onCreateItemHolder(LayoutInflater inflater, ViewGroup parent);

    /**
     * Notice whether the list data is section or item.
     * Should implement this method to notice this view count system.
     * <p/>
     * if the view type is section, this adapter will get section header view,
     * if not, this adapter will get item view.
     *
     * @return if section view, true.
     */
    public abstract boolean isSectionHeaderView();

    /**
     * Called when the item view is binding.
     *
     * @param holder a view holder that you given in class generic type.
     */
    public abstract void onBindItemView(ITEM holder, int position);

    /**
     * Called when the section header view is binding.
     *
     * @param holder a view holder that you given in class generic type.
     */
    public abstract void onBindSectionHeaderView(SECTION holder, int position);
}