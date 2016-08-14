/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.gracenote.gnsdk;

public class GnMoodgridDataPoint {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected GnMoodgridDataPoint(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(GnMoodgridDataPoint obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        gnsdk_javaJNI.delete_GnMoodgridDataPoint(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public GnMoodgridDataPoint() {
    this(gnsdk_javaJNI.new_GnMoodgridDataPoint__SWIG_0(), true);
  }

  public GnMoodgridDataPoint(long x, long y) {
    this(gnsdk_javaJNI.new_GnMoodgridDataPoint__SWIG_1(x, y), true);
  }

  public void setX(long value) {
    gnsdk_javaJNI.GnMoodgridDataPoint_X_set(swigCPtr, this, value);
  }

  public long getX() {
    return gnsdk_javaJNI.GnMoodgridDataPoint_X_get(swigCPtr, this);
  }

  public void setY(long value) {
    gnsdk_javaJNI.GnMoodgridDataPoint_Y_set(swigCPtr, this, value);
  }

  public long getY() {
    return gnsdk_javaJNI.GnMoodgridDataPoint_Y_get(swigCPtr, this);
  }

}