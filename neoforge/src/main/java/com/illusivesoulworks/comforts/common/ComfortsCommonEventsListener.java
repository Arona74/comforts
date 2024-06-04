/*
 * Copyright (C) 2017-2022 Illusive Soulworks
 *
 * Comforts is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * any later version.
 *
 * Comforts is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with Comforts.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.illusivesoulworks.comforts.common;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.CanContinueSleepingEvent;
import net.neoforged.neoforge.event.entity.player.CanPlayerSleepEvent;
import net.neoforged.neoforge.event.entity.player.PlayerSetSpawnEvent;
import net.neoforged.neoforge.event.entity.player.PlayerWakeUpEvent;
import net.neoforged.neoforge.event.level.SleepFinishedTimeEvent;

public class ComfortsCommonEventsListener {

  @SubscribeEvent
  public void onPlayerSetSpawn(final PlayerSetSpawnEvent evt) {

    if (!ComfortsEvents.canSetSpawn(evt.getEntity(), evt.getNewSpawn())) {
      evt.setCanceled(true);
    }
  }

  @SubscribeEvent
  public void onSleepTimeCheck(final CanContinueSleepingEvent evt) {

    evt.getEntity().getSleepingPos().ifPresent(sleepingPos -> {
      ComfortsEvents.Result result =
          ComfortsEvents.checkTime(evt.getEntity().level(), sleepingPos);
      Player.BedSleepingProblem problem = evt.getProblem();

      if (result == ComfortsEvents.Result.ALLOW &&
          problem == Player.BedSleepingProblem.NOT_POSSIBLE_NOW) {
        evt.setContinueSleeping(true);
      }

      if (result == ComfortsEvents.Result.DENY) {
        evt.setContinueSleeping(false);
      }
    });
  }

  @SubscribeEvent
  public void onSleepFinished(final SleepFinishedTimeEvent evt) {
    LevelAccessor levelAccessor = evt.getLevel();

    if (levelAccessor instanceof ServerLevel serverLevel) {
      long newTime = evt.getNewTime();
      long time = ComfortsEvents.getWakeTime(serverLevel, serverLevel.getDayTime(), newTime);

      if (newTime != time) {
        evt.setTimeAddition(time);
      }
    }
  }

  @SubscribeEvent
  public void onPlayerWakeUp(final PlayerWakeUpEvent evt) {
    ComfortsEvents.onWakeUp(evt.getEntity());
  }

  @SubscribeEvent
  public void onPlayerSleep(final CanPlayerSleepEvent evt) {
    ComfortsEvents.Result result =
        ComfortsEvents.checkTime(evt.getEntity().level(), evt.getPos());
    Player.BedSleepingProblem problem = evt.getVanillaProblem();

    if (result == ComfortsEvents.Result.ALLOW &&
        problem == Player.BedSleepingProblem.NOT_POSSIBLE_NOW && evt.getProblem() == problem) {
      evt.setProblem(null);
    } else if (result == ComfortsEvents.Result.DENY) {
      evt.setProblem(Player.BedSleepingProblem.NOT_POSSIBLE_NOW);
    } else if (evt.getProblem() == null) {
      Player.BedSleepingProblem sleepingProblem = ComfortsEvents.onSleep(evt.getEntity());

      if (sleepingProblem != null) {
        evt.setProblem(sleepingProblem);
      }
    }
  }
}
