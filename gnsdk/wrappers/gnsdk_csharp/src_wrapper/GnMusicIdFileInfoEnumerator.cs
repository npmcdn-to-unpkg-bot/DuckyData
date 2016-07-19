/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

namespace GracenoteSDK {

using System;
using System.Runtime.InteropServices;

public class GnMusicIdFileInfoEnumerator : System.Collections.Generic.IEnumerator<GnMusicIdFileInfo>, IDisposable {
  private HandleRef swigCPtr;
  protected bool swigCMemOwn;

  internal GnMusicIdFileInfoEnumerator(IntPtr cPtr, bool cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = new HandleRef(this, cPtr);
  }

  internal static HandleRef getCPtr(GnMusicIdFileInfoEnumerator obj) {
    return (obj == null) ? new HandleRef(null, IntPtr.Zero) : obj.swigCPtr;
  }

  ~GnMusicIdFileInfoEnumerator() {
    Dispose();
  }

  public virtual void Dispose() {
    lock(this) {
      if (swigCPtr.Handle != IntPtr.Zero) {
        if (swigCMemOwn) {
          swigCMemOwn = false;
          gnsdk_csharp_marshalPINVOKE.delete_GnMusicIdFileInfoEnumerator(swigCPtr);
        }
        swigCPtr = new HandleRef(null, IntPtr.Zero);
      }
      GC.SuppressFinalize(this);
    }
  }

	public bool
	MoveNext( )
	{
		return hasNext( );
	}

	public GnMusicIdFileInfo Current {
		get {
			return next( );
		}
	}
	object System.Collections.IEnumerator.Current {
		get {
			return Current;
		}
	}
	public void
	Reset( )
	{
	}


  public GnMusicIdFileInfo __ref__() {
    GnMusicIdFileInfo ret = new GnMusicIdFileInfo(gnsdk_csharp_marshalPINVOKE.GnMusicIdFileInfoEnumerator___ref__(swigCPtr), false);
    if (gnsdk_csharp_marshalPINVOKE.SWIGPendingException.Pending) throw gnsdk_csharp_marshalPINVOKE.SWIGPendingException.Retrieve();
    return ret;
  }

  public GnMusicIdFileInfo next() {
    GnMusicIdFileInfo ret = new GnMusicIdFileInfo(gnsdk_csharp_marshalPINVOKE.GnMusicIdFileInfoEnumerator_next(swigCPtr), true);
    if (gnsdk_csharp_marshalPINVOKE.SWIGPendingException.Pending) throw gnsdk_csharp_marshalPINVOKE.SWIGPendingException.Retrieve();
    return ret;
  }

  public bool hasNext() {
    bool ret = gnsdk_csharp_marshalPINVOKE.GnMusicIdFileInfoEnumerator_hasNext(swigCPtr);
    return ret;
  }

  public uint distance(GnMusicIdFileInfoEnumerator itr) {
    uint ret = gnsdk_csharp_marshalPINVOKE.GnMusicIdFileInfoEnumerator_distance(swigCPtr, GnMusicIdFileInfoEnumerator.getCPtr(itr));
    if (gnsdk_csharp_marshalPINVOKE.SWIGPendingException.Pending) throw gnsdk_csharp_marshalPINVOKE.SWIGPendingException.Retrieve();
    return ret;
  }

  public GnMusicIdFileInfoEnumerator(musicid_file_info_provider provider, uint pos) : this(gnsdk_csharp_marshalPINVOKE.new_GnMusicIdFileInfoEnumerator(musicid_file_info_provider.getCPtr(provider), pos), true) {
    if (gnsdk_csharp_marshalPINVOKE.SWIGPendingException.Pending) throw gnsdk_csharp_marshalPINVOKE.SWIGPendingException.Retrieve();
  }

}

}
