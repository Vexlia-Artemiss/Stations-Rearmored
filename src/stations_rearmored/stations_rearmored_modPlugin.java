package stations_rearmored;

import com.fs.starfarer.api.BaseModPlugin;
import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.combat.ShipVariantAPI;
import org.magiclib.hullmods.enhancedmodule.EnhancedModuleArmor;

import java.util.Arrays;
import java.util.List;

public class stations_rearmored_modPlugin extends BaseModPlugin {

    // Base hull/module ids whose variants should receive the enhanced module armor hullmod.
    private static final List<String> ARMOR_MODULE_BASE_IDS = Arrays.asList(
            //Lowtech and partially midline
            "module_armour1",
            "module_armour2",

            //Midline
            "module_armour3",
            "module_armour4",
            "module_armour5",

            //Hightech
            "module_hightech_armour",

            //Remnant
            "remnant_armour1",
            "remnant_armour2",
            "remnant_armour3",

            //Shadow Yards
            "ms_blocker",
            "ms_module_armour",

            //AOTD Citadels
            //Low Tech
            "armor_big",
            "armor_small",
            //High Tech
            "t4_ht_amodule",

            //Eusan Nation
            "eusan_nation_module_armour",
            "eusan_nation_module_armour_s",

            //XLU - Blue
            "xlu_station_armor",
            "xlu_station_bastion_armor",
            "xlu_station_blocker_armor_left",
            "xlu_station_blocker_armor_right",
            "xlu_station_hangar_armor_left",
            "xlu_station_hangar_armor_right",
            "xlu_station_missile_armor_left",
            "xlu_station_missile_armor_right",

            //HMI - Mess
            "mess_remnant_armour1",
            "mess_remnant_armour2",
            "mess_remnant_armour3",

            //Interstellar Imperium
            "ii_module_armor_left",
            "ii_module_armor_right",
            "ii_module_armor_straight",
            "ii_module_armor_leftsmall",
            "ii_module_armor_rightsmall",
            "ii_module_armor_leftbig_heavy",
            "ii_module_armor_rightbig_heavy"
    );


    @Override
    public void onApplicationLoad() throws Exception {

        if (Global.getSettings().getHullModSpec("ML_enhancedModuleArmor") == null) {
            throw new Exception("[stations_rearmored] Missing required hullmod - ML_enhancedModuleArmor!\nThis likely means you didn't install latest MagicLib pre-release.\nYou can install latest MagicLib pre-release from https://github.com/MagicLibStarsector/MagicLib/releases");
        }

        List<String> variantIds = Global.getSettings().getAllVariantIds();

        for (String variantId : variantIds) {
            try {
                applyArmorHullmodIfMatch(variantId);
            } catch (Exception e) {
                Global.getLogger(this.getClass()).warn("Failed to process variant '" + variantId + "'", e);
            }
        }
    }

    private void applyArmorHullmodIfMatch(String variantId) {
        for (String baseId : ARMOR_MODULE_BASE_IDS) {
            if (variantId.startsWith(baseId)) {
                ShipVariantAPI variant = Global.getSettings().getVariant(variantId);
                variant.addMod(EnhancedModuleArmor.HULL_MOD_ID);
                variant.addPermaMod(EnhancedModuleArmor.HULL_MOD_ID);
                return; // a variant should only match one base id
            }
        }
    }
}


