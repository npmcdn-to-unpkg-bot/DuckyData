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

public class GnLookupLocalStreamIngestEventsDelegate : IDisposable {
  private HandleRef swigCPtr;
  protected bool swigCMemOwn;

  internal GnLookupLocalStreamIngestEventsDelegate(IntPtr cPtr, bool cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = new HandleRef(this, cPtr);
  }

  internal static HandleRef getCPtr(GnLookupLocalStreamIngestEventsDelegate obj) {
    return (obj == null) ? new HandleRef(null, IntPtr.Zero) : obj.swigCPtr;
  }

  ~GnLookupLocalStreamIngestEventsDelegate() {
    Dispose();
  }

  public virtual void Dispose() {
    lock(this) {
      if (swigCPtr.Handle != IntPtr.Zero) {
        if (swigCMemOwn) {
          swigCMemOwn = false;
          gnsdk_csharp_marshalPINVOKE.delete_GnLookupLocalStreamIngestEventsDelegate(swigCPtr);
        }
        swigCPtr = new HandleRef(null, IntPtr.Zero);
      }
      GC.SuppressFinalize(this);
    }
  }

  public virtual void StatusEvent(GnLookupLocalStreamIngestStatus status, string bundleId, IGnCancellable canceller) {
    gnsdk_csharp_marshalPINVOKE.GnLookupLocalStreamIngestEventsDelegate_StatusEvent(swigCPtr, (int)status, bundleId, IGnCancellable.getCPtr(canceller));
    if (gnsdk_csharp_marshalPINVOKE.SWIGPendingException.Pending) throw gnsdk_csharp_marshalPINVOKE.SWIGPendingException.Retrieve();
  }

  public GnLookupLocalStreamIngestEventsDelegate() : this(gnsdk_csharp_marshalPINVOKE.new_GnLookupLocalStreamIngestEventsDelegate(), true) {
    SwigDirectorConnect();
  }

  private void SwigDirectorConnect() {
    if (SwigDerivedClassHasMethod("StatusEvent", swigMethodTypes0))
      swigDelegate0 = new SwigDelegateGnLookupLocalStreamIngestEventsDelegate_0(SwigDirectorStatusEvent);
    gnsdk_csharp_marshalPINVOKE.GnLookupLocalStreamIngestEventsDelegate_director_connect(swigCPtr, swigDelegate0);
  }

  private bool SwigDerivedClassHasMethod(string methodName, Type[] methodTypes) {
    System.Reflection.MethodInfo methodInfo = this.GetType().GetMethod(methodName, System.Reflection.BindingFlags.Public | System.Reflection.BindingFlags.NonPublic | System.Reflection.BindingFlags.Instance, null, methodTypes, null);
    bool hasDerivedMethod = methodInfo.DeclaringType.IsSubclassOf(typeof(GnLookupLocalStreamIngestEventsDelegate));
    return hasDerivedMethod;
  }

  private void SwigDirectorStatusEvent(int status, string bundleId, IntPtr canceller) {
    StatusEvent((GnLookupLocalStreamIngestStatus)status, bundleId, new IGnCancellable(canceller, false));
  }

  public delegate void SwigDelegateGnLookupLocalStreamIngestEventsDelegate_0(int status, string bundleId, IntPtr canceller);

  private SwigDelegateGnLookupLocalStreamIngestEventsDelegate_0 swigDelegate0;

  private static Type[] swigMethodTypes0 = new Type[] { typeof(GnLookupLocalStreamIngestStatus), typeof(string), typeof(IGnCancellable) };
}

}
