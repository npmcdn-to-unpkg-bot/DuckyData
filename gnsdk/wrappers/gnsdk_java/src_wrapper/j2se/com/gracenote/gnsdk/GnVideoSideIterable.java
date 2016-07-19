/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.gracenote.gnsdk;

public class GnVideoSideIterable {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected GnVideoSideIterable(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(GnVideoSideIterable obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        gnsdk_javaJNI.delete_GnVideoSideIterable(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public GnVideoSideIterable(GnVideoSideProvider provider, long start) {
    this(gnsdk_javaJNI.new_GnVideoSideIterable(GnVideoSideProvider.getCPtr(provider), provider, start), true);
  }

  public GnVideoSideIterator getIterator() {
    return new GnVideoSideIterator(gnsdk_javaJNI.GnVideoSideIterable_getIterator(swigCPtr, this), true);
  }

  public GnVideoSideIterator end() {
    return new GnVideoSideIterator(gnsdk_javaJNI.GnVideoSideIterable_end(swigCPtr, this), true);
  }

  public long count() {
    return gnsdk_javaJNI.GnVideoSideIterable_count(swigCPtr, this);
  }

  public GnVideoSideIterator at(long index) {
    return new GnVideoSideIterator(gnsdk_javaJNI.GnVideoSideIterable_at(swigCPtr, this, index), true);
  }

  public GnVideoSideIterator getByIndex(long index) {
    return new GnVideoSideIterator(gnsdk_javaJNI.GnVideoSideIterable_getByIndex(swigCPtr, this, index), true);
  }

}
