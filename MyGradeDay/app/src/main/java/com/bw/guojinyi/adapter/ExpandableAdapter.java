package com.bw.guojinyi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.guojinyi.R;
import com.bw.guojinyi.bean.CartBean;
import com.bw.guojinyi.bean.ShoppingBean;
import com.bw.guojinyi.fragment.Shopping_Fragment;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: MyGradeDay
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/2/28 16:37
 * @Description: 用途：完成特定功能
 */
public class ExpandableAdapter extends BaseExpandableListAdapter {
    private List<CartBean.ResultBean> list = new ArrayList<>();
    private Context context;

    public ExpandableAdapter(List<CartBean.ResultBean> list, Context context) {
        this.list.addAll(list);
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return list.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        CartBean.ResultBean resultBean = list.get(groupPosition);
        List<CartBean.ResultBean.ShoppingCartListBean> shoppingCartList = resultBean.getShoppingCartList();
        return shoppingCartList.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        CartBean.ResultBean resultBean = list.get(groupPosition);
        return resultBean;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        CartBean.ResultBean resultBean = list.get(groupPosition);
        List<CartBean.ResultBean.ShoppingCartListBean> shoppingCartList = resultBean.getShoppingCartList();
        CartBean.ResultBean.ShoppingCartListBean shoppingCartListBean = shoppingCartList.get(childPosition);
        return shoppingCartListBean;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return groupPosition+childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.itemgroup, parent, false);
        TextView viewById = inflate.findViewById(R.id.tvgroup);
        CartBean.ResultBean resultBean = list.get(groupPosition);
        String categoryName = resultBean.getCategoryName();
        viewById.setText(categoryName);

        return inflate;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.itemchild, parent, false);
        ImageView ivChild = inflate.findViewById(R.id.ivChild);
        TextView tvchild = inflate.findViewById(R.id.tvChild);
        CartBean.ResultBean resultBean = list.get(groupPosition);
        List<CartBean.ResultBean.ShoppingCartListBean> shoppingCartList = resultBean.getShoppingCartList();
        CartBean.ResultBean.ShoppingCartListBean shoppingCartListBean = shoppingCartList.get(childPosition);
        String commodityName = shoppingCartListBean.getCommodityName();
        tvchild.setText(commodityName);

        Glide.with(context)
                .load(shoppingCartListBean.getPic())
                .into(ivChild);
        return inflate;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
