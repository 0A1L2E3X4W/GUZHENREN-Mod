package com.alex.guzhenren.api;

import com.alex.guzhenren.api.enums.*;

public interface ModPlayerImpl {

    float getLifespan();
    void setLifespan(float v);
    void changeLifespan(float v);

    int getMoral();
    void setMoral(int v);
    void changeMoral(int v);

    float getCurrentEssence();
    void setCurrentEssence(float v);
    void changeCurrentEssence(float v);

    int getMaxEssence();
    void setMaxEssence(int v);

    // rank
    ModRank getRank();
    void setRank(ModRank value);

    // talent
    ModPlayerTalent getTalent();
    void setTalent(ModPlayerTalent v);

    // ten extreme physique
    ModTenExtremePhysique getSpecialPhysique();
    void setSpecialPhysique(ModTenExtremePhysique v);

    // path
    int getAttainment(ModPath path);
    void setAttainment(ModPath thePath, int theAttainment);
    void changeAttainment(ModPath thePath, int theAttainment);

    // realm
    ModRealm getRealm(ModPath thePath);
    void setRealm(ModPath thePath, ModRealm theRealm);
}
