/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.gracenote.gnsdk;

public class GnVideoCredit extends GnDataObject {
  private long swigCPtr;

  protected GnVideoCredit(long cPtr, boolean cMemoryOwn) {
    super(gnsdk_javaJNI.GnVideoCredit_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(GnVideoCredit obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        gnsdk_javaJNI.delete_GnVideoCredit(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public String role() {
    return gnsdk_javaJNI.GnVideoCredit_role(swigCPtr, this);
  }

  public long roleId() {
    return gnsdk_javaJNI.GnVideoCredit_roleId(swigCPtr, this);
  }

  public String roleBilling() {
    return gnsdk_javaJNI.GnVideoCredit_roleBilling(swigCPtr, this);
  }

  public String characterName() {
    return gnsdk_javaJNI.GnVideoCredit_characterName(swigCPtr, this);
  }

  public long rank() {
    return gnsdk_javaJNI.GnVideoCredit_rank(swigCPtr, this);
  }

  public String genre(GnDataLevel level) {
    return gnsdk_javaJNI.GnVideoCredit_genre(swigCPtr, this, level.swigValue());
  }

  public String artistType(GnDataLevel level) {
    return gnsdk_javaJNI.GnVideoCredit_artistType(swigCPtr, this, level.swigValue());
  }

  public String origin(GnDataLevel level) {
    return gnsdk_javaJNI.GnVideoCredit_origin(swigCPtr, this, level.swigValue());
  }

  public String era(GnDataLevel level) {
    return gnsdk_javaJNI.GnVideoCredit_era(swigCPtr, this, level.swigValue());
  }

  public GnName officialName() {
    return new GnName(gnsdk_javaJNI.GnVideoCredit_officialName(swigCPtr, this), true);
  }

  public GnContributor contributor() {
    return new GnContributor(gnsdk_javaJNI.GnVideoCredit_contributor(swigCPtr, this), true);
  }

  public GnVideoWorkIterable works() {
    return new GnVideoWorkIterable(gnsdk_javaJNI.GnVideoCredit_works(swigCPtr, this), true);
  }

  public GnVideoSeriesIterable series() {
    return new GnVideoSeriesIterable(gnsdk_javaJNI.GnVideoCredit_series(swigCPtr, this), true);
  }

  public GnVideoSeasonIterable seasons() {
    return new GnVideoSeasonIterable(gnsdk_javaJNI.GnVideoCredit_seasons(swigCPtr, this), true);
  }

}
