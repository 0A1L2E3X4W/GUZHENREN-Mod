package com.alex.guzhenren.utils;

import com.alex.guzhenren.utils.enums.*;

public interface ModPlayerImpl {

    float getLifespan();
    void setLifespan(float v); void changeLifespan(float v);

    int getSoul();
    void setSoul(int v); void changeSoul(int v);

    int getMoral();
    void setMoral(int v); void changeMoral(int v);

    float getCurrentEssence();
    void setCurrentEssence(float v); void changeCurrentEssence(float v);

    int getMaxEssence();
    void setMaxEssence(int v);

    // rank
    ModGuMasterRank getRank();
    void setRank(ModGuMasterRank value);

    // talent
    ModGuMasterTalent getTalent();
    void setTalent(ModGuMasterTalent v);

    // ten extreme physique
    ModTenExtremePhysique getExtremePhysique();
    void setExtremePhysique(ModTenExtremePhysique v);

    // path
    int getAttainment(ModPath path);
    void setAttainment(ModPath thePath, int theAttainment); void changeAttainment(ModPath thePath, int theAttainment);

    // realm
    ModPathRealm getRealm(ModPath thePath);
    void setRealm(ModPath thePath, ModPathRealm theRealm);

    boolean getApertureStatus(); void setApertureStatus(boolean v);
}
