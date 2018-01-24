package org.robolectric.shadows;

import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR1;

import android.content.ContentResolver;
import android.provider.Settings;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;

@SuppressWarnings({"UnusedDeclaration"})
@Implements(Settings.class)
public class ShadowSettings {
  @Implements(value = Settings.System.class)
  public static class ShadowSystem {
    private static final WeakHashMap<ContentResolver, Map<String, Object>> dataMap = new WeakHashMap<ContentResolver, Map<String, Object>>();

    // Note that @Implementation methods in this class should be mirrored
    // in ShadowSecure and ShadowGlobal!

    @Implementation
    public static boolean putInt(ContentResolver cr, String name, int value) {
      get(cr).put(name, value);
      return true;
    }

    @Implementation
    public static int getInt(ContentResolver cr, String name, int def) {
      if (get(cr).get(name) instanceof Integer) {
        return (Integer) get(cr).get(name);
      } else {
        return def;
      }
    }

    @Implementation
    public static int getInt(ContentResolver cr, String name) throws Settings.SettingNotFoundException {
      if (get(cr).get(name) instanceof Integer) {
        return (Integer) get(cr).get(name);
      } else {
        throw new Settings.SettingNotFoundException(name);
      }
    }

    @Implementation
    public static boolean putString(ContentResolver cr, String name, String value) {
      get(cr).put(name, value);
      return true;
    }

    @Implementation
    public static String getString(ContentResolver cr, String name) {
      if (get(cr).get(name) instanceof String) {
        return (String) get(cr).get(name);
      } else {
        return null;
      }
    }

    @Implementation(minSdk = JELLY_BEAN_MR1)
    public static String getStringForUser(ContentResolver cr, String name, int userHandle) {
      return getString(cr, name);
    }

    @Implementation
    public static boolean putLong(ContentResolver cr, String name, long value) {
      get(cr).put(name, value);
      return true;
    }

    @Implementation
    public static long getLong(ContentResolver cr, String name, long def) {
      if (get(cr).get(name) instanceof Long) {
        return (Long) get(cr).get(name);
      } else {
        return def;
      }
    }

    @Implementation
    public static long getLong(ContentResolver cr, String name) throws Settings.SettingNotFoundException {
      if (get(cr).get(name) instanceof Long) {
        return (Long) get(cr).get(name);
      } else {
        throw new Settings.SettingNotFoundException(name);
      }
    }

    @Implementation
    public static boolean putFloat(ContentResolver cr, String name, float value) {
      get(cr).put(name, value);
      return true;
    }

    @Implementation
    public static float getFloat(ContentResolver cr, String name, float def) {
      if (get(cr).get(name) instanceof Float) {
        return (Float) get(cr).get(name);
      } else {
        return def;
      }
    }

    @Implementation
    public static float getFloat(ContentResolver cr, String name) throws Settings.SettingNotFoundException {
      if (get(cr).get(name) instanceof Float) {
        return (Float) get(cr).get(name);
      } else {
        throw new Settings.SettingNotFoundException(name);
      }
    }

    private static Map<String, Object> get(ContentResolver cr) {
      Map<String, Object> map = dataMap.get(cr);
      if (map == null) {
        map = new HashMap<>();
        dataMap.put(cr, map);
      }
      return map;
    }
  }

  @Implements(value = Settings.Secure.class)
  public static class ShadowSecure extends ShadowSystem {
    @Implementation
    public static boolean putInt(ContentResolver cr, String name, int value) {
      return ShadowSystem.putInt(cr, name, value);
    }

    @Implementation
    public static int getInt(ContentResolver cr, String name, int def) {
      return ShadowSystem.getInt(cr, name, def);
    }

    @Implementation
    public static int getInt(ContentResolver cr, String name) throws Settings.SettingNotFoundException {
      return ShadowSystem.getInt(cr, name);
    }

    @Implementation
    public static boolean putString(ContentResolver cr, String name, String value) {
      return ShadowSystem.putString(cr, name, value);
    }

    @Implementation
    public static String getString(ContentResolver cr, String name) {
      return ShadowSystem.getString(cr, name);
    }

    @Implementation(minSdk = JELLY_BEAN_MR1)
    public static String getStringForUser(ContentResolver cr, String name, int userHandle) {
      return ShadowSystem.getStringForUser(cr, name, userHandle);
    }

