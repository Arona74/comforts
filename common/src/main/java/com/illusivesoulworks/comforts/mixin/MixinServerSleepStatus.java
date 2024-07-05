package com.illusivesoulworks.comforts.mixin;

import com.illusivesoulworks.comforts.common.ComfortsEvents;
import com.illusivesoulworks.comforts.common.util.ServerAware;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.players.SleepStatus;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerLevel.class)
public class MixinServerSleepStatus {

  @Shadow
  @Final
  private SleepStatus sleepStatus;

  @Inject(
      at = @At("TAIL"),
      method = "<init>"
  )
  private void comforts$onInit(CallbackInfo ci) {

    if (this.sleepStatus instanceof ServerAware serverAware) {
      serverAware.comforts$setServer((ServerLevel) (Object) this);
    }
  }

  @Inject(
      at = @At("HEAD"),
      method = "announceSleepStatus",
      cancellable = true
  )
  private void comforts$onAnnounceSleepStatus(CallbackInfo ci) {

    if (ComfortsEvents.announceSleepStatus(this.sleepStatus, ((ServerLevel) (Object) this))) {
      ci.cancel();
    }
  }
}
