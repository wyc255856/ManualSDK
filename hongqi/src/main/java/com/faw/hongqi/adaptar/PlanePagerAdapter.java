package com.faw.hongqi.adaptar;import android.support.v4.app.Fragment;import android.support.v4.app.FragmentManager;import android.support.v4.app.FragmentStatePagerAdapter;import com.faw.hongqi.fragment.BaseFragment;import java.util.ArrayList;/** * @author henzil.jack E-mail:henzil.jack@gmail.com * @version 创建时间：2013-7-2 下午3:14:58 * @Description */public class PlanePagerAdapter extends FragmentStatePagerAdapter {    ArrayList<BaseFragment> _dataList = new ArrayList<>();    public PlanePagerAdapter(FragmentManager fm, ArrayList<BaseFragment> _dataList) {        super(fm);        this._dataList = _dataList;    }    @Override    public Fragment getItem(int position) {        return _dataList.get(position);    }    @Override    public int getCount() {        return _dataList.size();    }}