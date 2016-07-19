
package com.gracenote.gnsdk;

/** 
** {@link GnMoodgridPresentationType} 
*/ 
 
public enum GnMoodgridPresentationType {
  kMoodgridPresentationType5x5(0x0505),
  kMoodgridPresentationType10x10(0x0A0A);

  protected final int swigValue() {
    return swigValue;
  }

  protected static GnMoodgridPresentationType swigToEnum(int swigValue) {
    GnMoodgridPresentationType[] swigValues = GnMoodgridPresentationType.class.getEnumConstants();
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (GnMoodgridPresentationType swigEnum : swigValues)
      if (swigEnum.swigValue == swigValue)
        return swigEnum;
    throw new IllegalArgumentException("No enum " + GnMoodgridPresentationType.class + " with value " + swigValue);
  }

  @SuppressWarnings("unused")
  private GnMoodgridPresentationType() {
    this.swigValue = SwigNext.next++;
  }

  @SuppressWarnings("unused")
  private GnMoodgridPresentationType(int swigValue) {
    this.swigValue = swigValue;
    SwigNext.next = swigValue+1;
  }

  @SuppressWarnings("unused")
  private GnMoodgridPresentationType(GnMoodgridPresentationType swigEnum) {
    this.swigValue = swigEnum.swigValue;
    SwigNext.next = this.swigValue+1;
  }

  private final int swigValue;

  private static class SwigNext {
    private static int next = 0;
  }
}

