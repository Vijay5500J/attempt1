package com.example.attempt1;



import java.util.ArrayList;

public class PropertyList

    {
        public static ArrayList<ListBean> getData () {
        ArrayList<ListBean> list = new ArrayList<>();
        ListBean bean = new ListBean();
        bean.setConstrctr("Tejal Pride Properties");
        bean.setLocation("Aurangabad");
        bean.setPrice("Rs 28. Lac");
        bean.setType("2 BHK Apartment/Flat 750 sq feet");

        list.add(bean);
        list.add(bean);
        list.add(bean);
        return list;
    }
    }
