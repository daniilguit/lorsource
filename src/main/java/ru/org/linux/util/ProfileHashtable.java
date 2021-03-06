/*
 * Copyright 1998-2012 Linux.org.ru
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package ru.org.linux.util;

import java.util.Map;

public class ProfileHashtable {
  private final Map<String, Object> Defaults;
  private final Map<String, Object> settings;

  public ProfileHashtable(Map<String, Object> defaults, Map<String, Object> settings) {
    Defaults = defaults;
    this.settings = settings;

    if (this.settings == null || Defaults == null) {
      throw new NullPointerException();
    }
  }

  public String getString(String prop) {
    if (settings.get(prop) != null) {
      return (String) settings.get(prop);
    } else {
      return (String) Defaults.get(prop);
    }
  }

  public boolean getBoolean(String prop) {
    if (settings.get(prop) != null) {
      return (Boolean) settings.get(prop);
    } else {
      Boolean value = (Boolean) Defaults.get(prop);
      if (value == null) {
        throw new RuntimeException("unknown property '"+prop+"'; no default value");
      }
      return value;
    }
  }

  public Object getObject(String prop) {
    if (settings.get(prop) != null) {
      return settings.get(prop);
    } else {
      return Defaults.get(prop);
    }
  }

  public int getInt(String prop) {
    if (settings.get(prop) != null) {
      return (Integer) settings.get(prop);
    } else {
      return (Integer) Defaults.get(prop);
    }
  }

  public long getLong(String prop) {
    if (settings.get(prop) != null) {
      return (Long) settings.get(prop);
    } else {
      return (Long) Defaults.get(prop);
    }
  }

  public boolean setInt(String prop, Integer value) {
    if (value != null && value != getInt(prop)) {
      settings.put(prop, value);
      return true;
    } else {
      return false;
    }
  }

  public boolean setString(String prop, String value) {
    if (value != null && !value.equals(getString(prop))) {
      settings.put(prop, value);
      return true;
    } else {
      return false;
    }
  }

  public void setObject(String prop, Object value) {
    if (value != null) {
      settings.put(prop, value);
      } else {
      }
  }

  public boolean setBoolean(String prop, boolean value) {
    if (value != getBoolean(prop)) {
      settings.put(prop, value);
      return true;
    } else {
      return false;
    }
  }

  public boolean setBoolean(String prop, String value)  {
    if (value == null) {
      return setBoolean(prop, false);
    }

    if ("on".equals(value)) {
      return setBoolean(prop, true);
    }

    return false;
  }

  public void addBoolean(String prop, boolean value) {
    settings.put(prop, value);
  }

  public void addObject(String prop, Object value) {
    settings.put(prop, value);
  }

  public void removeObject(String key) {
    settings.remove(key);
  }

  public Map<String, Object> getSettings() {
    return settings;
  }
}
