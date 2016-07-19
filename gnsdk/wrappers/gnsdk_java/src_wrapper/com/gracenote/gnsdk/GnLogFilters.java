/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.gracenote.gnsdk;

public class GnLogFilters {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected GnLogFilters(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(GnLogFilters obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        gnsdk_javaJNI.delete_GnLogFilters(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public GnLogFilters() {
    this(gnsdk_javaJNI.new_GnLogFilters(), true);
  }

  public GnLogFilters clear() {
    return new GnLogFilters(gnsdk_javaJNI.GnLogFilters_clear(swigCPtr, this), false);
  }

  public GnLogFilters error() {
    return new GnLogFilters(gnsdk_javaJNI.GnLogFilters_error(swigCPtr, this), false);
  }

  public GnLogFilters warning() {
    return new GnLogFilters(gnsdk_javaJNI.GnLogFilters_warning(swigCPtr, this), false);
  }

  public GnLogFilters info() {
    return new GnLogFilters(gnsdk_javaJNI.GnLogFilters_info(swigCPtr, this), false);
  }

  public GnLogFilters debug() {
    return new GnLogFilters(gnsdk_javaJNI.GnLogFilters_debug(swigCPtr, this), false);
  }

  public GnLogFilters all() {
    return new GnLogFilters(gnsdk_javaJNI.GnLogFilters_all(swigCPtr, this), false);
  }

}
