package com.cfox.fxrlib.service.bind;

import android.os.Bundle;
import android.os.RemoteException;

import com.cfox.fxrlib.ICallBack;
import com.cfox.fxrlib.ICreateRecorderService;
import com.cfox.fxrlib.IWaveCallBack;
import com.cfox.fxrlib.recorder.RecorderCapture;

/**
 * **********************************************
 * Project_Name: FxRecorder
 * Author : CFOX
 * Github : https://github.com/CNCFOX/FxRecorder
 * Instruction :
 * Msg:
 * **********************************************
 */
public class CreateRecorderBind extends ICreateRecorderService.Stub {
    private static final String TAG = "CreateRecorderBind";
    private RecorderCapture mRecorderCapture;

    public CreateRecorderBind(RecorderCapture recorderCapture) {
        this.mRecorderCapture = recorderCapture;
    }


    @Override
    public void startRecorder(Bundle bundle,ICallBack callback) throws RemoteException {
        mRecorderCapture.setCallBack(callback).startRecorder(null, null);
    }

    @Override
    public void startRecorderSetPath(Bundle bundle, String filePath, ICallBack callback) throws RemoteException {
        mRecorderCapture.setCallBack(callback).startRecorder(filePath, null);
    }

    @Override
    public void startRecorderSetName(Bundle bundle, String fileName, ICallBack callback) throws RemoteException {
        mRecorderCapture.setCallBack(callback).startRecorder(null, fileName);
    }

    @Override
    public void startRecorderSetPathAndName(Bundle bundle, String filePath, String fileName, ICallBack callback) throws RemoteException {
        mRecorderCapture.setCallBack(callback).startRecorder(filePath, fileName);
    }

    @Override
    public void setWaveListener(IWaveCallBack callBack) {
        mRecorderCapture.setWaveCallBack(callBack);
    }

    @Override
    public void pauseRecorder(Bundle bundle, ICallBack callback) throws RemoteException {
        mRecorderCapture.setCallBack(callback).pauseRecorder();
    }

    @Override
    public void resumeRecorder(Bundle bundle, ICallBack callback) throws RemoteException {
        mRecorderCapture.setCallBack(callback).resumeRecorder();
    }

    @Override
    public void stopRecorder(Bundle bundle, ICallBack callback) throws RemoteException {
        mRecorderCapture.setCallBack(callback).stopRecorder();
    }

    @Override
    public void getRecorderStatus(ICallBack callback) {
        mRecorderCapture.setCallBack(callback).getRecorderStatus();
    }
}
