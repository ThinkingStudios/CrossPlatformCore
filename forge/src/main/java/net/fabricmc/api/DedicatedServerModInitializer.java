/*
 * Copyright 2016 FabricMC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.fabricmc.api;

/**
 * A mod initializer ran only on {@link net.minecraftforge.api.distmarker.Dist#DEDICATED_SERVER}.
 *
 * <p>In {@code META-INF/mods.toml}, the mod side is defined with {@code SERVER} key.</p>
 *
 * @see ModInitializer
 * @see ClientModInitializer
 */
@FunctionalInterface
public interface DedicatedServerModInitializer {
    /**
     * Runs the mod initializer on the server environment.
     */
    void onInitializeServer();
}