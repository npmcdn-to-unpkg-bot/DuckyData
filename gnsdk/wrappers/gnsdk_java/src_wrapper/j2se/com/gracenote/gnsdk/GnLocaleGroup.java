
package com.gracenote.gnsdk;

/** 
* Locale groups used when specifying which locale to load. 
*/ 
 
public enum GnLocaleGroup {
 
 
  kLocaleGroupInvalid(0),
 
 
  kLocaleGroupMusic,
 
 
  kLocaleGroupVideo,
 
 
  kLocaleGroupPlaylist,
 
 
  kLocaleGroupEpg;

  protected final int swigValue() {
    return swigValue;
  }

  protected static GnLocaleGroup swigToEnum(int swigValue) {
    GnLocaleGroup[] swigValues = GnLocaleGroup.class.getEnumConstants();
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (GnLocaleGroup swigEnum : swigValues)
      if (swigEnum.swigValue == swigValue)
        return swigEnum;
    throw new IllegalArgumentException("No enum " + GnLocaleGroup.class + " with value " + swigValue);
  }

  @SuppressWarnings("unused")
  private GnLocaleGroup() {
    this.swigValue = SwigNext.next++;
  }

  @SuppressWarnings("unused")
  private GnLocaleGroup(int swigValue) {
    this.swigValue = swigValue;
    SwigNext.next = swigValue+1;
  }

  @SuppressWarnings("unused")
  private GnLocaleGroup(GnLocaleGroup swigEnum) {
    this.swigValue = swigEnum.swigValue;
    SwigNext.next = this.swigValue+1;
  }

  private final int swigValue;

  private static class SwigNext {
    private static int next = 0;
  }
}

