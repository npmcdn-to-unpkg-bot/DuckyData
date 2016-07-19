/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.gracenote.gnsdk;

public class GnLocaleInfo extends GnObject {
  private long swigCPtr;

  protected GnLocaleInfo(long cPtr, boolean cMemoryOwn) {
    super(gnsdk_javaJNI.GnLocaleInfo_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(GnLocaleInfo obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        gnsdk_javaJNI.delete_GnLocaleInfo(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public GnLocaleInfo(GnLocaleGroup group, GnLanguage language, GnRegion region, GnDescriptor descriptor) {
    this(gnsdk_javaJNI.new_GnLocaleInfo(group.swigValue(), language.swigValue(), region.swigValue(), descriptor.swigValue()), true);
  }

  public GnLocaleGroup group() {
    return GnLocaleGroup.swigToEnum(gnsdk_javaJNI.GnLocaleInfo_group(swigCPtr, this));
  }

  public GnLanguage language() {
    return GnLanguage.swigToEnum(gnsdk_javaJNI.GnLocaleInfo_language(swigCPtr, this));
  }

  public GnRegion region() {
    return GnRegion.swigToEnum(gnsdk_javaJNI.GnLocaleInfo_region(swigCPtr, this));
  }

  public GnDescriptor descriptor() {
    return GnDescriptor.swigToEnum(gnsdk_javaJNI.GnLocaleInfo_descriptor(swigCPtr, this));
  }

}
