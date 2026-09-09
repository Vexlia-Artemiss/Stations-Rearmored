package stations_rearmored;

import com.fs.starfarer.api.BaseModPlugin;
import com.fs.starfarer.api.Global;

import java.util.List;

public class stations_rearmored_modPlugin extends BaseModPlugin {

    @Override
    public void onApplicationLoad() throws Exception {
        List<String> variants = Global.getSettings().getAllVariantIds();
        for (String var : variants){
            //Lowtech and partially midline
            AddArmorHullmods("module_armour1", var);
            AddArmorHullmods("module_armour2", var);

            //Midline
            AddArmorHullmods("module_armour3", var);
            AddArmorHullmods("module_armour4", var);
            AddArmorHullmods("module_armour5", var);

            //Hightech
            AddArmorHullmods("module_hightech_armour", var);

            //Remnant
            AddArmorHullmods("remnant_armour1", var);
            AddArmorHullmods("remnant_armour2", var);
            AddArmorHullmods("remnant_armour3", var);

            //Shadow Yards
            AddArmorHullmods("ms_blocker", var);
            AddArmorHullmods("ms_module_armour", var);

            //AOTD Citadels
            //Low Tech
            AddArmorHullmods("armor_big", var);
            AddArmorHullmods("armor_small", var);
            //High Tech
            AddArmorHullmods("t4_ht_amodule", var);

            //Eusan Nation
            AddArmorHullmods("eusan_nation_module_armour", var);
            AddArmorHullmods("eusan_nation_module_armour_s", var);

            //XLU - Blue
            AddArmorHullmods("xlu_station_armor", var);
            AddArmorHullmods("xlu_station_bastion_armor", var);
            AddArmorHullmods("xlu_station_blocker_armor_left", var);
            AddArmorHullmods("xlu_station_blocker_armor_right", var);
            AddArmorHullmods("xlu_station_hangar_armor_left", var);
            AddArmorHullmods("xlu_station_hangar_armor_right", var);
            AddArmorHullmods("xlu_station_missile_armor_left", var);
            AddArmorHullmods("xlu_station_missile_armor_right", var);

            //HMI - Mess
            AddArmorHullmods("mess_remnant_armour1", var);
            AddArmorHullmods("mess_remnant_armour2", var);
            AddArmorHullmods("mess_remnant_armour3", var);

            //Interstellar Imperium
            AddArmorHullmods("ii_module_armor_left", var);
            AddArmorHullmods("ii_module_armor_right", var);
            AddArmorHullmods("ii_module_armor_straight", var);
            AddArmorHullmods("ii_module_armor_leftsmall", var);
            AddArmorHullmods("ii_module_armor_rightsmall", var);
            AddArmorHullmods("ii_module_armor_leftbig_heavy", var);
            AddArmorHullmods("ii_module_armor_rightbig_heavy", var);
        }
    }

    void AddArmorHullmods(String hull_id, String variant){
        if(variant.startsWith(hull_id)){
            Global.getSettings().getVariant(variant).addMod("ML_enhancedModuleArmor");
            Global.getSettings().getVariant(variant).addPermaMod("ML_enhancedModuleArmor");
        }
    }
}
