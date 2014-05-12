/*
 * Copyright 2012-2014 Ray Holder
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.rholder.fauxflake.util;

import org.junit.Assert;
import org.junit.Test;

public class MacUtilsTest {
    /**
     * Make sure we can actually fetch a MAC address.
     */
    @Test
    public void verifyMac() {
        byte[] mac;
        try {
            mac = MacUtils.macAddress();
        } catch(UnsupportedOperationException e) {
            // hmm... maybe we have no valid MAC's?
            e.printStackTrace();
            System.setProperty(MacUtils.OVERRIDE_MAC_PROP, "00:DE:AD:BE:EF:00");
            mac = MacUtils.macAddress();
        }

        Assert.assertNotNull("Could not retrieve MAC", mac);
        Assert.assertTrue("Invalid MAC address", mac.length == 6);
    }
}
