package com.hoverdroids.array_utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

public class ArrayUtils
{
    /**
     * Get a list of ALL display names for each enum value. For the is work, your enum must implement
     * DisplayNameEnum. An example is shown below.
     * @param enumType The enum for which to get the list of display names.
     * @param <E> The enum.
     * @return A list of displayNames derived from the enum values.
     */
    public static <E extends Enum <E>> String[] toDisplayNames(final Class<E> enumType) {
        return toDisplayNames(enumType, null);
    }

    /**
     * Get a list of SPECIFIED display names for each enum value. For the is work, your enum must implement
     * DisplayNameEnum. An example is shown below.
     * @param enumType The enum for which to get the list of display names.
     * @param include An array of enums of enumType that you want included. Null includes all.
     * @param <E> The enum.
     * @return A list of displayNames derived from the enum values.
     *
     *  public enum PetsEnum implements DisplayNameEnum {
     *      CAT("Cat"),
     *      DOG("Dog"),
     *      FISH("Fish");
     *
     *      private String displayName;
     *
     *      PetsEnum(String name){
     *          displayName = name;
     *      }
     *
     *      @Override
     *      public void displayName(){
     *          return displayName;
     *      }
     * }
     */
    public static <E extends Enum <E>> String[] toDisplayNames(final Class<E> enumType, E[] include) {
        if (!DisplayNameEnum.class.isAssignableFrom(enumType))
        {
            return null;
        }

        final EnumSet<E> set = java.util.EnumSet.allOf(enumType);
        final List<E> incl = include == null ? null : Arrays.asList(include);

        final List<String> displayNames = new ArrayList<>();
        for (E e : set) {
            if (include == null || incl.contains(e))
            {
                displayNames.add(((DisplayNameEnum) e).displayName());
            }
        }
        return displayNames.toArray(new String[0]);
    }
}
