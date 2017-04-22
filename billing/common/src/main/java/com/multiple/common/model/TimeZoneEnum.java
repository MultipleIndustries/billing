package com.multiple.common.model;

import java.util.TimeZone;
/**
 *
 * This is simply all the available TimeZones from java.util.TimeZone as type
 * safe enum.
 *
 * @author Varra
 * @version 1.0
 *
 */
public enum TimeZoneEnum
{
    
    Pacific_Midway("(UTC -11:00) Samoa Standard Time"),

    Pacific_Honolulu("(UTC -10:00) Hawaii Standard Time"),

    America_Anchorage("(UTC -09:00) Alaska Standard Time"),

    America_Los_Angeles("(UTC -08:00) Pacific Standard Time"),

    America_Denver("(UTC -07:00) Mountain Standard Time"),

    America_Chicago("(UTC -06:00) Central Standard Time"),

    America_New_York("(UTC -05:00) Eastern Standard Time"),

    America_Caracas("(UTC -04:30) Venezuela Time"),

    America_Puerto_Rico("(UTC -04:00) Atlantic Standard Time"),

    America_St_Johns("(UTC -03:30) Newfoundland Standard Time"),

    America_Sao_Paulo("(UTC -03:00) Brasilia Time"),

    America_Noronha("(UTC -02:00) Fernando de Noronha Time"),

    Atlantic_Azores("(UTC -01:00) Azores Time"),

    UTC("(UTC ) Coordinated Universal Time"),

    Europe_Lisbon("(UTC ) Western European Time"),

    Europe_Paris("(UTC +01:00) Central European Time"),

    Europe_Istanbul("(UTC +02:00) Eastern European Time"),

    Asia_Jerusalem("(UTC +02:00) Israel Standard Time"),

    Asia_Baghdad("(UTC +03:00) Arabia Standard Time"),

    Asia_Tehran("(UTC +03:30) Iran Standard Time"),

    Asia_Dubai("(UTC +04:00) Gulf Standard Time"),

    Asia_Kabul("(UTC +04:30) Afghanistan Time"),

    Asia_Karachi("(UTC +05:00) Pakistan Time"),

    Asia_Calcutta("(UTC +05:30) India Standard Time"),

    Asia_Katmandu("(UTC +05:45) Nepal Time"),

    Asia_Dhaka("(UTC +06:00) Bangladesh Time"),

    Asia_Rangoon("(UTC +06:30) Myanmar Time"),

    Asia_Saigon("(UTC +07:00) Indochina Time"),

    Asia_Shanghai("(UTC +08:00) China Standard Time"),

    Asia_Tokyo("(UTC +09:00) Japan Standard Time"),

    Asia_Seoul("(UTC +09:00) Korea Standard Time"),

    Australia_Darwin("(UTC +09:30) Central Standard Time (Northern Territory)"),

    Australia_Sydney("(UTC +10:00) Eastern Standard Time (New South Wales)"),

    Pacific_Guadalcanal("(UTC +11:00) Solomon Is. Time"),

    Pacific_Auckland("(UTC +12:00) New Zealand Standard Time"),

    Pacific_Enderbury("(UTC +13:00) Phoenix Is. Time"),

    Pacific_Kiritimati("(UTC +14:00) Line Is. Time");
    
    
    private final String timeZone;
    
    /**
     * Sets the {@link TimeZone}
     * @param tz
     */
    private TimeZoneEnum(final String timeZone)
    {
        this.timeZone =timeZone;
    }
    
    /**
     * Gets the {@link TimeZone}
     * 
     * @return
     */
    public final String getTimeZone()
    {
        return timeZone;
    }
}