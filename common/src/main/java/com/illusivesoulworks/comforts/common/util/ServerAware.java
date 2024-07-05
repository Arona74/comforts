package com.illusivesoulworks.comforts.common.util;

import net.minecraft.server.level.ServerLevel;

public interface ServerAware {

  void comforts$setServer(ServerLevel server);

  ServerLevel comforts$getServer();
}
