package com.alex.guzhenren;

import com.alex.guzhenren.network.ModMessages;
import com.alex.guzhenren.network.ModNetworking;
import net.fabricmc.api.ClientModInitializer;

public class GuzhenrenClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ModKeyBindings.register();
        ModNetworking.ClientDataInitialize();
        ModMessages.registerClientReceivers();
    }
}
