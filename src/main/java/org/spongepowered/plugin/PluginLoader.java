/*
 * This file is part of plugin-spi, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered <https://www.spongepowered.org>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.spongepowered.plugin;

import java.util.Optional;

/**
 * A loader used to create and load {@link PluginContainer plugins}.
 *
 * Implementors of this class are required to have a no-args constructor
 */
public interface PluginLoader<P extends PluginContainer> {

    /**
     * Creates a {@link PluginContainer} which which will hold the instance of an actual plugin.
     *
     * @param candidate The candidate
     * @param environment The environment
     * @return The container
     */
    Optional<P> createPluginContainer(final PluginCandidate candidate, final PluginEnvironment environment);

    /**
     * Instructs the {@link PluginContainer} to actually load and create it's plugin instance.
     *
     * <p>The provided classloader should be used to load the any classes needed for the plugin's instance.</p>
     *
     * @param environment The environment
     * @param container The container
     * @param targetClassLoader The classloader
     * @throws InvalidPluginException If the plugin being loaded is invalid
     */
    void loadPlugin(final PluginEnvironment environment, final P container, ClassLoader targetClassLoader) throws InvalidPluginException;
}