    @Implementation
    public static boolean putLong(ContentResolver cr, String name, long value) {
      return ShadowSystem.putLong(cr, name, value);
    }

    @Implementation
    public static long getLong(ContentResolver cr, String name, long def) {
      return ShadowSystem.getLong(cr, name, def);
    }

    @Implementation
    public static long getLong(ContentResolver cr, String name) throws Settings.SettingNotFoundException {
      return ShadowSystem.getLong(cr, name);
    }

    @Implementation
    public static boolean putFloat(ContentResolver cr, String name, float value) {
      return ShadowSystem.putFloat(cr, name, value);
    }

    @Implementation
    public static float getFloat(ContentResolver cr, String name, float def) {
      return ShadowSystem.getFloat(cr, name, def);
    }

    @Implementation
    public static float getFloat(ContentResolver cr, String name) throws Settings.SettingNotFoundException {
      return ShadowSystem.getFloat(cr, name);
    }
  }

  @Implements(value = Settings.Global.class, inheritImplementationMethods = true, minSdk = JELLY_BEAN_MR1)
  public static class ShadowGlobal extends ShadowSystem {
    @Implementation
    public static boolean putInt(ContentResolver cr, String name, int value) {
      return ShadowSystem.putInt(cr, name, value);
    }

    @Implementation
    public static int getInt(ContentResolver cr, String name, int def) {
      return ShadowSystem.getInt(cr, name, def);
    }

    @Implementation
    public static int getInt(ContentResolver cr, String name) throws Settings.SettingNotFoundException {
      return ShadowSystem.getInt(cr, name);
    }

    @Implementation
    public static boolean putString(ContentResolver cr, String name, String value) {
      return ShadowSystem.putString(cr, name, value);
    }

    @Implementation
    public static String getString(ContentResolver cr, String name) {
      return ShadowSystem.getString(cr, name);
    }

    @Implementation(minSdk = JELLY_BEAN_MR1)
    public static String getStringForUser(ContentResolver cr, String name, int userHandle) {
      return ShadowSystem.getStringForUser(cr, name, userHandle);
    }

    @Implementation
    public static boolean putLong(ContentResolver cr, String name, long value) {
      return ShadowSystem.putLong(cr, name, value);
    }

    @Implementation
    public static long getLong(ContentResolver cr, String name, long def) {
      return ShadowSystem.getLong(cr, name, def);
    }

    @Implementation
    public static long getLong(ContentResolver cr, String name) throws Settings.SettingNotFoundException {
      return ShadowSystem.getLong(cr, name);
    }

    @Implementation
    public static boolean putFloat(ContentResolver cr, String name, float value) {
      return ShadowSystem.putFloat(cr, name, value);
    }

    @Implementation
    public static float getFloat(ContentResolver cr, String name, float def) {
      return ShadowSystem.getFloat(cr, name, def);
    }

    @Implementation
    public static float getFloat(ContentResolver cr, String name) throws Settings.SettingNotFoundException {
      return ShadowSystem.getFloat(cr, name);
    }
  }

  /**
   * Sets the value of the {@link Settings.System#AIRPLANE_MODE_ON} setting.
   *
   * @param isAirplaneMode new status for airplane mode
   */
  public static void setAirplaneMode(boolean isAirplaneMode) {
    Settings.System.putInt(RuntimeEnvironment.application.getContentResolver(), Settings.System.AIRPLANE_MODE_ON, isAirplaneMode ? 1 : 0);
  }

  /**
   * Non-Android accessor that allows the value of the WIFI_ON setting to be set.
   *
   * @param isOn new status for wifi mode
   */
  public static void setWifiOn(boolean isOn) {
    Settings.Secure.putInt(RuntimeEnvironment.application.getContentResolver(), Settings.Secure.WIFI_ON, isOn ? 1 : 0);
  }

  /**
   * Sets the value of the {@link Settings.System#TIME_12_24} setting.
   *
   * @param use24HourTimeFormat new status for the time setting
   */
  public static void set24HourTimeFormat(boolean use24HourTimeFormat) {
    Settings.System.putString(RuntimeEnvironment.application.getContentResolver(), Settings.System.TIME_12_24, use24HourTimeFormat ? "24" : "12");
  }
}
