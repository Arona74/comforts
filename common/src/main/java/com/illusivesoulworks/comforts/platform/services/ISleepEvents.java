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

package com.illusivesoulworks.comforts.platform.services;

import com.illusivesoulworks.comforts.common.capability.ISleepData;
import com.mojang.datafixers.util.Either;
import java.util.Optional;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Unit;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.UseOnContext;

public interface ISleepEvents {

  Player.BedSleepingProblem getSleepResult(ServerPlayer player, BlockPos pos);

  Either<Player.BedSleepingProblem, Unit> getSleepResult(ServerPlayer player, BlockPos pos,
                                                         Either<Player.BedSleepingProblem, Unit> vanillaResult);

  boolean isAwakeTime(Player player, BlockPos pos);

  Optional<? extends ISleepData> getSleepData(Player player);

  void sendAutoSleepPacket(ServerPlayer player, BlockPos pos);

  void sendPlaceBagPacket(ServerPlayer serverPlayer, UseOnContext context);
}
