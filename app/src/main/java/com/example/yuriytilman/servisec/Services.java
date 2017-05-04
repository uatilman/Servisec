package com.example.yuriytilman.servisec;


import android.content.res.Resources;import com.example.lesson6.R;

public class Services {

    private String name;
    private String description;
    private int imageResourceId;
    public final static String TYPE = "NAIL";

    /*   private static final String  NAIL = "nail";*/
    public enum Services_TYPE {
        HAIR, NAIL
    }



  //  private Services_TYPE TYPE;

    // Для каждой услуги ногтевого сервиса хранится название, описание и ресурс изображения
    Services(String name, String description, int imageResourceId) {
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    @Override
    public String toString() {
        return this.name;
    }

    // nails - массив с элементами Services
    public static Services[] services(Resources resources, Services_TYPE TYPE) {
        if (TYPE == Services_TYPE.NAIL) {
            Services[] servicesList = {
                    new Services(
                            resources.getStringArray(R.array.service_nail_name)[0],
                            resources.getStringArray(R.array.service_nail_description)[0],
                            R.drawable.kl_man
                    ),
                    new Services(
                            resources.getStringArray(R.array.service_nail_name)[1],
                            resources.getStringArray(R.array.service_nail_description)[1],
                            R.drawable.ap_man
                    ),
                    new Services(
                            resources.getStringArray(R.array.service_nail_name)[2],
                            resources.getStringArray(R.array.service_nail_description)[2],
                            R.drawable.ap_ped
                    )
            };
            return servicesList;
        } else if (TYPE == Services_TYPE.HAIR) {
            Services[] hearsList = {
                    new Services(resources.getStringArray(
                            R.array.service_hear_name)[0],
                            resources.getStringArray(R.array.service_hear_description)[0],
                            R.drawable.short_hair),
                    new Services(resources.getStringArray(
                            R.array.service_hear_name)[1],
                            resources.getStringArray(R.array.service_hear_description)[1],
                            R.drawable.medium_hair
                    ),
                    new Services(
                            resources.getStringArray(R.array.service_hear_name)[2],
                            resources.getStringArray(R.array.service_hear_description)[2],
                            R.drawable.long_hair
                    )
            };
            return hearsList;
        } else
            return null;
    }

//    public static Services[] nails(Resources resources, Services_TYPE TYPE) {
//        Services[] neilList = {
//                new Services(resources.getStringArray(
//                        R.array.service_nail_name)[0],
//                        resources.getStringArray(R.array.service_nail_description)[0],
//                        R.drawable.kl_man,
//                        TYPE),
//                new Services(resources.getStringArray(
//                        R.array.service_nail_name)[1],
//                        resources.getStringArray(R.array.service_nail_description)[1],
//                        R.drawable.ap_man,
//                        TYPE
//                ),
//                new Services(
//                        resources.getStringArray(R.array.service_nail_name)[2],
//                        resources.getStringArray(R.array.service_nail_description)[2],
//                        R.drawable.ap_ped,
//                        TYPE
//                )
//        };
//        return neilList;
//    }
//
//    public static Services[] hears(Resources resources, Services_TYPE TYPE) {
//        Services[] hearsList = {
//                new Services(resources.getStringArray(
//                        R.array.service_hear_name)[0],
//                        resources.getStringArray(R.array.service_hear_description)[0],
//                        R.drawable.short_hair,
//                        TYPE),
//                new Services(resources.getStringArray(
//                        R.array.service_hear_name)[1],
//                        resources.getStringArray(R.array.service_hear_description)[1],
//                        R.drawable.medium_hair,
//                        TYPE
//                ),
//                new Services(
//                        resources.getStringArray(R.array.service_hear_name)[2],
//                        resources.getStringArray(R.array.service_hear_description)[2],
//                        R.drawable.long_hair,
//                        TYPE
//                )
//        };
//        return hearsList;
//    }


}