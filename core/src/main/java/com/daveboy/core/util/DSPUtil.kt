package com.daveboy.core.util

import android.content.Context
import android.content.SharedPreferences
import com.blankj.utilcode.util.AppUtils
import com.daveboy.core.base.Dcore

/**
 * SharedPreferences工具类
 */
class DSPUtil {
    /**
     * 这里只写了默认名字的构造，如需要其他的名字，请自行补充
     */
    companion object {
        val sp: SharedPreferences by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            Dcore.application.getSharedPreferences(
                AppUtils.getAppPackageName() + "_sp"
                , Context.MODE_PRIVATE
            )
        }


        fun put(key: String, value: String, isCommit: Boolean = false) {
            if (isCommit) {
                sp.edit().putString(key, value).commit()
            } else {
                sp.edit().putString(key, value).apply()
            }
        }

        /**
         * Return the string value in sp.
         *
         * @param key          The key of sp.
         * @param defaultValue The default value if the sp doesn't exist.
         * @return the string value if sp exists or `defaultValue` otherwise
         */
        fun getString(key: String, defaultValue: String = ""): String? {
            return sp.getString(key, defaultValue)
        }

        /**
         * Put the int value in sp.
         *
         * @param key      The key of sp.
         * @param value    The value of sp.
         * @param isCommit True to use [SharedPreferences.Editor.commit],
         * false to use [SharedPreferences.Editor.apply]
         */
        fun put(key: String, value: Int, isCommit: Boolean = false) {
            if (isCommit) {
                sp.edit().putInt(key, value).commit()
            } else {
                sp.edit().putInt(key, value).apply()
            }
        }

        /**
         * Return the int value in sp.
         *
         * @param key          The key of sp.
         * @param defaultValue The default value if the sp doesn't exist.
         * @return the int value if sp exists or `defaultValue` otherwise
         */
        fun getInt(key: String, defaultValue: Int = -1): Int {
            return sp.getInt(key, defaultValue)
        }

        /**
         * Put the long value in sp.
         *
         * @param key      The key of sp.
         * @param value    The value of sp.
         * @param isCommit True to use [SharedPreferences.Editor.commit],
         * false to use [SharedPreferences.Editor.apply]
         */
        fun put(key: String, value: Long, isCommit: Boolean = false) {
            if (isCommit) {
                sp.edit().putLong(key, value).commit()
            } else {
                sp.edit().putLong(key, value).apply()
            }
        }

        /**
         * Return the long value in sp.
         *
         * @param key          The key of sp.
         * @param defaultValue The default value if the sp doesn't exist.
         * @return the long value if sp exists or `defaultValue` otherwise
         */
        fun getLong(key: String, defaultValue: Long = -1L): Long {
            return sp.getLong(key, defaultValue)
        }

        /**
         * Put the float value in sp.
         *
         * @param key      The key of sp.
         * @param value    The value of sp.
         * @param isCommit True to use [SharedPreferences.Editor.commit],
         * false to use [SharedPreferences.Editor.apply]
         */
        fun put(key: String, value: Float, isCommit: Boolean = false) {
            if (isCommit) {
                sp.edit().putFloat(key, value).commit()
            } else {
                sp.edit().putFloat(key, value).apply()
            }
        }

        /**
         * Return the float value in sp.
         *
         * @param key          The key of sp.
         * @param defaultValue The default value if the sp doesn't exist.
         * @return the float value if sp exists or `defaultValue` otherwise
         */
        fun getFloat(key: String, defaultValue: Float = -1f): Float {
            return sp.getFloat(key, defaultValue)
        }

        /**
         * Put the boolean value in sp.
         *
         * @param key      The key of sp.
         * @param value    The value of sp.
         * @param isCommit True to use [SharedPreferences.Editor.commit],
         * false to use [SharedPreferences.Editor.apply]
         */
        fun put(key: String, value: Boolean, isCommit: Boolean = false) {
            if (isCommit) {
                sp.edit().putBoolean(key, value).commit()
            } else {
                sp.edit().putBoolean(key, value).apply()
            }
        }

        /**
         * Return the boolean value in sp.
         *
         * @param key          The key of sp.
         * @param defaultValue The default value if the sp doesn't exist.
         * @return the boolean value if sp exists or `defaultValue` otherwise
         */
        fun getBoolean(key: String, defaultValue: Boolean = false): Boolean {
            return sp.getBoolean(key, defaultValue)
        }

        /**
         * Put the set of string value in sp.
         *
         * @param key      The key of sp.
         * @param value    The value of sp.
         * @param isCommit True to use [SharedPreferences.Editor.commit],
         * false to use [SharedPreferences.Editor.apply]
         */
        fun put(
            key: String,
            value: Set<String>,
            isCommit: Boolean = false
        ) {
            if (isCommit) {
                sp.edit().putStringSet(key, value).commit()
            } else {
                sp.edit().putStringSet(key, value).apply()
            }
        }

        /**
         * Return the set of string value in sp.
         *
         * @param key The key of sp.
         * @return the set of string value if sp exists
         * or `Collections.<String>emptySet()` otherwise
         */
        fun getStringSet(key: String): Set<String>? {
            return getStringSet(key, emptySet())
        }

        /**
         * Return the set of string value in sp.
         *
         * @param key          The key of sp.
         * @param defaultValue The default value if the sp doesn't exist.
         * @return the set of string value if sp exists or `defaultValue` otherwise
         */
        fun getStringSet(
            key: String,
            defaultValue: Set<String>
        ): Set<String>? {
            return sp.getStringSet(key, defaultValue)
        }

        /**
         * Return all values in sp.
         *
         * @return all values in sp
         */
        fun getAll(): Map<String, *> {
            return sp.getAll()
        }

        /**
         * Return whether the sp contains the preference.
         *
         * @param key The key of sp.
         * @return `true`: yes<br></br>`false`: no
         */
        operator fun contains(key: String): Boolean {
            return sp.contains(key)
        }

        /**
         * Remove the preference in sp.
         *
         * @param key      The key of sp.
         * @param isCommit True to use [SharedPreferences.Editor.commit],
         * false to use [SharedPreferences.Editor.apply]
         */
        fun remove(key: String, isCommit: Boolean = false) {
            if (isCommit) {
                sp.edit().remove(key).commit()
            } else {
                sp.edit().remove(key).apply()
            }
        }

        /**
         * Remove all preferences in sp.
         *
         * @param isCommit True to use [SharedPreferences.Editor.commit],
         * false to use [SharedPreferences.Editor.apply]
         */
        fun clear(isCommit: Boolean = false) {
            if (isCommit) {
                sp.edit().clear().commit()
            } else {
                sp.edit().clear().apply()
            }
        }
    }
}